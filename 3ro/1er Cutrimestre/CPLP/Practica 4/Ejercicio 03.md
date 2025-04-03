## Explique los siguientes conceptos asociados al atributo l-valor de una:
- Variable estática.
- Variable automática o semiestática.
- Variable dinámica.
- Variable semidinámica.
### De al menos un ejemplo de cada uno.

- **Variable estática:** Variables con almacenamiento estático. Su memoria se reserva en el segmento de datos del programa y persiste durante toda su ejecución. La dirección de memoria (l-valor) es fija y determinada en tiempo de compilación o enlazado. No cambia durante la ejecución, ya que su ubicación se asigna estáticamente.
- **Variable automática o semiestática:** Variables con almacenamiento automático (generalmente en la pila/stack). Se crean al entrar en un ámbito (e.g., una función) y se destruyen al salir. La dirección de memoria (l-valor) es dinámica y depende del contexto de ejecución. Su dirección puede variar en cada invocación o ámbito.
- **Variable dinámica:** Variables creadas manualmente en el montón/heap mediante asignación dinámica. La dirección de memoria (l-valor) se asigna en tiempo de ejecución y es gestionada por el programador o el recolector de basura. Su dirección es fija mientras exista, pero puede ser liberada/reasignada.
- **Variable semidinámica:** Variables automáticas donde el tamaño se determina en tiempo de ejecución pero se almacenan en la pila. La dirección de memoria es dinámica (como una variable automática), pero su gestión incluye comportamientos dinámicos.
