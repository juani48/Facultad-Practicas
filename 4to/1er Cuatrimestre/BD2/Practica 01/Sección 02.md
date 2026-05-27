## 12 - ​¿Cuál es el conjunto mínimo de anotaciones que debe tener una clase para ser persistente con JPA?

Para que JPA persista una clase, esta debe tener como minimo una anotacion `@Entity` que indica que la clase es una entidad JPA y `@Id` que define la clave primaria de la entidad.

No se requieren otras anotaciones como @Table ni @Column. La clase debe tener un constructor sin argumentos, pero esto no es una anotación, es un requisito implícito de JPA.

## 13 - ​¿Qué significa que JPA use persistencia por alcance (persistence by reachability)? ¿Qué consecuencia tiene si un objeto referenciado no está todavía persistido?

En JPA, la persistencia por alcance significa que el estado de persistencia de un objeto se propaga a otros objetos que son alcanzables desde él. Si una entidad se vuelve managed y desde ella se puede acceder a otra entidad a través de una relación, el proveedor JPA se encargará automáticamente de persistir también esa entidad referenciada.

La consecuencia de que un objeto referenciado no esté todavía persistido (es decir, sea transitorio o detached) es que al intentar persistir la entidad raíz se producirá un error. Normalmente, el proveedor JPA lanzará una excepción indicando que la entidad referenciada es transient y no puede ser gestionada automáticamente.

## 14 - ​¿Qué diferencia hay entre las estrategias `IDENTITY`, `SEQUENCE` y `TABLE` para la generación de IDs? ¿Cuál tiene mejor rendimiento en inserciones masivas y por qué?

- `IDENTITY`: Es una propiedad vinculada directamente a una columna de una sola tabla, generando valores automáticamente al insertar filas. Deshabilita el batch de JDBC (las inserciones se ejecutan una a una). Además, el ID no se conoce hasta después del `INSERT`, lo que impide optimizaciones.
- `SEQUENCE`: Es un objeto independiente que genera una secuencia de números bajo demanda, permitiendo su reutilización en varias tablas y un control total sobre el valor inicial, incremento y reinicio. Se puede obtiener el ID antes de la inserción llamando a la secuencia. Permite batch de inserciones (inserción por lotes).
- `TABLE`: Esta estrategia no depende de funciones nativas del motor de base de datos, sino que crea una tabla auxiliar específica para almacenar y actualizar el último ID utilizado. Es principalmente una solución de portabilidad para entornos donde no se disponen de `SEQUENCE` nativas, pero suele tener un rendimiento inferior debido a la necesidad de operaciones de lectura y escritura adicionales en la tabla de control. 

La estrategia `SEQUENCE` es la que ofrece mejor rendimiento en inserciones masivas por permitir el uso de batch (inserción por lotes), al conocer el ID antes de realizar la inserción, Hibernate puede agrupar varias sentencias `INSERT` en un mismo lote, reduciendo drásticamente el número de consultas a la base de datos.

## 15 - ​Implementar el mapeo completo de la entidad Service según el diagrama. La implementación debe incluir:

### E -​ Clave primaria con estrategia de generación automática. Elegir entre IDENTITY, SEQUENCE o TABLE y justificar la elección.
### F -​ Atributos: name (no nulo, max. 100 caracteres), description (opcional), price (no nulo).
### G -​ Al menos una restricción de unicidad a nivel de columna.

```java
@Entity(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "price", nullable = false)
    private float price;

    @Column(name = "description", nullable = true, length = 300)
    private String description;

    // ...
}
```

Elegí `IDENTITY` porque considera que la inserción de objetos `Service` no se hará en grandes volúmenes, por lo que no es necesario tener control o eficiencia en inserciones por lotes.

## 16 - ​Para la relación `Purchase` -> `ItemService` (composición uno-a-muchos):
### h -​ ¿Qué anotaciones se necesitan en cada lado?

- En la clase `Purchase`: `@OneToMany(mappedBy = "purchase")` sobre la colección de ItemService.

