## 1 - ¿Cuales de los siguientes conceptos de RDBMS existen en MongoDB? En caso de no existir, ¿hay alguna alternativa? ¿Cual es?
En MongoDB, los conceptos se mapean de la siguiente manera:
- Base de Datos: Base de Datos. El concepto es el mismo: un contenedor lógico para colecciones.
- Tabla / Relación: Colección (Collection). Es el grupo de documentos BSON, análogo a una tabla en SQL.
- Fila / Tupla: Documento (Document). Es un registro individual dentro de una colección.
- Columna: Campo (Field). Es un par nombre-valor dentro de un documento.

## 2 - ¿Existen claves foraneas en MongoDB? ¿Que diferencias existen con las bases de datos de tipo relacional?

MongoDB no tiene claves foráneas como las bases de datos relacionales. Es decir, no existen restricciones de integridad referencial a nivel de base de datos. En lugar de declarar una foreign key, la relación se representa almacenando manualmente el _id al que se quiere referenciar. La integridad de esta referencia es responsabilidad de la aplicación. Para consultar datos relacionados, se utiliza el operador $lookup en un pipeline de agregación, que realiza una especie de "join" entre colecciones.

Diferencias clave con las RDBMS:
- Ausencia de restricciones: No hay soporte nativo para restricciones de integridad referencial como ON DELETE CASCADE.
- Gestión manual: Las relaciones las define y mantiene el desarrollador a nivel de aplicación.
- Unión mediante $lookup: Se usa la etapa $lookup para combinar datos de múltiples colecciones, emulando la funcionalidad de los joins.

## 3 - Para acelerar las consultas, MongoDB tiene soporte para indices. ¿Que tipos de indices soporta?

MongoDB soporta una amplia variedad de tipos de índices para optimizar el rendimiento de las consultas:
- Índice de Campo Único (Single Field Index): Es el tipo más básico, para indexar un único campo.
- Índice Compuesto (Compound Index): Indexa múltiples campos en un orden específico, ideal para consultas con múltiples criterios o para optimizar el ordenamiento.
- Índice Multiclave (Multikey Index): Se usa para indexar campos que contienen arrays, creando una entrada de índice por cada elemento del array.
- Índice de Texto (Text Index): Diseñado para búsquedas de texto completo sobre contenido tipo string.
- Índice Geoespacial (Geospatial Index): Soporta consultas basadas en ubicaciones geográficas y proximidad.
- Índice Hashed (Hashed Index): Almacena un hash del valor del campo, muy útil para distribuir datos uniformemente en entornos de sharding.
- Índice Wildcard (Wildcard Index): Útil para colecciones con esquemas muy variables, ya que indexa dinámicamente un conjunto de campos, permitiendo consultas flexibles sin necesidad de definir índices fijos.

## 4 - En MongoDB existen dos tipos de vistas. Explicar brevemente cuales son y que diferencias existen entre ellas. Ademas, mencionar algunos casos donde podria utilizarlas.

MongoDB ofrece dos tipos de vistas, ambas creadas a partir de un pipeline de agregación:
- Vistas Estándar (Standard Views): Se calculan en tiempo real cada vez que se realiza la consulta, no se almacenan en disco. Siempre muestran los datos más actualizados de las colecciones subyacentes, pero su rendimiento puede degradarse si el pipeline de agregación es muy complejo o el volumen de datos es grande.
- Vistas Materializadas Bajo Demanda (On-Demand Materialized Views): El resultado del pipeline de agregación se almacena físicamente en disco y se actualiza cuando el usuario lo decide o mediante un proceso programado. Ofrecen un rendimiento de lectura muy superior al no tener que recalcularse cada vez, a costa de no reflejar cambios en tiempo real hasta la próxima actualización.

## 5 - Los documentos de una coleccion pueden diferir en la cantidad y tipos de campos. ¿Existen algunas formas de validar los elementos a insertar en una coleccion para evitar esta disparidad?

