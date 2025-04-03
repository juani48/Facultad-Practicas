## A - ¿A qué se denomina variable local y a qué se denomina variable global?

Se denominan las variables segun su alcance dentro del programa, una variable global puede ser referenciada desde cualquer parete del programa, un varaible local solo puede ser referenciada dentro de la unidad en la que fue declarada.

## B - ¿Una variable local puede ser estática respecto de su l-valor? En caso afirmativo dé un ejemplo

Si, por ejemplo en C si se define una variable como 'static' dentro de un ambito local, su dirección de memoria (l-valor) se asigna en el segmento de datos del programa y persiste durante toda la ejecución.

## C - Una variable global ¿siempre es estática? Justifique la respuesta.

Sí, una variable global siempre es estática en términos de su almacenamiento, dado que las variables globales se almacenan en el segmento de datos del programa, lo que garantiza que su dirección (l-valor) sea fija y persistente.

## D - Indique qué diferencia hay entre una variable estática respecto de su l-valor y una constante

| Característica | Variable Estática | Constante |
|----------------|-------------------|-----------|
| Definición | Variable con almacenamiento estático (dirección fija). | Identificador cuyo valor no puede modificarse después de su inicialización. |
| Enfoque principal | Persistencia y ubicación en memoria (l-valor fijo). | Inmutabilidad del valor (no se puede reasignar). |
| Modificación del valor | Su valor sí puede cambiar durante la ejecución. | Su valor no puede cambiar después de la inicialización. |
| Dirección en memoria | Tiene un l-valor fijo (asignado en el segmento de datos). | Puede tener un l-valor fijo o no, dependiendo del contexto. |