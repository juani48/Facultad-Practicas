## 1 - ¿Qué problema concreto resuelve un ORM? Describir al menos 3 (tres) inconvenientes que aparecen al intentar persistir objetos directamente con JDBC puro.

Un ORM resuelve la diferencia de impedancia, que son las diferencias existentes al intentar hacer coexistir dos tecnologías diferentes, específicamente el paradigma relacional con el paradigma orientado a objetos. Los incovenientes que surgen de intentar juntar estas dos tecnológicas son:
- Requiere escribir de forma reiterada la lógica necesaria para establecer conexiones, ejecutar consultas y procesar resultados.
- La conversión entre estructuras del modelo orientado a objetos y el modelo relacional debe realizarse manualmente.
- Las asociaciones entre objetos deben resolverse explícitamente mediante consultas SQL.
- El programador debe controlar manualmente los límites transaccionales.
- Obliga a trabajar directamente con SQL y estructuras relacionales, generando un acoplamiento fuerte entre la lógica de negocio y la capa de persistencia.
- Requiere gestionar explícitamente excepciones y liberación de recursos, lo que aumenta la verbosidad.

## 2 -​ El modelo relacional y el modelo OO presentan tensiones conocidas como impedance mismatch. Identificar cómo se manifiesta cada una en el modelo dado:
### A -​ Identidad: cómo es posible identificar un objeto Purchase en Java vs. en la base de datos?

Los objetos son identificados por su OID, siendo este un ID que ayuda a identificar unívocamente a una instancia en todo el sistema. Mientras que en las bases de datos relacionales cada entidad tiene su identidad definida en base a sus atributos y dicho identificador (clave primaria) suele restringirse a la tabla a la que pertenece, pudiendo repetirse el mismo identificador para diferentes tablas y pudiendo identificar tuplas en base a identificadores de otras tuplas (claves foráneas).

### B -​ Relaciones: cómo se navega de una Purchase a sus ItemService en Java vs. en SQL?

En el paradigma de objetos el acceso a la información es a través de la navegación los atributos de las instancias de los objetos, mientras que en relacional la forma es a través de joins entre diferentes tablas

### C -​ Herencia: ¿cómo podría representarse la jerarquía User/DriverUser/TourGuideUser en una tabla relacional?

Para representar dicha jerarquía existen tres técnicas, con las cuales pasar la jerarquía a un modelo relacional. Estas técnicas dependen de la representar interna de los datos y de la semántica de estos:
- Table per class: Se elimina la clase de la parte superior de la jerarquía, bajando los atributos a las partes inferiores de esta, haciendo así que se repita la información entre ambas tablas (la información que se encontraba en la super clase) pero condensando esta en una única consulta.
- Single table: Eliminar las sub clases y subir dichos atributos a la super clase, settenadolos como opcionales mas un indicador del tipo, que ayude a distinguir el tipo de clase que se quiere representar y una vez conociendo esto, acceder a los atributos opcionales, seguro de que estos no son nulos.
- Joined: Dejar toda la jerarquía y adicionar a las sub clases una clave foranea de su super clase para, en este caso, realizar dos consultas para acceder a toda la información de una de las clases.

### D -​ Ciclos de referencia: ¿existe algún ciclo en el modelo? ¿Cómo impacta en la persistencia?

Sí, en un modelo orientado a objetos pueden existir ciclos de referencia, es decir, situaciones en las que dos o más objetos se referencian mutuamente (por ejemplo, A referencia a B y B referencia a A). Estos ciclos impactan en la persistencia, complejizando el mapeo de los objetos a relaciones, debido a que se deben tener en cuenta el orden de inserción adecuado para respetar, no solo la semántica de los objetos, sino también las restricciones de integridad de estos. 

## 3 -​ Describir las ventajas y desventajas concretas de usar un ORM en un proyecto como este.

Ventajas:
- Abstracción del acceso a datos.
- Reducción de código repetitivo.
- Mayor mantenibilidad.
- Gestión de relaciones y cascadas.
- Manejo automático de transacciones.

Desventajas:
- Pérdida de control sobre SQL.
- Sobrecarga y menor rendimiento.

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

## 9 -​ Describir los cuatro estados posibles de una entidad en Hibernate (`transient`, `managed`, `detached`, `removed`) e indicar qué operación dispara cada transición entre ellos.

- **Transient (Transitorio):** Es el estado inicial de un objeto recién instanciado con el operador `new`. En este estado, la entidad no está asociada a ninguna sesión (persistence context) de Hibernate y, por lo tanto, no tiene representación en la base de datos. Cualquier cambio en este objeto no afecta a la base de datos, ya que Hibernate no lo está rastreando.

- **Managed (Administrado / Persistente):** Una entidad pasa a este estado cuando se asocia a una sesión abierta de Hibernate. En este estado, la entidad tiene una representación en la base de datos y Hibernate rastrea todos sus cambios. Cualquier modificación en sus propiedades se sincronizará automáticamente con la base de datos durante el próximo `flush` (o al hacer `commit` de la transacción).