- En la clase `ItemService`: `@ManyToOne` y `@JoinColumn(name = "purchase_id", nullable = false)` sobre la referencia a Purchase.

### I -​ ¿Qué columna o tabla aparece en la base de datos para representar esta relación?

Aparece una columna de clave foránea en la tabla mapeada de `ItemService`. Dicha columna, se llamara purchase_id y almacena la clave primaria de `Purchase` y no puede ser nula. No se crea una tabla intermedia adicional.

### J - ¿Qué es mappedBy y en qué lado de la relación va? ¿Qué ocurre si se omite en ambos lados?

`mappedBy` es un atributo de `@OneToMany` que indica que el lado inverso (el lado `@ManyToOne`) es el propietario de la relación. Se coloca en el lado uno (`Purchase`).

Si se omite `mappedBy` en ambos lados (es decir, `@OneToMany` sin `mappedBy` y `@ManyToOne` sin `@JoinColumn` explícito), JPA tratará la relación como unidireccional desde `Purchase` y creará por defecto una tabla de unión (join table) en lugar de usar una clave foránea en `ItemService`. Si además se incluye `@ManyToOne`, pueden ocurrir conflictos o mapeos redundantes.

### K -​ ¿Es esta relación bidireccional o unidireccional según el diagrama? ¿Cómo se refleja en el código Java?

Es una relación de composición y se modela como bidireccional para facilitar la navegación desde el todo a las partes y viceversa.

## 17 - ​Para las relaciones `Route` <-> `DriverUser` y `Route` <-> `TourGuideUser` (muchos-a-muchos):
### L -​ ¿Qué anotaciones se usan?

En cada entidad se usa `@ManyToMany`. En el lado propietario (en este caso `Route`) se añade `@JoinTable` para definir la tabla intermedia. En el lado inverso (`DriverUser` y `TourGuideUser`) se usa `mappedBy` para indicar que el otro lado (`Route`) es el propietario.

### M - ¿Qué tabla adicional genera JPA? ¿Qué columnas tiene? Definirla explícitamente usando @JoinTable.

Para cada relación, JPA genera una tabla de unión (join table) independiente:

- Para `Route` - `DriverUser`: tabla `route_driver`
    - Columnas:
        - `route_id` (clave foránea a `route`)
        - `driver_user_id` (clave foránea a `driver_user`)
    - Definición explícita:
```java
@ManyToMany
@JoinTable(
    name = "route_driver",
    joinColumns = @JoinColumn(name = "route_id"),
    inverseJoinColumns = @JoinColumn(name = "driver_user_id")
)
private List<DriverUser> drivers;
```
- Para `Route` - `TourGuideUser`: tabla `route_tourguide`
    - Columnas:
        - `route_id` (clave foránea a `route`)
        - `tourguide_user_id` (clave foránea a `tourguide_user`)
    - Definición explícita:
```java
@ManyToMany
@JoinTable(
    name = "route_tourguide",
    joinColumns = @JoinColumn(name = "route_id"),
    inverseJoinColumns = @JoinColumn(name = "tourguide_user_id")
)
private List<TourGuideUser> tourGuides;
```
### N -​ ¿Pueden ambas relaciones compartir la misma tabla join? ¿Por qué?

No, no solo porque JPA no permita mapear dos asociaciones distintas sobre la misma tabla intermedia porque no sabría cómo distinguir qué fila pertenece a qué relación, sino porque generaria repeticion inecesaria de datos si se posee la misma route con el mismo tourguide_user y diferentes driver_user, repitiendo los id de los driver_user. 

## 18 - ​La relación Purchase -> Review es opcional (0..1). Implementar el mapeo de ambos lados. ¿Cómo se representa la opcionalidad en JPA?

Se representa medainte el atributo `optional = true` dentro de `@OneToOne`.


## 19 - ​ItemService referencia a Service (muchos-a-uno). Analizar el diagrama: ¿es navegable esta relación desde Service hacia ItemService? Justificar si conviene hacerla bidireccional o no.

