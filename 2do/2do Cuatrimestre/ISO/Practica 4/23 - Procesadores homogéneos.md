## A - ¿Cuál sería el método de planificación más sencillo para asignar CPUs a los procesos?

Tendría un sistema que organice una cola para cada procesador, donde intentaría que cada cola mantenga una cantidad equitativa de procesos; con un algoritmo de planificación FCFS (siendo este el mas sencillo de implementar).

## B - Cite ventajas y desventajas del método escogido

La clara desventaja surge al trata rece de un algoritmo de FCFS se puede producir inanición a los últimos procesos incluidos en la cola de cada procesador, junto a un tiempo de respuesta y espera largo.
La ventaja seria que al trabajar con cargas de trabajo no muy elevadas, la distribución equitativa haría que procesos I/O Bound respondería rápidamente.