MongoDB permite validación de esquemas a nivel de colección para garantizar una estructura consistente en los documentos. Se implementa mediante el operador $jsonSchema en el validator de la colección. Al crear o modificar una colección, se define un esquema JSON que especifica los tipos de datos esperados, campos requeridos, valores permitidos, etc. Esto previene la inserción de documentos que no cumplan las reglas definidas. Se puede configurar el validationLevel:
- strict (por defecto): Aplica la validación a todas las inserciones y actualizaciones de documentos.
- moderate: Aplica la validación solo a los nuevos documentos insertados, permitiendo que documentos antiguos no válidos coexistan.

## 6 - MongoDB tiene soporte para transacciones, pero no es igual que el de los RDBMS. ¿Cual es el alcance de una transaccion en MongoDB?

MongoDB soporta transacciones ACID (Atomicity, Consistency, Isolation, Durability) multi-documento desde la versión 4.0, lo cual es una diferencia importante con su pasado. Sin embargo, su alcance y características difieren ligeramente de las RDBMS tradicionales.
- Alcance Completo (Multi-documento/colección): A diferencia de versiones anteriores que solo tenían atomicidad a nivel de documento, una transacción en MongoDB puede abarcar múltiples documentos, colecciones, bases de datos y, desde la versión 4.2+ de MongoDB, también en entornos de clúster fragmentado (sharded clusters).
- Limitación de Duración (Timeout): La principal limitación práctica es que las transacciones tienen una duración máxima por defecto de 60 segundos. Si una transacción supera este límite, será abortada automáticamente por el servidor para liberar recursos. Este valor se puede ajustar mediante el parámetro transactionLifetimeLimitSeconds.

Mientras que una RDBMS tradicional está optimizada para transacciones largas y complejas, las de MongoDB están diseñadas para ser rápidas y ágiles. La recomendación en MongoDB es modelar los datos para que las transacciones multi-documento sean la excepción y no la regla, priorizando el rendimiento.

## 7 - Las relaciones entre documentos en MongoDB pueden establecerse mediante documentos embebidos o referencias. Investigar como se implementa cada una y analizar las ventajas y desventajas de cada una, comparandola con la forma estandar de establecer relaciones en una base de datos relacional.


| Característica            | Documentos Embebidos (Embedded)                                          | Referencias (References)                                                                                |
| ------------------------- | ------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------- |
| **Definición**            | Los datos relacionados se almacenan dentro de un mismo documento.        | Se almacena una referencia (ej. el `_id`) de un documento en otro.                                      |
| **Consultas**             | Una sola consulta recupera toda la información relacionada.              | Se necesitan múltiples consultas o un `$lookup` para reunir los datos.                                  |
| **Rendimiento Lectura**   | Muy alto para datos que se consultan juntos.                             | Potencialmente más lento debido a múltiples accesos a la base de datos.                                 |
| **Rendimiento Escritura** | Actualizaciones atómicas dentro de un solo documento.                    | Requiere actualizar múltiples documentos, pero con documentos más pequeños.                             |
| **Atomicidad**            | Escrituras atómicas a nivel de documento.                                | Requiere transacciones multi-documento para garantizar la atomicidad (disponibles desde la versión 4.0) |
| **Cardinalidad**          | Ideal para relaciones **uno-uno** y **uno-pocos**.                       | Necesario para relaciones **uno-muchos** y **muchos-muchos** con gran cardinalidad                      |
| **Limitaciones**          | Datos que no crecen indefinidamente (tamaño máximo del documento: 16MB). | Sin la restricción de tamaño del documento, pero requiere consultas adicionales.                        |



## 8 - Tomando como referencia el modelo de los trabajos practicos anteriores y suponiendo que este podria mapearse a una base de datos en MongoDB, proponer algunos casos donde la relacion seria conveniente mapearla como referencia y otros como documentos embebidos. Justificar la eleccion.

