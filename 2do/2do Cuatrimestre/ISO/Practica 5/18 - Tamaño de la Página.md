## A - Compare las siguientes situaciones con respecto al tamaño de página, indicando ventajas y desventajas:

- **Un tamaño de página pequeño:** 
  - Ventajas: 
    - Carga y descarga de paginas mas rapidas debido al poco peso de cada pagina. 
    - Al ser las páginas más pequeñas, es menos probable que se desperdicie espacio no utilizado dentro de una página.
    - ´Permite asignar memoria con mayor precisión al proceso, optimizando el uso total de la memoria disponible.
  - Desventajas: 
    - Tablas de páginas más grandes.
    - El sistema operativo necesita realizar más operaciones de búsqueda, traducción y reemplazo de páginas, lo que puede impactar el rendimiento.
    - Más fallos de página.
- **Un tamaño de página grande:** 
  - Ventajas:
    - Tablas de páginas más pequeñas.
    - Menor frecuencia de fallos de página.
    - Cuando se produce un fallo de página, se cargan más datos a la memoria de una sola vez, lo que puede aprovechar mejor el ancho de banda de E/S.
  - Desventajas: 
    - Mayor posibilidad de fragmentación interna.
    - Un proceso que utiliza una porción pequeña de memoria aún ocupa el tamaño completo de una página, lo que puede llevar a un uso ineficiente de la memoria.
    - Al cargar páginas grandes desde disco, el tiempo inicial de espera puede ser mayor debido al tamaño mayor de los datos.