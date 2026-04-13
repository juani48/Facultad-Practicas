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