## Suponga que N procesos poseen inicialmente cada uno un valor. Se debe calcular la suma de todos los valores y al finalizar la computación todos deben conocer dicha suma. 

### A - Analice (desde el punto de vista del número de mensajes y la performance global) las soluciones posibles con memoria distribuida para arquitecturas en estrella (centralizada), anillo circular, totalmente conectada, árbol y grilla bidimensional. 

| Arquitectura | Numero mensajes | Performance global |
|--------------|-----------------|--------------------|
| Estrella | N | 2N (comunicaciones + procesamiento del valor final) ciclos
| Anillo Circular | N | 3N
| Totalmente Conectada | 2(N-1) (conociendo el diametro de la red) | 
| Arbol | log(N) | 
| Grilla Bidimensional | 2(N-1) (conociendo el diametro de la grilla)


### B - Escriba las soluciones para las arquitecturas mencionadas.