- **Detached (Desprendido):** Una entidad `managed` entra en estado `detached` cuando la sesión con la que estaba asociada se cierra (`session.close()`) o se limpia (`session.clear()`). También se puede desprender un objeto específico con `session.detach(entity)` o `session.evict(entity)`. El objeto sigue existiendo en memoria y aún tiene un identificador persistente (ID) que apunta a un registro en la base de datos. Sin embargo, ya no está siendo rastreado por Hibernate, por lo que los cambios que se le hagan no se reflejarán en la base de datos a menos que se vuelva a asociar (`reattach`) a una sesión nueva con `merge()` o `update()`.

- **Removed (Eliminado):** Este estado representa una entidad que ha sido marcada para ser eliminada de la base de datos. Esto ocurre cuando se llama al método `remove()` (en `EntityManager`) o `delete()` (en `Session` de Hibernate) sobre una entidad en estado `managed` o `detached`. La entidad sigue estando asociada a la sesión, pero está programada para su borrado. La sentencia `DELETE` correspondiente se ejecutará durante el `flush` de la sesión. Una vez eliminada de la base de datos, la entidad queda `detached` (o `transient` si se elimina su referencia).

## 10 - ​Describir el ciclo de vida completo de una entidad persistente, tome como ejemplo un objeto de la clase Purchase: desde que se instancia con `new`, pasando por su persistencia, hasta que se elimina. Indicar explícitamente en qué estado se encuentra el objeto en cada paso.

1. Creación con new: Transient
```java
Purchase purchase = new Purchase();
purchase.setCode("P001");
```
Si se llama a entityManager.persist(purchase) en este estado, la entidad pasará a ser Managed.

2. Persistencia: Managed
```java
entityManager.persist(purchase);
```
3. Confirmación de la transacción: Managed (persistencia efectiva)
```java
transaction.commit(); // o entityManager.flush()
```

4. Desconexión explícita o cierre del contexto: Detached
```java
entityManager.detach(purchase);
// o entityManager.clear(), o entityManager.close()
```
Puede volver a asociarse (volver a Managed) mediante entityManager.merge(purchase).

5. Reasociación: Managed
```java
Purchase managedPurchase = entityManager.merge(purchase);
```
`merge` copia el estado del objeto detached a una nueva instancia managed. El objeto original sigue siendo detached; el retornado es managed.

6. Eliminación: Removed, luego de commit vuelve a Transient
```java
entityManager.remove(managedPurchase);
```
La entidad en estado Managed, pasa al estado Removed. La instancia pasa a ser Transient (aunque su identidad ya no existe en la BD). Si se quiere volver a persistir, se debe usar una nueva instancia.

## 11 - ​Investigue sobre los métodos de `Session`: `session.save()`, `session.persist()`, `session.merge()` y `session.saveOrUpdate()`. ¿Qué permite hacer cada uno y cuál es la diferencia entre ellos? Indicar en qué estado debe estar un objeto para usar cada uno correctamente.

Estos métodos se utilizan para cambiar el estado de las entidades y sincronizarlas con la base de datos. 

| Método               | Propósito Principal                                                 | Estado del Objeto Requerido                                                                                                                                         | Efecto y Estado Resultante                                                                                                                                                                      | Retorno                           |
| -------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------- |
| **`persist()`**      | Hacer "managed" un objeto "transient".                              | **Transient**                                                                                                                                                       | Inserta en BD. El objeto se vuelve **Managed**[](https://www.geeksforgeeks.org/advance-java/hibernate-lifecycle/).                                                                              | `void`                            |
| **`save()`**         | Hacer "managed" un objeto "transient".                              | **Transient**                                                                                                                                                       | Inserta en BD. El objeto se vuelve **Managed**.                                                                                                                                                 | `Serializable` (el ID generado)   |
| **`merge()`**        | Copiar el estado de un objeto "detached" a una instancia "managed". | Principalmente **Detached** (también funciona con "transient")[](https://deepwiki.com/detafti/java-persistence-spring-data-hibernate/2-jpahibernate-core-concepts). | Copia los datos y devuelve una instancia **Managed**. El objeto original permanece **Detached**[](https://docs.hibernate.org/stable/core.old/reference/en/html/objectstate-saveorupdate.html).  | `Object` (la instancia "managed") |
| **`saveOrUpdate()`** | Método "inteligente" que decide entre `save()` o `update()`.        | **Transient** o **Detached**[](https://docs.hibernate.org/stable/core.old/reference/en/html/objectstate-saveorupdate.html).                                         | Inserta si es "transient" o actualiza/reaplica si es "detached". El objeto se vuelve **Managed**[](https://docs.hibernate.org/stable/core.old/reference/en/html/objectstate-saveorupdate.html). | `void`                            |