Si, conviene hacerla bidireccional para poder conocer desde un Service todos sus ItemService y desde un ItemService conocer su Service a la hora de realizar consultas. Por ejemplo la navegacion podria comenzar desde un Supplier para conocer los Services que ofrece y conocer asi sus ItemService o podria pasar que desde un Purchase se desea conocer mediante los ItemService los Service que tiene asociado.

## 20 - ​Implementar el mapeo completo de las siguientes entidades con todas sus relaciones, siguiendo las anotaciones y decisiones discutidas: Supplier, Purchase, ItemService, Route, Stop y Review. Para cada relación bidireccional, incluir las anotaciones en ambos lados.

## 21. - ¿Para qué sirve la propiedad fetch en las anotaciones de relación? ¿Cuáles son los valores posibles? ¿Cuál es el valor por defecto para @OneToMany, para @ManyToOne y para @ManyToMany?

La propiedad fetch (o FetchType) en JPA sirve para especificar cuándo debe cargarse la entidad asociada desde la base de datos. Los valores posibles para esta propiedad son:

- `FetchType.EAGER` (Carga inmediata): La entidad relacionada se carga en el mismo momento que la entidad principal, ejecutando un JOIN. Este es el comportamiento por defecto para relaciones `@ManyToOne` y `@OneToOne`.
- `FetchType.LAZY` (Carga diferida): La entidad relacionada se carga solo cuando se accede a ella mediante su getter, generando una consulta adicional (a menudo usando un proxy).  Este es el comportamiento por defecto para relaciones `@OneToMany` y `@ManyToMany`.

## 22 - ​Describir ventajas y desventajas concretas de EAGER y LAZY, en términos de performance de acceso como de espacio en memoria. ¿Por qué configurar EAGER en todas las relaciones suele ser una mala idea en aplicaciones reales?

EAGER ofrece la obtención de varios objetos de forma inmediata, pero trayendo probablemente objetos innecesarios, con consultas que pueden volverse más pesadas y cargando la memoria de objetos que no se utilizaran.

LAZY permite no sobrecargar la memoria con objetos que no seran utilizados con consultas más livianas, pero requiere utilizar proxys y cache para verificar que un objeto no se encuentra cargado en memoria y requiere realizar consultas adicionales para traerlo de la base de datos.

Configurar EAGER en todas las relaciones puede provocar que de una única consulta, se retorne todo el grafo de objetos y muy probablemente, sea información innecesaria traída de la base de datos, provocando que se realicen consultas extras innecesarias.

## 23 - ​Para cada relación del modelo, elegir el FetchType más adecuado y justificar. Luego implemente su decisión en el proyecto tours.

Dejaría por defecto leas propiedades según la relación (`LAZY` para relaciones `@OneToMany` y `@ManyToMany` y `EAGER` para `@ManyToOne` o `@OneToOne`), provocando que las entidades que poseen un composición de otro objeto ( como por ejemplo que un ItemService conoce a un Service y a un Purchase) me traigan esa entidad de la que "dependen" (porque este objeto que poseen enlazado es parte de la definición de la entidad) y que solo las entidades que poseen una lista de de otras entidades sean cargadas bajo demanda, debido a que no siempre se querrá traer un objeto y acceder inmediatamente a su lista de entidades.

## 24 - ​¿Cómo podría producirse una `LazyInitializationException` en el modelo? Investigue de qué representa esta excepción y escribir un escenario concreto explicando al menos formas de resolverlo sin cambiar el FetchType a EAGER.  

La `LazyInitializationException` ocurre cuando se intenta acceder a una entidad o colección con carga `LAZY`, después de que la sesión o el `EntityManager` que la gestionaba ya se ha cerrado. Esencialmente, el proxy no puede inicializarse porque el contexto de persistencia ya no está disponible para ejecutar la consulta adicional necesaria.


