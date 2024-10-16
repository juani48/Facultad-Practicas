## 1 - Cuando hay un cambio de contexto, el valor del registro PSW (program status word, palabra de estado de programa) del proceso que se estaba ejecutando es guardado en la PCB de ese proceso.

La respuesta correcta es **Verdadero**.

## 2 - La System Call fork() devuelve al proceso hijo el PID del proceso padre.

Cuando se crea un proceso, el padre necesita "conocer" la PID del hijo, para poder comunicarse con él. Por eso, la system call fork() le devuelve, le "informa" al padre, la PID del hijo. En cambio, en la PCB del hijo, recientemente creada, ya está almacenada la PId del padre, por eso no es necesario avisarle.

La respuesta correcta es **Falso**.

## 3 - Un cambio de modo de ejecución siempre causa que se realice un cambio de contexto.

La respuesta correcta es **Falso**.

## 4 - La PCB de un proceso se almacena en el espacio de direcciones del mismo.

La respuesta correcta es **Falso**.

## 5 - Los algoritmos Apropiativos (Preemtive) para la planificación de la CPU son convenientes  en procesos interactivos.

El critero de apropiación le permite al SO decidir si hay que ejecutar un proceso de mayor prioridad y darle la CPU rapidamente. No obstante, debe hacerse adecuadamente el cambio de contexto con el proceso que está en ejecución, para garantizar su integridad cuando se le vuelva a dar la CPU.

Los procesos interactivos necesitan dar respuestas rápidas y por eso son más adecuados los criterios de apropiación. 

La respuesta correcta es **Verdadero**.

## 6 - Todas las interrupciones por hardware generarán un Cambio de Contexto entre procesos.

Tené en cuenta que aplicamos el concepto de "context switch" al intercambio entre procesos, donde hay un proceso saliente y un proceso entrante. Cuando se atiende una rutina de atención de interrupciones, si bien se resguardan algunos registros de la CPU para permitir la ejecución de la rutina y no perder la infromación del proceso que se estaba ejecutando, no lo consideramos un cambio de contexto: el escenario no es entre dos procesos.

La respuesta correcta es **Falso**.

## 7 - La ejecución de las rutinas de atención de interrupciones, referenciadas en el vector de interrupciones, no requieren de CPU.

Cualquier módulo de software necesita procesador para ejecutarse

La respuesta correcta es **Falso**.

## 8 - La PCB es una estructura de datos unica  que utiliza el Kernel para almacenar información de todos los procesos. Contiene una lista encadenada con los atributos de los procesos creados.

El SO crea una PCB por proceso, donde se almacenan los atributos de ese proceso. Cuando un procesa crea un proceso hijo, se le asigna su propia PCB con sus propios atributos. Aunque haya algunos datos compartidos entre el padre y el hijo, las PCB son individuales, propias de cada uno de ellos.

La respuesta correcta es **Falso**.

## 9 - Si se aplica la planificación apropiativa por prioridades, cuando un proceso que llega a la cola de listos tiene más prioridad que el proceso que se está ejecutando, indique qué ocurre con el proceso que se está ejecutando:

- [x] Pasa a estado de listo.
- [ ] Ninguna de las otras opciones.
- [ ] Continua su ejecución.
- [ ] Es Swapeado.
- [ ] Pasa a estado de Espera.

En los criterios apropiativos, se le da al SO la función de decidir, de "apropiarse" de la situación. Si el proceso que llega tiene más prioridad, se le debe dar la CPU rapidamente. Ese rapidamente es relativo: se debe hacer cambio de contexto para salvar la integridad de la ejecución que se estaba ejecutando, marcar en la PCB su estado como "listo". No pasa a "espera" porque el proceso no está esperando por un evento: sólo necesita que le den la CPU para continuar ejecutándose.

## 10 - Las direcciones de retorno de las rutinas invocadas durante la atención de una SysCall son apiladas en:

- [ ] Stack en modo Usuario.
- [x] Stack en modo Kernel.
- [ ] Se usa una u otra indistintamente, según la que venia usando el proceso cuando llamo a la SysCall.

## 11 - Cuando un proceso quiere invocar una System Call, es el mismo proceso el que realiza el cambio a  modo kernel para luego hacer un CALL a la rutina correspondiente.

La respuesta correcta es **Falso**.

## 12 - El chequeo de protección de la memoria mediante los registros base y limite es realizado por el SO ante cada acceso a memoria que intenta un proceso 

La respuesta correcta es **Falso**.

## 13 - Cómo detecta el hardware que un proceso en modo usuario está intentando ejecutar una instrucción privilegiada y qué ocurre?

- [ ] Se detecta por el código de la instrucción entonces el HW finaliza el proceso.
- [ ] Lo detecta porque esa  instrucción no está en el espacio de direcciones del proceso. Da error y finaliza el proceso.
- [x] Se detecta por el código de la instrucción. El HW produce un trap al SO.
- [ ] Un proceso en modo usuario puede ejecutar una instrucción privilegiada, por lo tanto no ocurre nada.

## 14 - Un proceso es una entidad abstracta que incluye una sección de Código, una sección de datos y 1 o más stacks.

La respuesta correcta es **Verdadero**.

## 15 - En qué registro de la CPU se almacena el bit de modo?

- [ ] En el Program counter (PC).
- [ ] En el registro de instrucciones (IR).
- [x] En la palabra de estado de programa (PSW).

## 16 - En modo usuario no se puede interactuar con el hardware, por ejemplo mandar comandos de impresión a la impresora.

Las instrucción de E/S se consideran privilegiadas, por lo que deben ser ejecutados con el procesador en modo kernel

La respuesta correcta es **Verdadero**.

## 17 - Un proceso en estado de listo en memoria principal nunca será llevado a memoria secundaria (swap out).

La respuesta correcta es **Falso**.

## 18 - De las siguientes opciones, indicar en orden cuáles de ellas se dan cuando a un proceso que se encuentra en estado de ejecución se le termina su quantum asignado, tomando como referencia el algoritmo de planificación de CPU Round Robin.

La respuesta correcta es:
1. Ejecución de Short Term Scheduller.
2. Resguardo de los datos del contexto del proceso saliente.
3. Carga de los datos del contexto del proceso entrante.
4. Cambio a Modo Usuario.
5. Salto a la instrucción del proceso entrante.

## 19 - En un diseño monolítico del kernel, todos los componentes de un SO se deben ejecutar en modo Kernel.

El Kernel es una parte del SO. El diseño monolítico se refiere al diseño del Kernel. Otras componentes del SO (como el shell) no se ejecutan en modo kernel.

La respuesta correcta es **Falso**.

## 20 - Una llamada al sistema (system call) genera la creación de un nuevo proceso del sistema operativo para atender la llamada.

La respuesta correcta es **Falso**.

