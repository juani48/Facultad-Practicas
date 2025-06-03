## ¿Qué regla define Delphi, Ada y C para la asociación del else con el if correspondiente? ¿Cómo lo maneja Python?

C define que se debe emparejar cada `else` para cerrar al ultimo `if` abierto. EN cambio Ada define una sentencia de cierre explicita del bloque condicional. Python mantiene la asociacion en base a la sangria, dado que todos los `else` o `elif` se asocian a ultimo `if` definido si se cuntran al mismo nivel de sangria.


