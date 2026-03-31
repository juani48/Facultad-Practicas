
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