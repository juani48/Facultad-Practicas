## 4 - ¿Qué es JPA? ¿Qué nos permite definir? ¿Por qué se dice que es una especificación y no una implementación?

JPA o Java Persistence API es un estándar para Java de persistencia. JPA es un conjunto de definiciones/especificaciones que define como manejar la persistencia de objetos en aplicaciones Java. JPA nos permite definir una serie de etiquetas/anotaciones para definir:
- Las entidades de la base de datos (`@Entity`).
- Las relaciones entre entidades (`@OneToMany`, `@ManyToOne`, `@OneToOne`, `@ManyToMany`). 
- Claves primarias y estrategias de generación de dichas clases (`@GeneratedValue`).
- Mapeo de columnas y sus propiedades (`@Column`).
- Consultas (Con JPQL, Java Persistence Query Language).
- Eventos del ciclo de vida (`@PrePersist`, `@PostLoad`, `@PreUpdate`).
- Herencia y relaciones de tablas (`@Inheritance`, `@DiscriminatorColumn`).
- Transacciones y contexto de persistencia (`EntityManager`, `EntityTransaction`).

Se considera a JPA un conjunto de especificaciones porque indica como otros ORM de Java deben presentar su interfaz (que métodos y anotaciones deben existir) para así permitir al desarrollador poder cambiar de implementación (ORM) y mantener el formato de anotaciones en todas sus clases. JPA no inidica como estos metodos deben funcionar internamente.

## 5 - ¿Cuál es la relación entre JPA e Hibernate? ¿Puede usarse JPA sin Hibernate o Hibernate sin JPA?

JPA fue creado después de la existencia de Hibernate, por lo que está basado principalmente en este. Puede usarse Hibernate sin JPA dado que Hibernate posee su propia API para anotaciones. Pero no es posible usar JPA sin Hibernate o en su defecto sin ningún ORM dado que JPA es un estándar y no una implementación concreta de un ORM.

## 6 - ¿Qué es la SessionFactory? ¿Qué patrón de diseño implementa? Justificar por qué se crea una sola instancia durante todo el ciclo de vida de la aplicación y no una por operación.

La SessionFactory es una caché de segundo nivel de mapeos compilados para una base de datos, además su función es permitir la creación de sesiones de trabajo. Una Session representa una “conversación” entre la aplicación y el almacenamiento persistente, permite persistir y recuperar objetos y crear transacciones; además mantiene una caché de objetos persistentes, usada cuando se navega el grafo de objetos o para buscar objetos por identificador.

SessionFactory implementa el patrón Abstract Factory, dado que crea familias de objetos relacionados (las sesiones), encapsula la lógica de creación (no se necesita saber cómo se construye una Session) y devuelve interfaces/abstracciones (Session es una interfaz, no una clase concreta, permitiendo cambiar la implementación). También podría considerarse que implementa el patrón Singleton en cuanto a su uso típico (una única instancia global), pero no es un Singleton de diseño puro porque la clase en sí no fuerza una única instancia; es la aplicación la que la maneja como Singleton. Es creación de una única instancia de Abstract Factory se da porque su creación extremadamente costosa (implicando leer archivos de configuración y escanear todas las clases `@Entity`), es thread-safe y diseñada para ser compartida (diseñada para ser accedida concurrentemente por múltiples hilos) y la caché de segundo nivel (la caché de segundo nivel se almacena en SessionFactory, si hubiera múltiples instancias, cada una tendría su propia caché).

## 7 -​ La SessionFactory ofrece dos formas de obtener una Session: openSession() y getCurrentSession(). Responder:

### A -​ ¿Cuál es la diferencia entre ambos métodos? ¿Qué ocurre con el ciclo de vida de la Session en cada caso?

