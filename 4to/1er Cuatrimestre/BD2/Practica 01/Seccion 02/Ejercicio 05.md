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
- Es la alternativa mas oreintada a objetos pisble. Se tiene una tabla que representa la clase abstracta,
en la que se definen los atributos comunes a todas las subclases; y luego
tablas para las clases concretas que “apuntan” a la tabla de la clase
abstracta.
2. Cuando se realiza un cambio que debe propagarse a cada clase concreta
es necesario alterar solamente la clase abstracta. El resto de las tablas no
debe ser modificado. En este sentido es similar a la alternativa anterior.
3. Cuando se requiere consultar el conjunto de instancias de una clase en
particular, simplemente basta con apuntar la consulta a la tabla asociada
sin tener que recorrer inútilmente el resto de las instancias (siempre y
cuando no se requieran datos que están en la tabla Person).
4. Si hay un atributo con el mismo nombre en dos o más clases, cada una lo
puede mapear como más le convenga.
5. Para aquellas consultas que deban apuntar a todas las instancias de la
clase Person (recordar que todas las instancias de las clases Employee y
Customer son en definitiva también instancias de la clase Person) basta
con dirigir la consulta a una sola tabla (Person). Esto suponiendo que
dicha tabla contiene toda la información requerida.
B. Desventajas de esta solución
1. Quizás la mayor desventaja de esta solución de mapeo resida en la
necesidad de realizar siempre joins para poder recuperar toda la
información que compone a una instancia. Esto se debe a que la parte
común a todas las instancias se encuentra en la tabla Person y la parte
correspondiente a la Clase Customer está en la tabla Customer.

## 37 - ​Route tiene relaciones muchos-a-muchos con `DriverUser` y `TourGuideUser` (subclases de `User`). Analizar el impacto de la estrategia de herencia sobre la tabla join:

### BB - ​Si la jerarquía es `SINGLE_TABLE`, ¿a que tabla apunta la `FK` en la tabla join?


### CC - ​Si la jerarquía es `JOINED`, ¿cambia la tabla destino de esa `FK`?


## 38 - ​¿Qué estrategia resulta más robusta ante cambios futuros como agregar una nueva subclase de `User`? Justificar con al menos dos argumentos.