El problema surge por ejemplo al obtener un Purchase, que una vez se devuelve al contexto que lo llamo (el cliente o servicio) donde la sesión de Hibernate ya está cerrada, al intentar acceder a la colección ItemService, Hibernate no puede ejecutar la consulta adicional y lanza la excepción.

Una solución es definir el método como `@Transactional` que mantiene la sesión de Hibernate abierta durante toda la ejecución del método, permitiendo inicializar las relaciones LAZY dentro de él.

## 25. - Enumerar todos los valores de CascadeType y explicar qué operación propaga cada uno sobre las entidades relacionadas.

- `CascadeType.ALL`: Propaga todas las operaciones de entidad (persistir, fusionar, eliminar, refrescar y desvincular) a la entidad relacionada. 
- `CascadeType.PERSIST`: Si se persiste una entidad principal, también se persisten automáticamente las entidades relacionadas que se crean en ese momento. 
- `CascadeType.MERGE`: Al actualizar una entidad principal, se propagan y tambien se actualiza las entidades relacionadas.
- `CascadeType.REMOVE`: Si se elimina la entidad principal, se eliminan también las entidades relacionadas.
- `CascadeType.REFRESH`: Cuando se llama al método refresh, las entidades relacionadas se vuelven a cargar desde la base de datos recuperando sus valores de persistencia. 
- `CascadeType.DETACH`: Desvincula entidades relacionadas del entorno de persistencia.


## 26 - ​¿Cuál es el comportamiento por defecto cuando no se define cascade? ¿Cuál es la finalidad general de CASCADE? Proponga un caso del modelo donde definir un CASCADE inadecuado podría traer problemas a la consistencia de la base de datos.

Cuando no se define la propiedad cascade en una anotación de relación, no se propaga ninguna operación. La finalidad de `CascadeType` es automatizar la propagación de las operaciones del ciclo de vida desde una entidad a sus entidades realcionadas, manteniendo la consistencia del grafo de objetos sin necesidad de escribir código. Así, al realizar una operación sobre la entidad principal, JPA la replica automáticamente sobre las relaciones anotadas con `cascade`.

Si se define `cascade = CascadeType.REMOVE` en la relación `User.purchases`, al eliminar un usuario JPA eliminará en cascada todas las compras asociadas a ese usuario perdiendo asi los registros históricos y financieros

## 27 - ​¿Cuál es la diferencia entre cascade = REMOVE y orphanRemoval = true? ¿Pueden usarse conjuntamente? Ejemplificar con el par Purchase -> ItemService.

La diferencia principal radica en el momento y la causa de la eliminación, `CascadeType.REMOVE` elimina las entidades secundarias solo cuando se elimina la entidad principal, mientras que `orphanRemoval = true` elimina las entidades secundarias cuando se desvinculan de la principal (se convierten en huérfanas), aunque la principal siga existiendo. Ambos atributos pueden usarse conjuntamente.

## 28 - ​Para la relación Purchase -> ItemService (composición):
### O -​ ¿Qué tipos de cascade configurarías? Justificar cada uno.

Configuraría `CascadeType.ALL` porque cada `ItemService` es parte y compone a un `Purchase`, por ejemplo:
- Cuando se crea una nueva compra y se le agregan `ItemService` nuevos (con `Service` existente), se deben persistir automáticamente los items.
- Si se modifica una compra existente (ej. se cambia la cantidad de un item), los cambios se propagan al item.
- Si se elimina la compra, los items de servicios asociados ya no tienen sentido.

### P -​ ¿Usarias orphanRemoval? ¿Por qué?

Si, porque un `ItemService` es único de una `Purchase`, por lo que si se lo desvincula (queda huérfano) es información que se almacena en la BD y no sera utilizado. Por lo que es correcto eliminarlo para así no generar anomalias.


### Q -​ Describir qué ocurre a nivel de base de datos cuando se elimina un ItemService de la lista de una Purchase y Hibernate realiza el flush.

Suponiendo `orphanRemoval=true` y cascade incluye `REMOVE`:

