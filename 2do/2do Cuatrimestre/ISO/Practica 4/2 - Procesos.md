## A - Investigue y detalle para que sirve cada uno de los siguientes comandos. (Puede que algún comando no venga por defecto en su distribución por lo que deberá instalarlo):
- top: Muestra en tiempo real los procesos en ejecución, su consumo de recursos (CPU, memoria, etc.) y otras métricas de rendimiento del sistema.
- htop: Similar a top, pero con una interfaz interactiva y más amigable, que permite realizar acciones como matar procesos con solo seleccionarlos.
- ps: Muestra una lista de procesos en ejecución en el momento de la ejecución del comando. Es útil para ver información específica de procesos sin actualizaciones en tiempo real.
- pstree: Muestra los procesos en ejecución en forma de árbol, mostrando las relaciones jerárquicas entre ellos (procesos padres e hijos).
- kill: Envía una señal a un proceso específico para terminarlo (generalmente señal SIGTERM o SIGKILL). Se usa junto con el ID del proceso (PID).
- pgrep: Busca procesos que coincidan con un nombre o patrón especificado y devuelve sus PIDs, útil para identificar procesos específicos en ejecuciones en serie.
- pkill: Envía una señal para terminar todos los procesos que coinciden con un nombre o patrón específico, sin necesidad de especificar los PIDs manualmente.
- killall: Mata todos los procesos que coinciden con un nombre o patrón especificado. Es útil cuando se quiere terminar varios procesos relacionados con un solo comando.
- renice: Cambia la prioridad de un proceso en ejecución, ajustando su "niceness" para que tenga más o menos acceso a la CPU en relación con otros procesos.
- xkill: Permite finalizar aplicaciones gráficas de manera interactiva. Al ejecutarlo, el cursor se convierte en una "X", y al hacer clic en una ventana, se cierra el programa asociado.
- atop: Monitorea el rendimiento del sistema, similar a top, pero con una mayor cantidad de detalles sobre recursos como disco, red, CPU, y memoria. También permite ver estadísticas históricas.
## B - Observe detenidamente el siguiente código. Intente entender lo que hace sin necesidad de ejecutarlo.
```c
#include <stdio .h>
 #include <sys/types .h>
 #include <unistd .h>
 i nt main(void) {
 i nt c;
 pid_t pid ;
 printf ("Comienzo .:\n");
 f or (c = 0; c < 3 ; c++ )
 {
 pid = fork ();
 }
 printf (" Proceso\n");
 return 0;
 }
```
### 1. ¿Cuántas líneas con la palabra “Proceso” aparecen al final de la ejecución de este programa?.
2^3 = 8

## C - Vamos a tomar una variante del programa anterior. Ahora, además de un mensaje, vamos a añadir una variable y, al final del programa vamos a mostrar su valor. El nuevo código del programa se muestra a continuación.
```c
 #include <stdio .h>
 #include <sys/types .h>
 #include <unistd .h>
 i nt main(void) {
 i nt c;
 i nt p=0;
 pid_t pid ;
 f or (c = 0; c < 3 ; c++ )
 {
 pid = fork ();
 }
 p++;
 printf (" Proceso %d\n" , p);
 return 0;
 }
```
### 1. ¿Qué valores se muestran por consola?

La consola mostrará Proceso 1 en cada línea de salida.

### 2. ¿Todas las líneas tendrán el mismo valor o algunas líneas tendrán valores distintos?

Todas las líneas tendrán el mismo valor, Proceso 1, ya que cada proceso tiene una copia separada de p, y todos incrementan p a 1 independientemente.

### 3. ¿Cuál es el valor (o valores) que aparece?. Ejecute el programa y compruebe si su respuesta es correcta, Modifique el valor del bucle for y el lugar dónde se incrementa la variable p y compruebe los nuevos resultados.

El valor que aparece es Proceso 1, impreso 8 veces (uno por cada proceso al finalizar el bucle). Si colocas p++ dentro del bucle for, cada proceso incrementará su copia de p en cada iteración, lo que resultará en valores de p mayores en cada proceso.

## D - Comunicación entre procesos:

### 1. Investigue la forma de comunicación entre procesos a través de pipes.

En sistemas operativos tipo Unix (como Linux), una pipe (tubería) es un mecanismo de comunicación que permite a dos procesos intercambiar datos de forma unidireccional. 

### 2. ¿Cómo se crea un pipe en C?.

En C, puedes usar la función pipe() para crear una pipe. Esta función crea dos descriptores de archivo:
  - pipefd[0]: el extremo de lectura de la pipe.
  - pipefd[1]: el extremo de escritura de la pipe.

### 3. ¿Qué parametro es necesario para la creación de un pipe?. Explique para que se utiliza.

Después de la llamada a fork(), el proceso padre y el proceso hijo tienen acceso a ambos extremos de la pipe, pero para evitar conflictos:
- El padre puede cerrar el extremo de lectura pipefd[0] y usar solo el extremo de escritura pipefd[1].
- El hijo puede cerrar el extremo de escritura pipefd[1] y usar solo el extremo de lectura pipefd[0].

### 4. ¿Qué tipo de comunicación es posible con pipes?

Las pipes son unidireccionales (el flujo de datos va en una sola dirección). Si necesitas comunicación bidireccional (donde ambos procesos puedan leer y escribir), puedes crear dos pipes o usar otros mecanismos como sockets o colas de mensajes.

## E - ¿Cuál es la información mínima que el SO debe tener sobre un proceso?¿En que estructura de datos asociada almacena dicha información?
La información mínima que un sistema operativo (SO) debe tener sobre un proceso incluye detalles esenciales para gestionar su ejecución y estado: 
-  Identificación del Proceso (PID).
- Estado del Proceso.
- Contador de Programa (PC).
- Registros de la CPU.
- Información de Gestión de Memoria.
- Información de Planificación.
- Información sobre Recursos Abiertos.
- Contabilidad y Estadísticas.
Esta información se almacena en una estructura de datos denominada Bloque de Control de Proceso (PCB, Process Control Block).

## F - ¿Qué significa que un proceso sea “CPU Bound” y “I/O Bound”?
- CPU Bound: Un proceso se considera CPU Bound cuando su rendimiento y tiempo de ejecución están limitados principalmente por la capacidad de procesamiento de la CPU. En otras palabras, el proceso pasa la mayor parte de su tiempo realizando cálculos intensivos o ejecutando operaciones que requieren un uso intensivo de la CPU.
- I/O Bound: Un proceso se considera I/O Bound cuando su rendimiento y tiempo de ejecución están limitados principalmente por la capacidad de entrada/salida (E/S), como acceso a disco, red o dispositivos de entrada/salida. Es decir, el proceso pasa la mayor parte de su tiempo esperando que se completen las operaciones de E/S.

## G - ¿Cuáles son los estados posibles por los que puede atravesar un proceso?
- new
- ready
- running
- blocked
- suspend
- exit

## I - ¿Que scheduler de los mencionados en 1 f se encarga de las transiciones?
El scheduler de corto plazo es el encargado de gestionar las transiciones de los estados de los procesos en un sistema operativo
