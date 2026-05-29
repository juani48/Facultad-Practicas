## 32 - ¿Que es un DTO (Data Transfer Object)? ¿Cuál es su propósito dentro de la arquitectura de una aplicación? ¿Por qué no siempre conviene devolver una entidad JPA directamente desde la capa de acceso a datos?

Un DTO es un objeto simple (normalmente una clase POJO) que se utiliza para transportar datos entre diferentes capas o subsistemas de una aplicación. No contiene lógica de negocio, únicamente atributos, getters, setters (y quizás constructores o métodos de serialización). Su nombre refleja su único cometido: transferir datos de un lugar a otro. El propósito principal del DTO es desacoplar la representación interna de los datos (como las entidades de la base de datos o los objetos de dominio) de la interfaz que se expone al exterior.

Devolver una entidad JPA desde la capa de acceso a datos puede generar:
- Problemas de rendimiento y lazy loading: Las entidades JPA suelen tener relaciones (OneToMany, ManyToOne) cargadas de forma perezosa (lazy). Al serializar la entidad a JSON (u otro formato), el ORM intentará inicializar esas relaciones para devolver sus datos, lo que puede provocar consultas adicionales inesperadas (N+1), o excepciones LazyInitializationException si la sesión de Hibernate ya está cerrada.
- Exposición accidental de datos internos.
- Acoplamiento al ORM y a la base de datos.
- Dificultad para adaptar la respuesta a un caso de uso específico.
- Serialización circular y errores: Las relaciones bidireccionales en JPA pueden provocar bucles infinitos durante la serialización JSON (por ejemplo, Pedido → Cliente → Pedido). Aunque existen anotaciones como @JsonIgnore o @JsonManagedReference, estas soluciones ensucian la entidad con detalles de serialización y no siempre resuelven todos los casos.