1. Se ejecuta `purchase.getItems().remove(item)`.
2. Hibernate marca el item como huérfano en el contexto de persistencia.
3. Al hacer `flush()` (o al cerrar la transacción), Hibernate ejecuta una consultsa para eliminar dicho itemn huérfano.

## 29 - ​Para la relación Purchase -> Review:
### R -​ ¿Qué cascades configurarías?

Nignuna, la relación debe ser sin cascada para evitar borrados o actualizaciones no deseadas. Esto se debe a que por ejemplo una reseña se crea explícitamente después de la compra mediante un metodo, no debe persistirse automáticamente al guardar la compra o que al actualizar una compra no debe modificar automáticamente sus reseñas. Son recursos mas estaticos.

### S -​ Si se elimina una Purchase, ¿debería eliminarse también su Review? Justificar desde el modelo de negocio.

No, no debería eliminarse la reseña; las reseñas son contenido generado por el usuario que valora el recorrido turístico, no la compra en sí misma.

## 30 - ​Para la relación Supplier -> Service:
### T -​ ¿Qué cascades tienen sentido?

`CascadeType.PERSIST` y `CascadeType.MERGE`

### U -​ Si se elimina un Supplier, ¿qué debería ocurrir con sus Service? ¿Y con las Purchase que los contienen a través de ItemService?

Si se elimina un `Supplier` deberian eliminarse los `Service` asociados a menos que alguno de estos posee ya `ItemService` relacionas, si se eliminar el `Service` en esta situacion, dejaria inconsistente el monto total de los servicios que se contrataron.

## 31 - ​¿Por que CascadeType.REMOVE en una relación @ManyToMany (por ejemplo Route <-> DriverUser) suele ser peligroso? Describir un escenario donde su uso cause pérdida no deseada de datos.

En una relación `@ManyToMany`, ambas entidades son independientes y pueden estar asociadas a múltiples instancias del otro lado. Usar `CascadeType.REMOVE` desde una de las entidades hacia la colección de la otra implica que, al eliminar una entidad A, JPA intentará eliminar todas las entidades B que estén asociadas a A, incluso si esas mismas entidades B también están asociadas a otras entidades A.

## 32 - ​Implemente las operaciones en cascada adecuada para todas las relaciones del modelo tours.

## ​Describir las tres estrategias de mapeo de herencia. Para cada una indicar qué tablas se crean, si aparece columna discriminadora y cómo resuelve Hibernate una consulta polimórfica. Completar la tabla:


