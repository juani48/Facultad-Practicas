## A - Indique brevemente a que hacen referencia los siguientes conceptos:

### 1. Huella de un proceso en un procesador

Estado que el proceso va dejando en la cache de un procesador. 

### 2. Afinidad con un procesador

Preferencia de un proceso para ejecutar en un procesador.

### 3. ¿Por qué podría ser mejor en algunos casos que un proceso se ejecute en el mismo procesador?

Porque se podrían tener procesadores de uso especializado, lo que favorecía a la performance general del sistema; también permitiendo tener una organización heterogenia de procesadores, por lo que procesos batch podrían ir a procesadores menos eficientes y los procesos de usuario a procesadores mas potentes.

### 4. ¿Puede el usuario en Windows cambiar la afinidad de un proceso? ¿y en GNU/Linux?

Sí, en ambos sistemas operativos (Windows y GNU/Linux), el usuario puede cambiar la afinidad de un proceso, especificando qué núcleos o CPUs de un procesador pueden ejecutar un proceso en particular.

### 5. Investigue el concepto de balanceo de carga (load balancing).

El balanceo de carga se refiere a la distribución equitativa del trabajo (procesos o hilos) entre los distintos procesadores o núcleos de una CPU, con el objetivo de optimizar el rendimiento y evitar que alguno de ellos se sobrecargue mientras otros están infrautilizados.

### 6. Compare los conceptos de afinidad y balanceo de carga y como uno afecta al otro.

La afinidad y el balanceo de carga son técnicas complementarias, pero pueden presentar situaciones de conflicto si no están bien administradas:

Cuando se impone afinidad estricta, los procesos quedan limitados a un subconjunto de núcleos. Esto puede impedir que el balanceo de carga redistribuya tareas eficientemente, resultando en núcleos sobrecargados mientras otros están inactivos.
En sistemas con afinidad blanda, el balanceo de carga puede redistribuir procesos si los núcleos asignados están saturados, logrando un compromiso entre rendimiento y flexibilidad.

El balanceo dinámico puede invalidar los beneficios de la afinidad si migra procesos con frecuencia, lo que puede degradar el rendimiento en aplicaciones sensibles a la caché.
En sistemas con políticas de balanceo consciente de la afinidad, se prioriza mantener los procesos en sus núcleos preferidos siempre que sea posible.