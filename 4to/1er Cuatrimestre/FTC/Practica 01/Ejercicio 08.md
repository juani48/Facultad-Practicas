## Construir una MT que genere todas las cadenas de la forma anbn, con n ≥ 1.

Idea general:
- Cintas: 2
	- Cinta 1: Almacena n.
	- Cinta 2: Escribe el resultado.
- Etapas:
	- Escribir en la cinta 2 tantas a como indica la cinta 1.
	- Escribir en la cinta 2 tantas b como indica la cinta 1.
	- Marcar un X de separación en la cinta 2 e incrementa el contador de la cinta 1 en 1.
- Estados:
	- q_{a}: Escribe tantas a en la cinta 2 como lo indique la cinta 1.
	- q_{b}: Escribe tantas b en la cinta 2 como lo indique la cinta 1.
	- q_{reset}: Escribe un X en la cinta 2 e incrementa el contador de la cinta 1 en 1.