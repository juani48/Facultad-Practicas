
## A - Programa y Proceso.
Un programa es estático, no tiene program cunter t existe desde que se edita hasta que se borra. En cambio un proceso es dinámico, tiene program counter y su ciclo de vida comprende desde que se lo ejecuta hasta que termina.

## B - Defina Tiempo de retorno (TR) y Tiempo de espera (TE) para un Job.
- Retorno (TR): Tiempo que transcurre entre que el proceso llega al sistema hasta que completa su ejecución.
- Espera (TE): Tiempo que el proceso se encuentra en el sistema esperando, es decir el tiempo que pasa sin ejecutarse (TR - Tcpu).

## C - Defina Tiempo Promedio de Retorno (TPR) y Tiempo promedio de espera (TPE) para un lote de JOBS.
- Tiempo Promedio de Retorno (TPR): El promedio de tiempo total que cada trabajo tarda en completarse desde que ingresa al sistema hasta que finaliza.
- Tiempo Promedio de Espera (TPE): El promedio del tiempo que cada trabajo espera en la cola antes de empezar a ser procesado.

## D - ¿Qué es el Quantum?
El quantum medida que determina cuanto tiempo podrá usar el procesador cada proceso.

## E - ¿Qué significa que un algoritmo de scheduling sea apropiativo o no apropiativo (Preemptive o Non-Preemptive)?
- No apropiativo: Una vez que un proceso está en estado de ejecucion, continua hasta que termina o se bloquea por algun evento (e.j. I/O)
- Apropiativo: El proceso en ejecucion puede ser interrumpido y llevado a la cola de listos. Produce mayor overhead pero mejor servicio y un proceso no monopoliza el procesado.

## F - ¿Qué tareas realizan?
1. Long Term Scheduler: Admite nuevos procesos a memoria (controla el grado de multirpogramacion).
2. Medium Term Scheduler: Realiza el swapping (intercambio) entre el disco y la memoria cuando el SO lo determina (puede disminuir el grado de multiprogramacion).
3. Short Term Scheduler: Determina que proceso pasara a ejecutarse .

## G - ¿Qué tareas realiza el Dispatcher?
Es el encargado de relizar el cambio de contexto, control de quantum, gestión de estados (Listo, Ejecutando, Bloqueado), manejo de Interrupciones y optimiza la CPU.
