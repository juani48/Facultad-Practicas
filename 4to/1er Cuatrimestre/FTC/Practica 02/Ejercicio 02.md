## Considerando la Propiedad 2 estudiada en clase:
### 1 - ¿Cómo implementaría la copia de la entrada w en la cinta 2 de la MT M?
Asumo que las entradas no poseen espacios en blanco intermedios y que el puntero de la cinta 1 inicia al principio de la cadena: Copio el carácter de la cinta 1 en la cinta 2 y desplazo ambos punteros a la siguiente posición, repito esto hasta que en la cinta 1 encuentre un blanco.
### 2 - ¿Cómo implementaría el borrado del contenido de la cinta 2 de la MT M?
Pondría el puntero de la cinta 2 al final de la cadena para luego reemplazar cada carácter con un $B$.