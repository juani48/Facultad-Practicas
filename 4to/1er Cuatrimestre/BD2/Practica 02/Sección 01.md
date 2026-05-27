## 1 -​ ¿Qué es Spring Data JPA? ¿Qué problema resuelve respecto de usar Hibernate directamente? Describir dos situaciones del proyecto donde Spring Data JPA simplifica código que en la Práctica 1 requería implementación manual.

Spring Data JPA es un módulo de Spring que proporciona una capa de abstracción sobre JPA (Java Persistence API). Su objetivo es reducir drásticamente la cantidad de código repetitivo necesario para implementar la capa de acceso a datos (repositorios).

Cuando se usa Hibernate directamente (sin Spring Data JPA), el desarrollador debe escribir manualmente implementaciones de DAO (Data Access Object) que incluyan:
-  Obtener y cerrar la sesión de Hibernate.
- Manejar transacciones explícitamente.
- Implementar métodos CRUD (save, findById, delete, etc.) y consultas personalizadas.

Spring Data JPA resuelve este problema generando automáticamente la implementación de los repositorios en tiempo de ejecución, a partir de interfaces que extienden JpaRepository.

## 2 - Spring Data JPA no es un ORM sino una capa de abstracción sobre el ORM. Explicar la diferencia: ¿qué hace Spring Data JPA? ¿Qué sigue haciendo Hibernate internamente?

Spring Data JPA simplifica la implementación de repositorios, facilitando la interacción con el ORM, pero es este ultimo quien realmente sigue realizando todas las tareas de bajo nivel (Escribe SQL/OQL y maneja el mapeo objeto-relacional).

## 3 -​ La siguiente tabla lista tareas relacionadas con la persistencia. Marcar con una X la columna de la tecnología que resuelve ese problema en la nueva implementación con Spring Data JPA:

| Tarea                                                   | JDBC | Hibernate | Spring Data JPA |
| ------------------------------------------------------- | ---- | --------- | --------------- |
| Abrir y cerrar la conexión a la base de datos           |      | X         |                 |
| Implementar `save()`, `findById()` y `deleteById()`     |      |           | X               |
| Gestionar el ciclo de vida de las entidades (`@Entity`) |      | X         |                 |
| Derivar una consulta a partir del nombre del método     |      |           | X               |
| Manejar el pool de conexiones                           |      | X         |                 |
| Propagar transacciones con `@Transactional`             |      |           | X               |
| Generar la implementación del repositorio en runtime    |      |           | X               |
| Mapear ResultSet a objetos Java                         |      | X         |                 |
| Proveer soporte nativo de paginación (Pageable)         |      |           | X               |
## 5 - En la Práctica 1 se configuraba Hibernate mediante una clase de configuración Java para obtener la SessionFactory. ¿Cómo se reemplaza esta configuración usando application.properties en Spring Boot?

 Spring Boot configura automáticamente un `EntityManagerFactory` (equivalente funcional a la `SessionFactory`) a partir de las propiedades definidas en application.properties. Spring Boot inyecta automáticamente un `EntityManagerFactory` en cualquier componente que lo requiera

## 6 -​ Describir las propiedades más relevantes de Spring Data JPA que deben configurarse en application.properties para este proyecto. Incluir al menos: datasource (url, username, password, driver), dialecto de Hibernate, y la propiedad que controla si Hibernate debe crear, actualizar o validar el esquema. ¿Cuál de estos valores conviene usar durante el desarrollo?

| Propiedad                                                                    | Descripción                                                                                                            | Ejemplo                               |
| ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------- | ------------------------------------- |
| `spring.datasource.url`                                                      | URL de conexión a la base de datos                                                                                     | `jdbc:mysql://localhost:3306/mi_db`   |
| `spring.datasource.username`                                                 | Usuario de la BD                                                                                                       | `root`                                |
| `spring.datasource.password`                                                 | Contraseña de la BD                                                                                                    | `secreto`                             |
| `spring.datasource.driver-class-name`                                        | Clase del driver JDBC (opcional, Spring Boot la deduce)                                                                | `com.mysql.cj.jdbc.Driver`            |
| `spring.jpa.database-platform` (o `spring.jpa.properties.hibernate.dialect`) | Dialecto de Hibernate para optimizar el SQL según el motor                                                             | `org.hibernate.dialect.MySQL8Dialect` |
| `spring.jpa.hibernate.ddl-auto`                                              | Controla la generación/actualización del esquema de BD. Valores: `none`, `validate`, `update`, `create`, `create-drop` | `update`                              |
Durante el desarrollo, lo más práctico es usar `update`, Hibernate actualiza el esquema existente (agrega nuevas tablas/columnas, pero no elimina datos ni estructuras no usadas). Es seguro y evita perder datos de prueba. Alternativamente se puede usar `create-drop`, que crea el esquema al inicio y lo destruye al finalizar la aplicación. Útil para pruebas rápidas o entornos de integración, pero **no** en desarrollo continuo porque elimina los datos cada vez que se reinicia la aplicación.

