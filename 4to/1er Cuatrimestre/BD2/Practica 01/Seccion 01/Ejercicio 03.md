## 9 -​ Describir los cuatro estados posibles de una entidad en Hibernate (`transient`, `managed`, `detached`, `removed`) e indicar qué operación dispara cada transición entre ellos.

- **Transient (Transitorio):** Es el estado inicial de un objeto recién instanciado con el operador `new`. En este estado, la entidad no está asociada a ninguna sesión (persistence context) de Hibernate y, por lo tanto, no tiene representación en la base de datos. Cualquier cambio en este objeto no afecta a la base de datos, ya que Hibernate no lo está rastreando.

- **Managed (Administrado / Persistente):** Una entidad pasa a este estado cuando se asocia a una sesión abierta de Hibernate. En este estado, la entidad tiene una representación en la base de datos y Hibernate rastrea todos sus cambios. Cualquier modificación en sus propiedades se sincronizará automáticamente con la base de datos durante el próximo `flush` (o al hacer `commit` de la transacción).

- **Detached (Desprendido):** Una entidad `managed` entra en estado `detached` cuando la sesión con la que estaba asociada se cierra (`session.close()`) o se limpia (`session.clear()`). También se puede desprender un objeto específico con `session.detach(entity)` o `session.evict(entity)`. El objeto sigue existiendo en memoria y aún tiene un identificador persistente (ID) que apunta a un registro en la base de datos. Sin embargo, ya no está siendo rastreado por Hibernate, por lo que los cambios que se le hagan no se reflejarán en la base de datos a menos que se vuelva a asociar (`reattach`) a una sesión nueva con `merge()` o `update()`.

- **Removed (Eliminado):** Este estado representa una entidad que ha sido marcada para ser eliminada de la base de datos. Esto ocurre cuando se llama al método `remove()` (en `EntityManager`) o `delete()` (en `Session` de Hibernate) sobre una entidad en estado `managed` o `detached`. La entidad sigue estando asociada a la sesión, pero está programada para su borrado. La sentencia `DELETE` correspondiente se ejecutará durante el `flush` de la sesión. Una vez eliminada de la base de datos, la entidad queda `detached` (o `transient` si se elimina su referencia).

## 10 - ​Describir el ciclo de vida completo de una entidad persistente, tome como ejemplo un objeto de la clase Purchase: desde que se instancia con `new`, pasando por su persistencia, hasta que se elimina. Indicar explícitamente en qué estado se encuentra el objeto en cada paso.

1. Creación con new: Transient
```java
Purchase purchase = new Purchase();
purchase.setCode("P001");
```
Si se llama a entityManager.persist(purchase) en este estado, la entidad pasará a ser Managed.

2. Persistencia: Managed
```java
entityManager.persist(purchase);
```
3. Confirmación de la transacción: Managed (persistencia efectiva)
```java
transaction.commit(); // o entityManager.flush()
```

4. Desconexión explícita o cierre del contexto: Detached
```java
entityManager.detach(purchase);
// o entityManager.clear(), o entityManager.close()
```
Puede volver a asociarse (volver a Managed) mediante entityManager.merge(purchase).

5. Reasociación: Managed
```java
Purchase managedPurchase = entityManager.merge(purchase);
```
`merge` copia el estado del objeto detached a una nueva instancia managed. El objeto original sigue siendo detached; el retornado es managed.

6. Eliminación: Removed, luego de commit vuelve a Transient
```java
entityManager.remove(managedPurchase);
```
La entidad en estado Managed, pasa al estado Removed. La instancia pasa a ser Transient (aunque su identidad ya no existe en la BD). Si se quiere volver a persistir, se debe usar una nueva instancia.

## 11 - ​Investigue sobre los métodos de `Session`: `session.save()`, `session.persist()`, `session.merge()` y `session.saveOrUpdate()`. ¿Qué permite hacer cada uno y cuál es la diferencia entre ellos? Indicar en qué estado debe estar un objeto para usar cada uno correctamente.

Estos métodos se utilizan para cambiar el estado de las entidades y sincronizarlas con la base de datos. 

| Método               | Propósito Principal                                                 | Estado del Objeto Requerido                                                                                                                                         | Efecto y Estado Resultante                                                                                                                                                                      | Retorno                           |
| -------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------- |
| **`persist()`**      | Hacer "managed" un objeto "transient".                              | **Transient**                                                                                                                                                       | Inserta en BD. El objeto se vuelve **Managed**[](https://www.geeksforgeeks.org/advance-java/hibernate-lifecycle/).                                                                              | `void`                            |
| **`save()`**         | Hacer "managed" un objeto "transient".                              | **Transient**                                                                                                                                                       | Inserta en BD. El objeto se vuelve **Managed**.                                                                                                                                                 | `Serializable` (el ID generado)   |
| **`merge()`**        | Copiar el estado de un objeto "detached" a una instancia "managed". | Principalmente **Detached** (también funciona con "transient")[](https://deepwiki.com/detafti/java-persistence-spring-data-hibernate/2-jpahibernate-core-concepts). | Copia los datos y devuelve una instancia **Managed**. El objeto original permanece **Detached**[](https://docs.hibernate.org/stable/core.old/reference/en/html/objectstate-saveorupdate.html).  | `Object` (la instancia "managed") |
| **`saveOrUpdate()`** | Método "inteligente" que decide entre `save()` o `update()`.        | **Transient** o **Detached**[](https://docs.hibernate.org/stable/core.old/reference/en/html/objectstate-saveorupdate.html).                                         | Inserta si es "transient" o actualiza/reaplica si es "detached". El objeto se vuelve **Managed**[](https://docs.hibernate.org/stable/core.old/reference/en/html/objectstate-saveorupdate.html). | `void`                            |
