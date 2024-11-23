## Si se dispone de una espacio de direcciones virtuales de 32 bits, donde cada dirección referencia 1 byte: 

### A - ¿Cuál es el tamaño máximo de un proceso (recordar “espacio virtual”)?  

$\ 2^{32}\ *\ 1\ byte = 4.294.967.296\  bytes = 4.194.304\ Kb$

### B - Si el tamaño de pagina es de 512 Kb ¿Cuál es el número máximo de paginas que puede tener un proceso? 

$\ 4.194.304\ Kb\ /\ 512\ Kb = 8.192$ paginas totales

### C - Si el tamaño de pagina es de 512 Kb y se disponen de 256 Mb de memoria real ¿Cuál es el número de marcos que puede haber? 

$\ 256\ Mb = 262.144\ Kb $
$\ 262.144\ Kb \ / \ 512\ Kb = 512$ marcos totales

### D - Si se utilizaran 2 Kb para cada entrada en la tabla de páginas de un proceso: ¿Cuál seria el tamaño máximo de la tabla de páginas de cada proceso?

$\ 8.192\ paginas\ totales\ *\ 2\ Kb = 16.384\ Kb = 16\ Mb$
