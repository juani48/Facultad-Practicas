##  Suponga un disco con las siguientes características:

### - 7 platos con 2 caras utilizables cada uno.
### - 1100 cilindros
### - 300 sectores por pista, donde cada sector de es 512 bytes.
### - Seek Time de 10 ms
### - 9000 RPM .
### - Velocidad de Transferencia de 10 MiB/s (Mebibytes por segundos).

### A - Calcule la capacidad total del disco.

$\ (7\ *\ 2)\ *\ (1100\ *\ (7\ *\ 2))\ *\ 300\ *\ 512\ bytes\ =\ 33.116.160.000\ bytes\ =\ 30,84\ GiB $

### B - ¿Cuantos sectores ocuparía un archivo de tamaño de 3 MiB(Mebibytes)?

$\ 3\ MiB\ =\ 3.145.728\ bytes $

$\ 3.145.728\ bytes\ /\ 512\ bytes\ =\ 6.144\ secotres $

### C - Calcule el tiempo de transferencia real de un archivo de 15 MiB(Mebibytes). grabado en el disco de manera secuencial (todos sus bloques almacenados de manera consecutiva)

$\ 9.000\ RPM\ =\ 1´\ =\ 60´´\ =\ 60.000ms\ →\ 0,5\ =\ 3,33ms $

$\ 10\ MiB\ por\ segundo\ →\ 512\ byte\ / 10.485.760\ bytes\ =\ 0,000048828125\ segundos\ =\ 0,048828125ms $

$\ 15\ MiB\ =\ 15.728.640\ bytes\ =\ 30.720\ sectores $

$\ 10ms\ +\ 3,33ms\ +\ (0,048828125ms\ *\ 30.720\ sectores)\ =\ 1.513,33ms\ =\ 1,5\ segundos\ =\ tiempo\ de\ transferencia\ real $  

### D - Calcule el tiempo de transferencia real de un archivo de 16 MiB(Mebibytes). grabado en el disco de manera aleatoria

$\ 9.000\ RPM\ =\ 1´\ =\ 60´´\ =\ 60.000ms\ →\ 0,5\ =\ 3,33ms $

$\ 10\ MiB\ por\ segundo\ →\ 512\ byte\ / 10.485.760\ bytes\ =\ 0,000048828125\ segundos\ =\ 0,048828125ms $

$\ 16\ MiB\ =\ 16.777.216\ bytes\ =\ 32.768\ sectores $

$\ 10ms\ +\ 3,33ms\ +\ (0,048828125ms\ *\ 32.768\ sectores)\ =\ 1.613,33ms\ =\ 1,6\ segundos\ =\ tiempo\ de\ transferencia\ real $ 
