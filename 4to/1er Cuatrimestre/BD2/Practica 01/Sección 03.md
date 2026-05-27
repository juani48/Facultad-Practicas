## 39 - ​Definir el patrón DAO (Data Access Object) y el patrón Repository. ¿Cuál es la diferencia conceptual más importante entre ambos? ¿En qué se diferencia su rol dentro de la arquitectura de la aplicación?

El patrón DAO proporciona una abstracción sobre el mecanismo de persistencia. Encapsula todas las operaciones CRUD para una entidad o tabla específica, esto provoca que haya dos clases de un mismo objeto, donde en una se encapsulan todo el comportamiento de persistencia y otra donde de almacenan los datos a persistir. El DAO suele estar fuertemente ligado a la tecnología de persistencia trabajando a un nivel cercano a la base de datos.

El patrón Repository actúa como una colección de objetos de dominio. Posee una interfaz que oculta por completo los detalles de persistencia y esta interfaz permite a los servicios interactuar con el repositorio  en términos de dominio de objetos.

El DAO gestiona la interacción directa con la fuente de datos; el Repository gestiona el acceso a los objetos de dominio, siendo una abstracción más semántica y alineada con el negocio.

## 40 - ​El patrón Repository puede pensarse como una colección de objetos en memoria que además persiste su estado. Describir cómo se implementa este concepto usando Hibernate: ¿qué responsabilidades concentra un repositorio? ¿Con qué objeto de Hibernate interactúa internamente?

Cuando se utiliza Hibernate, el repositorio se implementa como una clase que ofrece métodos con significado de dominio (como `getOrdersByUser(userId)`) y que internamente delega en el `Session` de Hibernate. Las responsabilidades que concentra un repositorio con Hibernate son:
- Abstracción de la colección en memoria: El repositorio expone métodos que simulan operaciones sobre una colección de agregados.
- Gestión del ciclo de vida de las entidades: Utilzia el `Session` para persistir, actualizar, recuperar y eliminar entidades.
- Encapsulación de consultas.

En una implementación típica, el repositorio recibe una instancia de `Session` o `EntityManager` mediante inyección de dependencias o se obtiene de un `SessionFactory`. 

## 41 - ​Implementar un repositorio por cada entidad del modelo (`PurchaseRepository`, `RouteRepository`, `UserRepository`, `ServiceRepository`, `SupplierRepository`, `ReviewRepository`). Cada repositorio debe incluir al menos las operaciones básicas: guardar, buscar por ID, listar todos y eliminar. Utilizar la Session de Hibernate en cada implementación, tal como se ha explicado previamente utilizando el método `getCurrentSession()` sobre la `SessionFactory` (genere una inyección de este objeto tal como se muestra en el código de ejemplo proporcionado).

## 42 - ​¿Que es una transacción en el contexto de Hibernate? ¿Por qué es necesaria? ¿Qué ocurre si se realizan operaciones de escritura sin una transacción activa?

En Hibernate (y en general en JPA), una transacción es una unidad lógica de trabajo que agrupa una o más operaciones de persistencia (inserciones, actualizaciones, eliminaciones) garantizando las propiedades ACID (Atomicidad, Consistencia, Aislamiento, Durabilidad). A nivel práctico, se representa mediante la interfaz `Transaction` y su ciclo típico incluye `begin()`, `commit()` y `rollback()`.

Las transacciónes son necesarias porque garantizan las porpiedades ACID:
- Atomicidad: Permite que un conjunto de operaciones se ejecute completamente o ninguna. Si falla una, se deshacen todas.
- Consistencia: Asegura que la base de datos pase de un estado válido a otro, respetando restricciones (claves únicas, integridad referencial, etc.).
- Aislamiento: Los cambios intermedios no son visibles para otras transacciones hasta el commit, evitando lecturas sucias.
- Durabilidad: Una vez confirmada (commit), los cambios persisten incluso ante fallos del sistema.

Ademas, con el uso de Hibernate y las transacciones hay una sincronización con la base de datos, Hibernate retrasa la escritura (write-behind) y solo envía los SQL al flush previo al commit. Sin transacción, no hay un punto claro para confirmar los cambios. Por lo que realizar operaciones de escritura sin una transacción activa producirá una excepción o los cambios no se persistirán permanentemente.

## 43 - ​¿En qué capa de la aplicación debería gestionarse la transacción: en el repositorio o en la capa de servicio? Justificar la elección. ¿Qué ocurre si una misma operación necesita de varios accesos a la base de datos?

La transacción debe gestionarse en la capa de servicio, no en el repositorio. La principal razon es la separación de responsabilidades o principio de única responsabilidad, que permite que el repositorio solo se encargue dle acceso y persistencia de datos; y donde la capa de servicio define los casos de uso de negocio, donde se determina qué operaciones forman una unidad lógica de trabajo que debe ser atómica.

Ademas, definir las transacciones en el servicio permite agrupas varios metodos del repositorio en un transaccion, ofreciendo flexibilidad a la hora de gestionar operaciones propias del dominio que incluyan varias operaciones que interactuen con la base de datos.

Cuando una operación de negocio requiere varios accesos a la base de datos (por ejemplo, leer un valor, actualizar dos tablas diferentes, o insertar un registro y luego actualizar otro), es imprescindible que todos esos accesos se ejecuten dentro de la misma transacción.

## 44 - ​Implementar una capa de servicio que coordine las operaciones del modelo usando transacciones correctamente. Como mínimo implementar:​
### A - Creación de todas las entidades persistentes. ​


### B - Actualización del precio de un servicio existente.​


### C - Agregar un nuevo ítem a una compra existente.​


### D - Eliminar una ruta existente siempre que no tenga compras asociadas.

## 45 - ​¿Que diferencia hay entre HQL/JPQL y SQL nativo? ¿Qué entidades, atributos y relaciones entienden HQL/JPQL que SQL no conoce directamente?

La diferencia entre HQL/JPQL y SQL nativo es fundamentalmente del nivel de abstracción y el modelo con el que interactuan. SQL opera directamente sobre el modelo relacional (tablas, columnas y claves), mientras que HQL/JPQL interactua con el modelo de objetos del dominio y Hibernate/JPA se encargar de traducir las consultas en HQL/JPQL a SQL.

HQL/JPQL puede entender entidades, atributos, relaciones y herencia entre entidades dentro de consultas, puediendo realizar navegacion entre atributos.