## 7 - ¿Qué es CrudRepository? ¿De qué interfaz hereda y qué operaciones provee automáticamente?

`CrudRepository` es una interfaz genérica proporcionada por Spring Data que define operaciones básicas de persistencia (CRUD) para una entidad. Hereda directamente de la interfaz `Repository` (marcador). Automáticamente provee métodos como:
- `save(Entity)`
- `findById(ID)`
- `findAll()`
- `count()`
- `delete(Entity)`, `deleteById(ID)`, `deleteAll()`
- `existsById(ID)`
## 8 -​ ¿Que agrega cada nivel de la jerarquía respecto del anterior? Describir brevemente las diferencias entre CrudRepository, PagingAndSortingRepository y JpaRepository, indicando que operaciones o capacidades incorpora cada uno

- `CrudRepository`: base de operaciones CRUD simples.
- `PagingAndSortingRepository`: extiende `CrudRepository` y agrega:
    - Paginación: `findAll(Pageable)`
    - Ordenamiento: `findAll(Sort)`
- `JpaRepository`: extiende `PagingAndSortingRepository` e incorpora métodos específicos de JPA:
    - `flush()` – sincroniza el contexto de persistencia con la BD.
    - `saveAndFlush()` – guarda y fuerza el flush inmediato.
    - `deleteInBatch()` – elimina en lote.
    - `getOne()` / `getById()` – retorna referencia proxy sin cargar datos.
    - `findAll(Example)` – consulta por ejemplo.
## 10 - ¿Cómo genera Spring Data JPA la implementación concreta de los repositorios en tiempo de ejecución? ¿Qué rol juega el proxy dinámico de Java en este mecanismo?

Spring Data JPA crea automáticamente implementaciones concretas en tiempo de ejecución usando proxies dinámicos (JDK o CGLIB). El mecanismo es:
1. En el arranque, Spring escanea (refelxion) las interfaces que extienden `Repository`.
2. Para cada una, genera un proxy (implementación dinámica) que intercepta las llamadas a los métodos.
3. El proxy delega la ejecución a una clase base por defecto (`SimpleJpaRepository`), que contiene la lógica real de los métodos CRUD y de consulta.
4. Para métodos personalizados (ej. `findByNombre`), el proxy analiza el nombre del método, construye la consulta JPQL y la ejecuta mediante `EntityManager`.

**Rol del proxy**: actuar como fachada que separa la interfaz del repositorio de la implementación concreta, permitiendo inyectar comportamiento transversal (transacciones, traducción de excepciones, caché) sin modificar el código del usuario.

> [!NOTE]
> Reflexion: La capacidad de un programa para examinar y modificar su propio código mientras se está ejecutando.
## 11 - ¿Que diferencia hay entre save() en Spring Data JPA y session.save() / session.merge() en Hibernate directo? ¿Cómo decide Spring Data JPA si debe hacer un INSERT o un UPDATE?
Diferencias:
- `session.save()` (Hibernate) → siempre genera un INSERT inmediato, devuelve el ID generado. Si la entidad ya tiene ID, igual fuerza insert (puede causar excepción).
- `session.merge()` → copia el estado de la entidad desconectada a una instancia persistente (recupera o crea una), realizando UPDATE o INSERT según corresponda.
- `save()` de Spring Data JPA → actúa de forma inteligente combinando `persist` (insert) y `merge` (update) según si la entidad es nueva o no.

Decisión: 
Spring Data JPA verifica si la entidad es new (no persistida aún). Utiliza una de estas estrategias:
- Por defecto: inspecciona el valor del ID (campo anotado con @Id).
	- Si el ID es null (o valor por defecto para tipos primitivos: 0, false) → considera la entidad nueva → llama a EntityManager.persist() (INSERT).
	- Si el ID no es null → considera existente → llama a EntityManager.merge() (UPDATE).
- Si la entidad implementa Persistable, se delega en el método isNew() para decidir.
- Si se usa @Version (control de concurrencia), Spring Data también lo tiene en cuenta.

Este comportamiento evita la rigidez de save() de Hibernate y la necesidad de usar explícitamente merge(), proporcionando un save() único que funciona para altas y modificaciones.