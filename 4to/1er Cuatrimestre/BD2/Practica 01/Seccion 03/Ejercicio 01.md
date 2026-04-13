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


