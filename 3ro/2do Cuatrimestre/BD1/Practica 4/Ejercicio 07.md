## Indique si las siguientes afirmaciones sobre triggers son verdaderas o falsas.  Justifique las falsas.

### A - Un trigger se ejecuta únicamente cuando se inserta una fila en una tabla.

Falso, para que un trigger se ejecute se debe provocar el o los eventos paticulaes con los que se asocio. Dada una tabla, puede haber un trigger para el momento de insertar y otro para el momento de modificar.

### B - Un trigger puede ejecutarse antes o después de la operación, esto es definido automáticamente según el tipo de la operación (UPDATE, INSERT  o DELETE)

Falso, se debe definir si el trigger se ejecuta antes o despues del evento, esto es establecido en la definicion del trigger.

### C - Todo trigger debe asociarse a una tabla en concreto. 

Verdadero.

### D - NEW y OLD son palabras clave que permiten acceder a los valores de las filas afectadas y se pueden usar ambos independientemente de la operación utilizada.

Verdadero.

### E - FOR EACH ROW en un trigger se usa para indicar que el trigger se ejecutará una vez por cada fila afectada por la operación.

Verdadero.