| Aspecto | SINGLE_TABLE | JOINED | TABLE_PER_CLASS |
|---------|--------------|--------|------------------|
| **Tablas creadas en la BD** | Una sola tabla con todas las columnas de la jerarquía (clase padre + subclases). | Una tabla para la clase padre (atributos comunes) + una tabla por cada subclase (atributos específicos), unidas por FK (misma PK). | Una tabla por cada clase concreta (incluyendo la clase padre si es concreta). No hay tabla para clases abstractas. |
| **Columna discriminadora** | Sí, obligatoria (por defecto `DTYPE`). | Opcional. Puede agregarse en la tabla padre para mejorar rendimiento, pero no es necesaria. | No. |
| **NULLs en columnas de subclases** | Sí. Las columnas específicas de una subclase son `NULL` en las filas de otras subclases. | No. Cada subclase almacena sus columnas en su propia tabla, por lo que no hay `NULL` forzados (solo los naturales de la columna). | No. Cada tabla solo tiene las columnas de su clase, no hay columnas “prestadas” de otras subclases. |
| **Consulta polimórfica `todos los Users`** | `SELECT * FROM user_table` (una sola tabla). Hibernate filtra por `DTYPE` si solo quiere un subtipo. | `SELECT * FROM User u LEFT JOIN DriverUser d ON u.id = d.id LEFT JOIN ...` (tantos `LEFT JOIN` como subclases). | `SELECT * FROM User UNION SELECT * FROM DriverUser UNION ...` (todas las tablas de subclases concretas). |
| **Cargar un `DriverUser` por ID** | `SELECT * FROM user_table WHERE id = ? AND DTYPE = 'DriverUser'` | `SELECT * FROM User u INNER JOIN DriverUser d ON u.id = d.id WHERE u.id = ?` | `SELECT * FROM DriverUser WHERE id = ?` |
| **Integridad referencial (FK posibles)** | Limitada. No se pueden definir claves foráneas desde columnas específicas de subclases (por los `NULL`). Las columnas comunes sí pueden tener FK. | Sí. Tanto la tabla padre como las tablas hijas pueden tener claves foráneas hacia otras tablas. | Sí. Cada tabla concreta puede definir sus propias claves foráneas. |
| **Performance en lecturas simples (de una entidad)** | Buena. Una sola tabla, sin `JOIN` ni `UNION`. | Regular. Requiere un `JOIN` entre la tabla padre y la tabla de la subclase. | Buena. Una sola tabla, sin `JOIN` (se accede directamente a la tabla de la clase concreta). |
| **Qué implica para agregar nueva subclase** | Agregar una o más columnas a la tabla única (aceptan `NULL`) y modificar el código de la discriminación. Puede volver la tabla muy ancha y con muchos `NULL`. | Agregar una nueva tabla hija. No afecta a las tablas existentes. Es la estrategia más limpia para extensiones. | Agregar una nueva tabla. No afecta a las tablas existentes. Pero las consultas polimórficas crecen con cada nueva subclase (más `UNION`). |

## 34 - ​Implementar el mapeo de la jerarquía `User`/`DriverUser`/`TourGuideUser` usando la estrategia `SINGLE_TABLE`. Especificar `@Inheritance`, `@DiscriminatorColumn` y `@DiscriminatorValue` para cada clase. Incluir todos los atributos.

```java
@Entity(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public class User { 
    // ... 
}
@Entity(name = "tour_guide_user")
@DiscriminatorValue("TOUR_GUIDE")
public class TourGuideUser extends User {
    // ...
}
@Entity(name = "driver_user")
@DiscriminatorValue("DRIVER")
public class DriverUser extends User {
    // ...
}
```

### V -​ Ejecutar los tests provistos y analizar el DDL generado: ¿cuántas tablas aparecen? ¿Qué columnas tiene la tabla? ¿Dónde están los atributos expedient y education?



### W -​ ¿Qué ocurre con las columnas de subclase cuando se inserta un `TourGuideUser`? ¿Y cuando se inserta un `DriverUser`?



### X -​ ¿Cuáles son las ventajas y desventajas de esta estrategia para este modelo concreto?

Ventajas:
- Toda la información se encuentra en una sola tabla, por lo que las consultas no deberan ejecutar joins.
- Cuando se realiza un cambio en la estructura de la clase al tope de la jerarquía y se quiere propagar este cambio a las tablas involucradas en el mapeo, es muy simple ya que solamente se debe agregar la nueva columna a la única tabla presente.

Desventajas:
- La tabla siempre contiene tuplas con algunas columnas vacías.
- Se torna difícil cuando existe el mismo atributo en dos clases de la misma jerarquía, pero con diferente semántica o rango de valores posibles.
- Es necesario incorporar una nueva columna a la tabla que especifique a qué clase de la jerarquía pertenece la tupla que se está leyendo.
- Cada vez que se quiera hacer una consulta que recorra las instancias de una clase concreta se estarán recorriendo también las instancias de las demás clases.
- Al realizar cambios en la estructura de una clase siempre se termina impactando en el mapeo de todas las clases, ya que todas las clases comparten la misma tabla destino.


## 35 - ​Reimplementar el mapeo de la misma jerarquía usando la estrategia `JOINED`.

### Y -​ Ejecutar los tests y analizar el DDL: ¿cuantas tablas aparecen? ¿Qué FK existe entre ellas?



