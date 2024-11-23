## A - Explique como trabaja este método de asignación de memoria. 

La memoria se divide en porciones de igual tamaño llamadas marcos. El espacio de direcciones de los procesos se divide en porciones de igual tamaño que los marcos denominadas páginas. 

## B - ¿Qué estructuras adicionales debe poseer el SO para llevar a cabo su implementación?  

El SO mantiene una tabla de páginas para cada proceso, la cual contiene el marco donde se encuentra cada página, con su direccion de inicio y desplazamiento.

## C - Explique, utilizando gráficos, como son transformadas las direcciones lógicas en físicas.



## D - En este esquema: ¿Se puede producir fragmentación (interna y/o externa)?

Se produce fragmentación interna en la última página del programa.