## A -  ¿Qué es?  

Decimos que un sistema está en thrashing cuando pasa más tiempo paginando que ejecutando procesos.

## B - ¿Cuáles pueden ser los motivos que la causan?  

- Procesos con alta localización de referencias variables.
- Grado de multiprdogramacion muy alto.
- Selección ineficiente del algoritmo de reemplazo de páginas.
- Cargas de trabajo no planificadas adecuadamente.
- Conjuntos de trabajo mal calculados

## C - ¿Cómo la detecta el SO?  

Mediante el modelo d elocalidad d eun proceso. Si la cantidad de frames disponibles no satisfacen la demanda de páginas de un proceso, habrá thrashing.
- $\ m $ = cantidad frames disponibles.
- $\ WSS_{i} $ = tamaño del working set del proceso $\ p_{i} $.
- $\sum WWS_{i} =\ D$ = demanda total de frames.
- Si $\ D > m $ , habrá thrashing. 

## D - Una vez que lo detecta, ¿qué acciones puede tomar el SO para eliminar este problema? 

- Reducir el grado de multiprogramación.
- Ajustar los conjuntos de trabajo.
- Limitar los procesos que ingresan a la memoria.