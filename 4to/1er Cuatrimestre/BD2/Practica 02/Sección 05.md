## 36 - ​¿Que es el borrado lógico (soft delete)? Pensar en el modelo de tours: si un usuario decide darse de baja del sistema, ¿tiene sentido eliminar físicamente su registro? ¿Qué ocurriría con todas las compras que ese usuario ha realizado? Describir por qué el borrado lógico resuelve este problema y qué ventaja ofrece frente al borrado físico en este caso concreto.

El borrado lógico consiste en marcar un registro como "eliminado" sin borrarlo físicamente de la base de datos, generalmente mediante un campo. De esta forma, los datos permanecen persistentes pero se excluyen de las consultas normales.

En el caso de que un usuario se dé de baja del sistema, no tiene sentido eliminar físicamente su registro, porque ese usuario suele tener asociadas compras, reseñas, historial de actividad, etc. Si se borrara físicamente el usuario:
- Se perdería la trazabilidad de las compras realizadas (facturación, envíos, estadísticas).
- Se violarían restricciones de integridad referencial si existen claves foráneas (por ejemplo, una compra apunta a user_id que ya no existe).
- No se podría reactivar la cuenta fácilmente si el usuario vuelve.

El borrado lógico resuelve este problema permitiendo:
- Mantener el historial completo de compras asociadas a ese usuario.
- Respetar la integridad referencial (las claves foráneas siguen siendo válidas).
- Ocultar al usuario en el funcionamiento normal del sistema (por ejemplo, no aparece en listados ni puede iniciar sesión).
- Posibilidad de restaurar la cuenta o de realizar auditorías sobre datos "eliminados".

Ventaja frente al borrado físico en este caso concreto: Se preserva toda la información comercial y de negocio relacionada con el usuario, evitando datos huérfanos y permitiendo análisis históricos sin necesidad de soluciones complejas como auditorías separadas.

## 37 - Describir dos estrategias para implementar soft delete en JPA/Hibernate: campo booleano (active/deleted) y campo de fecha (deletedAt). ¿Qué diferencias hay entre ambas en cuanto a consultas y recuperación de datos?

El campo booleano es más simple, pero sin metadatos temporales. El campo fecha permite trazabilidad y políticas de retención, pero ocupa un poco más de espacio y requiere manejar nulos. En consultas, ambos necesitan filtros explícitos o anotaciones como @Where. La diferencia práctica es que con fecha se pueden hacer rangos (BETWEEN) o agregaciones por período.

## 38 - ¿Que es la anotación @SQLDelete de JPA? ¿Qué permite hacer? ¿Cómo se combina con @Where para que las consultas ordinarias ignoren los registros borrados? Mostrar un ejemplo de uso sobre la entidad User.

@SQLDelete es una anotación de Hibernate (no parte del estándar JPA) que permite personalizar la sentencia SQL que se ejecuta al llamar a entityManager.remove() o repository.delete(), reemplazando el DELETE físico por una actualización que implemente el borrado lógico.

Lo que permite hacer es sobrescribir la operación de borrado predeterminada para que, en lugar de eliminar el registro, se actualice un campo indicador (booleano o fecha). Así, el código de la aplicación sigue usando delete() de forma natural, pero en la base de datos se hace un soft delete.

Combinación con @Where: @Where(clause = "deleted = false") (o similar) se añade a la entidad para que todas las consultas ordinarias (findAll, findById, JPQL sin filtro manual) ignoren automáticamente los registros marcados como borrados. De esta forma, el soft delete es transparente para la mayoría de las operaciones de lectura.