### Z -​ Comparar el SQL generado por Hibernate al cargar un `DriverUser` en `JOINED` vs. en `SINGLE_TABLE`. ¿Cómo difiere?



### AA - ​¿Cuáles son las ventajas y desventajas de `JOINED` para este modelo?

Ventajas:
- Para recuperar toda la información de una instancia basta con recuperar una tupla de la tabla que corresponda. No es necesario ejecutar joins.
- Otra de las ventajas es que los conjuntos de instancias están separados. Esto permite recorrer solamente alguno de los conjuntos.

Desventajas:
- Cuando se requiere devolver el “extent” de una clase (es decir, el conjunto de todas sus instancias), y dicha clase es la que fue “dividida” (superclase) se debe ejecutar una de las operaciones más caras del SQL: UNION. Entonces para recuperar todas las personas habría que realizar un consulta utilizando union.
- La repeticion de extrcutras y datos en las tablas subclase.

## 36 - ​Realice el mismo proceso ahora con la estrategia `TABLE_PER_CLASS`. Indique cuál le parece la mejor estrategia para este modelo concreto y justifique su elección.

Ventajas:
- Es la alternativa mas oreintada a objetos pisble. Se tiene una tabla que representa la clase abstracta, en la que se definen los atributos comunes a todas las subclases; y luego tablas para las clases concretas que “apuntan” a la tabla de la clase
abstracta.
- Cuando se realiza un cambio que debe propagarse a cada clase concreta es necesario alterar solamente la clase abstracta.
- Cuando se requiere consultar el conjunto de instancias de una clase en particular, simplemente basta con apuntar la consulta a la tabla asociada sin tener que recorrer inútilmente el resto de las instancias (siempre y cuando no se requieran datos que están en la tabla que representa la clase abstracta).
- Si hay un atributo con el mismo nombre en dos o más clases, cada una lo puede mapear como más le convenga.
- Para aquellas consultas que deban apuntar a todas las instancias de la clase abstracta basta con dirigir la consulta a una sola tabla que representa la clase abstracta. Esto suponiendo que dicha tabla contiene toda la información requerida.

Desventajas de esta solución
- La necesidad de realizar siempre joins para poder recuperar toda la información que compone a una instancia. 

La mejor estrategia para esta solución en aplicar `TABLE_PER_CLASS`, dado que por mas que se pierda performance realizando joins en las consultas para obtener todos los datos de una instancia, permite no poseer anomalías de repetición de datos (como en el caso de la estrategia `JOINED`) o tener tuplas con datos nulos (en caso de `SINGLE_TABLE`). Ademas `TABLE_PER_CLASS` es una estrategia que respeta el paradigma de orientación  objetos, permitiendo mappear cada una de las clases en tablas individuales, permitiendo que las consultas respeten el esquema uml de objetos.

## 37 - `​Route` tiene relaciones muchos-a-muchos con `DriverUser` y `TourGuideUser` (subclases de `User`). Analizar el impacto de la estrategia de herencia sobre la tabla join:

### BB - ​Si la jerarquía es `SINGLE_TABLE`, ¿a que tabla apunta la `FK` en la tabla join?

Apuntara a `User`.

### CC - ​Si la jerarquía es `JOINED`, ¿cambia la tabla destino de esa `FK`?

Si, apunara a `DriverUser` o `TourGuideUser` dependiendo la relacion.

## 38 - ​¿Qué estrategia resulta más robusta ante cambios futuros como agregar una nueva subclase de `User`? Justificar con al menos dos argumentos.

La estrategia mas robusta ante cambios, es `TABLE_PER_CLASS`, debido a que no es necesario modificar las tablas existentes, ya sea la clase abstracta ni las instancias, solo agregando una tabla nueva y referenciando a a su super clase, ya se poseen todos los datos de `User` y de la nueva clase concreta, ademas ayudaría a reducir las  posibles anomalías al solo agregare una tabla nueva y no realizar modificaciones en tablas anteriores.
