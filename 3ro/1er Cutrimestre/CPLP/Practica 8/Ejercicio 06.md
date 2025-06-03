## ¿Cuál es la construcción para expresar múltiples selección que implementa C? ¿Trabaja de la misma manera que la de Pascal, ADA o Python?

En C se define una expresion de multiple seleccion como un constructor `switch (expresion)` que contiene un expresion, y una serie de casos `case valor:`, con valores constantes, donde si el resultado de la expresion coincide con el valor de algun caso, este se ejecuta. Opcionalmente dentro de cada caso puede haber una sentencia `break`, que provoca la salida de caso y del selector multiple; tambien se puede agregar opcionalmente un caso `default` para los casos en que el valor no coincida con ninguna de las opciones establecidas.

Pascal y Python construyen semanticamente de forma similar una seleccion multiple que C, solo cambian aspectos sintaticos.

Ada presenta reglas mas estrictas, mientras en C y Pascal se permiten expresiones que devuelvan valores de tipos ordinales, Ada solo permite de tipo entero o enumerativo. Ademas se debe contemplar todos los casos posibles y la seleccion multiple deb tener un cierre `end case;`. Una vez que se ejecuta una rama del `case`, el `case` finaliza y no se ejecuta ninguna otra rama.
