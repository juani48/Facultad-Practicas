## A - Cite similitudes y diferencias entre la técnica de paginación y la  de particiones fijas.  

- Similitudes:
  - Ambas técnicas dividen la memoria física en bloques de tamaño fijo.
  - En ambos casos, la asignación de memoria es sencilla porque no es necesario calcular el tamaño exacto para cada proceso; se asigna un bloque fijo.
  - Eliminación de fragmentación externa.
  - Posee fragmentacion interna.
- Diferencias:
  - Paginacion divide de forma logica la memoria y los precesos, en cambio particiones fijas divide solo la memoria.
  - Particiones fijas requiere que cada proceso se ajuste a una partición específica, mientras que las páginas pueden asignarse a marcos no contiguos.
  - Paginacion requiere de tablas de páginas para cada procesos para mapear las páginas lógicas a los marcos físicos, mientras que particiones fijas solo necesista una tabla con todos las particiones.
