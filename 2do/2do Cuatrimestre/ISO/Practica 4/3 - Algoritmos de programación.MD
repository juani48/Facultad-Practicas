## 1 - Explique su funcionamiento mediante un ejemplo.
## 2 - ¿Alguno de ellos requiere algún parámetro para su funcionamiento?
## 3 - Cual es el más adecuado según los tipos de procesos y/o SO.
## 4 - Cite ventajas y desventajas de su uso.

- FCFS (Fisrt Coome First Served)
  1. Cuando hay que elegir un proceso para ejecutar, se selecciona el mas viejo.
  3. No favorece a ningun tipo de proceso en articular, pero en principio los CPU Bound terminan al comenzar su primer rafaga, mientras que los I/O Bound no.
  - Ventajas: Es un algoritmo simple de implementar, se pueden predecir lo procesos a ejecutar, eventualmente todos los procesos de ejecutar por lo que no produce inanición y es eficiente para cargas de trabajo simple. 
  - Desventajas: No considera el tiempo de ejecución de un proceso, el promedio de tiempo de espera puede ser elevado, posee poca flexibilidad y es ineficiente para cargas de trabajo mixtas.
- SJF (Shortest Job First)
  1. Poltica no apropiativa que selecciona el proceso con la rafaga mas corto, calculando dicha ráfaga basado en la ejecución previa.
  2. Necesita el tiempo de la próxima ráfaga mas corta.
  3. Procesos con ráfagas largas sufren inanición y prioriza procesos cortos.
   - Ventajas: Menor tiempo de espera promedio, eficiencia en entornos donde hay una mezcla de procesos cortos y largos, no posee inanición si se aplica a SO con procesos cortos.
  - Desventajas: Dificultad para conocer el tiempo de ejecución de un proceso, produce inanición en SO por procesos largos, posee mucha complejidad de implementación y no se adapta correctamente si se cambian los tiempos de ejecución de los procesos.
- Round Robin
  1.  Política basada en un reloj, que determina cuanto tiempo podra usar el procesador cada proceso. Cuando un proceso es expulsado de la CPU es colocado al final de la Ready Queue y se selecciona otro (FIFO circular).
  2. Nenecita un quantum.
  3. Este algoritmos es adecuado para SO con muchos procesos I/O Bound y que requieran interacción con el usuario.
  - Ventajas: garantiza que todos los procesos obtienen una porción equitativa de tiempo de CPU, bajo tiempo de respuestas, simplicidad y adaptable a cargas de tareas variables.
  - Desventajas: Overhead por cambios de contexto y la elección del tamaño del quantum es crucial.
- Prioridades
  1. Cada proceso tiene un valor que representa su prioridad, a menor valor, mayor prioridad. Se selecciona el proceso de mayor prioridad de los que se encuentran en la Ready Queue
  2. Necesita el orden de prioridad del proceso.
  3. Ideal para SO con procesos críticos, donde es necesario que los procesos sean atenidos lo mas rápido posible.
  - Ventajas: Permite que procesos de alta prioridad obtengan acceso inmediato a la CPU
  - Desventajas: Posibilidad muy latente de inanición, complejidad de administración con prioridades dinámicas, evaluar y reorganizar la cola de procesos en función de sus prioridades genera overhead y ineficiencia para procesos equivalentes
