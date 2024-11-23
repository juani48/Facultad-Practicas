## A - Realice los diagramas de Gantt según los siguientes algoritmos de scheduling:
## B - Para cada algoritmo calcule el TR y TE para cada job así como el TPR y el TPE.

1. FCFS (First Come, First Served)
  - JOB 1: 
    - TR = 4
    - TE = 0
  - JOB 2:
    - TR = 8
    - TE = 4
  - JOB 3:
    - TR = 11
    - TE = 10
  - JOB 4: 
    - TR = 13
    - TE = 14
  - JOB 5:
    - TR = 13
    - TE = 19

TPR = 9,8
TPE = 9,4

2. SJF (Shortest Job First)
  - JOB 1: 
    - TR = 4
    - TE = 0
  - JOB 2:
    - TR = 19
    - TE = 13
  - JOB 3:
    - TR = 5
    - TE = 1
  - JOB 4: 
    - TR = 17
    - TE = 2
  - JOB 5:
    - TR = 17
    - TE = 5

TPR = 11,4
TPE = 4,2

3. Round Robin con quantum = 1 y Timer Variable
  - JOB 1: 
    - TR = 6
    - TE = 2
  - JOB 2:
    - TR = 18
    - TE = 12
  - JOB 3:
    - TR = 12
    - TE = 8
  - JOB 4: 
    - TR = 15
    - TE = 10
  - JOB 5:
    - TR = 8
    - TE = 6

TPR = 11,8
TPE = 7,6

4. Round Robin con quantum = 6 y Timer Variable
  - JOB 1: 
    - TR = 4
    - TE = 0
  - JOB 2:
    - TR = 8
    - TE = 2
  - JOB 3:
    - TR = 11
    - TE = 7
  - JOB 4: 
    - TR = 13
    - TE = 18
  - JOB 5:
    - TR = 13
    - TE = 11

TPR = 9,8
TPE = 7,6



## D -  En el algoritmo Round Robin, que conclusión se puede sacar con respecto al valor del quantum

Si en un algoritmo RR se selecciona un quantum muy pequeño, el tiempo de respuesta promedio de los algoritmos será alto. En cambio un valor alto de quantum, recudirá el tiempo promedio de respuesta, pero trabajara los procesos a modo de FIFO provocando inanición.

## E - ¿Para el algoritmo Round Robin, en que casos utilizaría un valor de quantum alto y que ventajas y desventajas obtendría?