| Aspecto               | `openSession()`                                                                                                                | `getCurrentSession()`                                                                                 |
| --------------------- | ------------------------------------------------------------------------------------------------------------------------------ | ----------------------------------------------------------------------------------------------------- |
| **Creación**          | Siempre crea una nueva instancia de `Session`                                                                                  | Obtiene la `Session` vinculada al contexto actual (por defecto, el hilo de ejecución)                 |
| **Cierre automático** | No se cierra automáticamente. Debes llamar explícitamente a `session.close()`                                                  | Se cierra automáticamente al finalizar la transacción (commit/rollback)                               |
| **Transacción**       | No requiere una transacción activa para operar. Puedes usarla sin transacción para lecturas, pero no es seguro para escrituras | Requiere una transacción activa. Si no hay transacción, lanza excepción                               |
| **Ciclo de vida**     | Gestionado por el desarrollador, debe abrirse y cerrarse explícitamente.                                                       | Gestionado por Hibernate, se abre al inicio de la transacción y se cierra al finalizar la transacción |

### B -​ ¿Qué condición debe cumplirse para poder usar getCurrentSession()? ¿Que configuración requiere en Hibernate?

Para utilizar `getCurrentSession()` es necesario configurar explícitamente el contexto de sesión actual en el archivo de configuración, ya que sin esta propiedad lanzará una excepción indicando que no hay un contexto configurado. La configuración requerida en el archivo `hibernate.cfg.xml` consiste en añadir la propiedad `hibernate.current_session_context_class` y asignarle un valor específico según el entorno de ejecución, si es un entorno de un solo hilo se debe establecer el valor `thread`, si es un entorno con JTA (Transaction Manager) se debe establecer el valor `jta`, lo que vincula la sesión al ciclo de vida de la transacción JTA. 

Una vez configurada esta propiedad, el método `getCurrentSession()` gestiona automáticamente la creación, vaciado y cierre de la sesión vinculada al contexto actual (hilos o transacciones), eliminando la necesidad de cerrarla manualmente como ocurre con `openSession()`.

### C -​ ¿Quién es responsable de cerrar la `Session` cuando se usa `getCurrentSession()`? ¿Y cuando se usa `s()`?

En `getCurrentSession()` el responsable es Hibernate que gestiona internamente la apertura y cierre de la sesion, en cambio con `openSession()` debe ser gestionada explícitamente por el desarrollador.

### D -​ ¿Cuál de los dos métodos resulta más adecuado para usar en los repositorios de esta práctica y por qué?

El mas adecuado es `getCurrentSession()`, dado que Spring configura automáticamente `hibernate.current_session_context_class` sobrescribiendo el contexto de sesión actual de Hibernate con su propia implementación (`org.springframework.orm.hibernate5.SpringSessionContext`) vincula automáticamente una `Session` al hilo actual al iniciar una transacción (cuando un método esta anotado con `@Transactional`). Ademas de que Spring gestionará automáticamente la apertura y cierre de la sesión. 

## 8 -​ Completar la tabla comparativa entre JPA e Hibernate:

| Aspecto                                   | JPA                                                                                                                                                                                        | Hibernate                                                                                                                                                    |
| ----------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Tipo                                      | Especificación (estándar de Java)                                                                                                                                                          | Implementación concreta (framework ORM)                                                                                                                      |
| Define interfaces y anotaciones           | Sí, define las interfaces y anotaciones estándar como `@Entity`, `EntityManager`, basándose en Hibernate pero con menor cantidad de definiciones dado que Hibernate es una implementación. | Posee su propio conjunto de anotaciones, respetando las anotaciones definidas en JPA (dado que este está basado en Hibernate) y agregando las suyas propias. |
| Proporciona implementación concretas      | No (solo define el contrato, no provee código ejecutable)                                                                                                                                  | Sí (provee clases concretas como `SessionImpl`, `SessionFactoryImpl`, etc.)                                                                                  |
| Genera SQL a partir de consultas JPQL/HQL | No (solo define el lenguaje JPQL, no lo ejecuta ni traduce)                                                                                                                                | Sí (traduce JPQL (y su propio HQL) a SQL nativo del dialecto configurado)                                                                                    |
| Maneja el Persistence Context             | Define la interfaz `EntityManager` y el concepto de contexto de persistencia                                                                                                               | Implementa el manejo concreto mediante `Session` (que actúa como `EntityManager` con funcionalidades adicionales)                                            |
