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
