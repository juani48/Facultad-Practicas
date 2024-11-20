## A - ¿Qué significan estas 2 variantes?

El algoritmo RR sea de timer fijo, significa que el timer solo se reinicia cuando vuelve a 0; que sea de timer variable, significa de que cada vez que un proceso nuevo ingrese a la CPU el timer es reiniciado.

## B - Explique mediante un ejemplo sus diferencias.

Timer fijo: Si se asigna un Q = 4 y el proceso solo requiere 2 quantums, cuando este proceso termine e ingrese otro a la CPU, el nuevo procesos solo tendrá 2 quantums para realizar su procesamiento y luego será expulsado.
Timer variable: Si se asigna un Q = 4 y el proceso solo requiere 2 quantums, cuando este proceso termine e ingrese otro a la CPU, el quantums será reiniciado a 4 y cada nuevo proceso tendrá el mismo tiempo para realizar las tareas.

## C - En cada variante ¿Dónde debería residir la información del Quantum?

Generalmente, el quantum se almacena en una estructura de datos que puede ser accedida por el scheduler del sistema operativo. Puede ser dentro de alguna estructura global del scheduler, en una variable de configuración del sistema, aunque el quantum suele ser el mismo para todos los procesos en RR, en sistemas avanzados o híbridos, cada proceso puede tener un quantum específico almacenado en su PCB o en sistemas que soportan usuarios o colas con distintas prioridades, el quantum podría almacenarse en la estructura de datos que gestiona cada nivel o grupo de usuarios.
