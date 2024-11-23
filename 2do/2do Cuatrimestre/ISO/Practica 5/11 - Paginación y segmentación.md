## A - Cite similitudes y diferencias entre la técnica de paginación y segmentación. 
- Similitudes:
  - Ambas técnicas permiten la asignación dinámica de memoria, lo que significa que no es necesario que todos los procesos ocupen un espacio de memoria contiguo.
  - Ambas técnicas requieren estructuras de mapeo (como tablas) para asociar las direcciones lógicas de los procesos con las direcciones físicas de la memoria.
  - En ambos métodos, la memoria física se divide en bloques que se asignan según las necesidades de los procesos.
  - En mabos se trabaja con un numero de segmento o pagina y un desplazamiento dentro de esta.
- Diferencias:
  - Paginacion divide la memoria en bloques de tamaño fijo llamados páginas y marcos. Mientras que segmentacion divide la memoria en segmentos lógicos, como código, datos, pila, etc.
  - Los bloques (páginas y marcos) son de tamaño fijo. Los segmentos pueden tener tamaños variables dependiendo de la estructura del programa.
