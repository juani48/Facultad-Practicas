## 29 - ¿Cuál es el atributo readOnly = true en @Transactional? ¿Qué optimizaciones activa? ¿En qué métodos del servicio conviene aplicarlo?

El atributo readOnly de la anotación @Transactional se usa para indicar que la transacción actual solo realiza operaciones de lectura, sin modificar datos en la base de datos. Su valor por defecto es false. Cuando se establece readOnly = true, Spring y el proveedor de persistencia aplican varias optimizaciones:
- Modo de vaciado (flush mode) optimizado: Hibernate cambia su FlushMode a MANUAL o NEVER (dependiendo de la configuración), lo que evita que se ejecuten operaciones de sincronización innecesarias antes de cada consulta o al finalizar la transacción.
- Desactivación del dirty checking: Hibernate no realiza seguimiento de cambios en las entidades.
- Skip del flush al commit: Al no haber modificaciones, no se ejecuta el flush automático antes de confirmar la transacción.
- Optimizaciones a nivel de base de datos: Algunos motores de bases de datos pueden aprovechar el modo de solo lectura para evitar ciertos bloqueos, reducir la contienda de recursos o usar planes de ejecución más ligeros.

Se recomienda aplicar readOnly = true en todos los métodos de servicio que realizan exclusivamente operaciones de consulta (SELECT) y que no modifican el estado de la base de datos.

## 30 - ¿Cómo maneja Spring el rollback automático? ¿Sobre qué tipos de excepción hace rollback por defecto? ¿Cómo se configura para el rollback? Dar un ejemplo con el modelo.

Spring maneja el rollback automático de transacciones mediante su infraestructura de gestión transaccional. Cuando un método anotado con @Transactional o configurado mediante XML lanza una excepción, Spring decide si confirmar (commit) o revertir (rollback) la transacción según el tipo de excepción. Por defecto, Spring hace rollback automático solo para:
- Excepciones no chequeadas (RuntimeException y sus subclases).
- Error y sus subclases.

No hace rollback para excepciones chequeadas (Exception que no sean RuntimeException), como IOException, SQLException (aunque sea de base de datos, es chequeada). Esto es coherente con la filosofía de Spring de que las excepciones chequeadas representan condiciones recuperables previsibles.

Se puede personalizar el comportamiento con el atributo rollbackFor / rollbackForClassName para indicar explícitamente qué excepciones deben causar rollback, o noRollbackFor para excluir ciertas excepciones.

