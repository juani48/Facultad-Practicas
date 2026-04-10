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
