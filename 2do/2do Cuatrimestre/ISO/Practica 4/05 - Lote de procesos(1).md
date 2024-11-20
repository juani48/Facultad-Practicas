## A - Realice los diagramas de Gantt según los siguientes algoritmos de scheduling:
## B - Para cada algoritmo calcule el TR y TE para cada job así como el TPR y el TPE.

1. FCFS (First Come, First Served)
  - JOB 1: 
    - TR = 7
    - TE = 0
  - JOB 2:
    - TR = 22
    - TE = 7
  - JOB 3:
    - TR = 34
    - TE = 22
  - JOB 4: 
    - TR = 38
    - TE = 34
  - JOB 5:
    - TR = 47
    - TE = 38

TPR = 29,6
TPE = 20,2

2. SJF (Shortest Job First)
  - JOB 1: 
    - TR = 11
    - TE = 4
  - JOB 2:
    - TR = 47
    - TE = 32
  - JOB 3:
    - TR = 32
    - TE = 20
  - JOB 4: 
    - TR = 4
    - TE = 0
  - JOB 5:
    - TR = 20
    - TE = 11

TPR = 22,8
TPE = 13,4

3. Round Robin con quantum = 4 y Timer Fijo
  - JOB 1: 
    - TR = 23
    - TE = 16
  - JOB 2:
    - TR = 43
    - TE = 38
  - JOB 3:
    - TR = 36
    - TE = 24
  - JOB 4: 
    - TR = 16
    - TE = 12
  - JOB 5:
    - TR = 37
    - TE = 28

TPR = 31
TPE = 23,6

4. Round Robin con quantum = 4 y Timer Variable
  - JOB 1: 
    - TR = 23
    - TE = 16
  - JOB 2:
    - TR = 47
    - TE = 32
  - JOB 3:
    - TR = 43
    - TE = 31
  - JOB 4: 
    - TR = 16
    - TE = 12
  - JOB 5:
    - TR = 44
    - TE = 35

TPR = 34,6
TPE = 25,2

