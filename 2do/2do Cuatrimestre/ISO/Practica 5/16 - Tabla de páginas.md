## Existen varios enfoques para administrar las tablas de páginas: Tablas de páginas de 1 nivel, de 2 niveles o de páginas invertidas. Explique brevemente como trabajan estos enfoques e indique como se realiza la transformación de la dirección virtual en dirección física. 

- **Tablas de páginas de 1 nivel:** En este enfoque, hay una única tabla que contiene una entrada por cada página del espacio de direcciones virtuales. Cada entrada indica la dirección base del marco en memoria física donde está cargada la página correspondiente. 
  - Transformación: 
    - Se accede directamente a la entrada de la tabla con el número de página virtual.
    - Se lee la entrada correspondiente para obtener la dirección base del marco físico.
    - El desplazamiento se suma a esa dirección base para obtener la dirección física final.

- **Tablas de páginas de 2 niveles:** Este enfoque divide la tabla de páginas en dos niveles para reducir el espacio requerido. Ahora se debe alamcenar el indice de tabla externa, el indice de tabla interna mas el desplazamiento.
  - Transformación: 
    - La parte de índice de tabla externa de la dirección virtual selecciona la tabla de primer nivel.
    - La parte de índice de tabla interna selecciona la entrada en la tabla de segundo nivel.
    - La entrada de la tabla de segundo nivel contiene la dirección base del marco físico.
    - El desplazamiento se suma a esa dirección base para obtener la dirección física final.

- **Tablas de páginas invertidas:** En lugar de mantener una tabla con una entrada por cada página virtual, las tablas invertidas tienen una entrada por cada marco físico y existe una unica tabla para todo el sistema. El espacio de direcciones de la tabla se refiera al espacio físico de la RAM, en vez del espacio de direcciones virtuales de un proceso. Se utiliza una búsqueda inversa para mapear la dirección virtual a un marco físico.
  - Transformación: 
    - La dirección virtual se combina con información adicional (como el ID del proceso) para buscar en la tabla invertida.
    - Se recorre la tabla para encontrar la entrada que coincide con la página virtual solicitada.
    - El marco físico correspondiente se utiliza junto con el desplazamiento de la dirección virtual para calcular la dirección física final.