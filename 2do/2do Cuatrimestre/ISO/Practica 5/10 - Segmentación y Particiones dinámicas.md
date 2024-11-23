## A - Cite similitudes y diferencias entre la técnica de segmentación y la de particiones dinámicas.  
- Similitudes:
  - Los bloques de memoria asignados a los procesos pueden tener tamaños diferentes, adaptándose a las necesidades específicas de cada proceso.
  - Ambas técnicas sufren fragmentación externa.
  - Las dos técnicas permiten un uso más flexible de la memoria en comparación con métodos de tamaño fijo.
  - Ambas técnicas son útiles en sistemas que manejan múltiples procesos con diferentes requerimientos de memoria.
- Diferencias:
  - Segmentacion divide el espacio de direcciones lógicas del programa en segmentos funcionales como código, datos y pila. Mientras que particiones dinámicas no considera la estructura lógica del programa; asigna bloques según el tamaño total del proceso.
  - La segmentacion permite el trabajo con librerias o recursos compartidos.
  - Los segmentos pueden no estar contiguos en memoria, en particiones dinamicas todo el proceso debe estar en una unica particion.
