##  Construir una MT que calcule la resta de dos números.

Idea general:
- 3 cintas: 
	- cinta 1: Entrada
	- cinta 2: Realizar la resta.
	- cinta 3: Salida
- Etapas:
	- Poner tantas X en la cinta 2 como números 1 antes del 0 en la cinta 1.
	- Borrar tantas X de la cinta 2 como números 1 después del 0 en la cinta 1.
	- Si todavía hay números 1 en la cinta 1 y no hay mas X marcadas en la cinta 2 se rechaza la palabra. Si no hay números 1 en la cinta 1 y hay o no X en la cinta 2 se acepta la palabra y se ponen tantos 1 en la cinta 3 como X en la cinta 2.
- Estados:
	- q_{tachar}: Marca tantas X en la cinta 2 como 1 antes del 0 en la cinta 1.
	- q_{restar}: Borra tantas X de la cinta 2 como 1 después del 0 en la cinta 1
	- q_{resultado}: Si el resultado es mayor a 0 se escriben tantos 1 como X en la cinta 3.
	- q_{resultado-0}: Si el resultado es 0, escribe 0 en la cinta 3

|                 | B, B, B                                           | 0, B, B                                      | 1, B, B                                      | 1, X, B                                      | B, X, B                                         |
| --------------- | ------------------------------------------------- | -------------------------------------------- | -------------------------------------------- | -------------------------------------------- | ----------------------------------------------- |
| q_0             |                                                   |                                              | q_{tachar},<br>(1, R),<br>(X, R),<br>(B, S), |                                              |                                                 |
| q_{tachar}      |                                                   | q_{restar},<br>(0, R),<br>(B, L),<br>(B, S), | q_{tachar},<br>(1, R),<br>(X, R),<br>(B, S), |                                              |                                                 |
| q_{restar}      | q_{resultado-0},<br>(B, S),<br>(B, S),<br>(B, S), |                                              | q_R                                          | q_{restar},<br>(1, R),<br>(B, L),<br>(B, S), | q_{resultado},<br>(B, S),<br>(X, S),<br>(B, S), |
| q_{resultado}   | q_A,<br>(B, S),<br>(X, L),<br>(1, R),             |                                              |                                              |                                              | q_{resultado},<br>(B, S),<br>(X, L),<br>(1, R), |
| q_{resultado-0} | q_A,<br>(B, S),<br>(B, S),<br>(0, S),             |                                              |                                              |                                              |                                                 |
