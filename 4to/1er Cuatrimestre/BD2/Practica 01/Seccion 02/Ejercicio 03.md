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