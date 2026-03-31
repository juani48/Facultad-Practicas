## Dar la idea general de cómo sería una MT que, teniendo como cadena de entrada un número natural i, genera la i-ésima fórmula booleana satisfactible según el orden canónico. 
> Asumir que existen una MT $M_1$ que determina si una cadena es una fórmula booleana, y una MT $M_2$ que determina si una fórmula booleana es satisfactible. 

Una MT $B$ que recibe un numero natural i y hace:
1. Genera una formula booleana de tamaño i siguiendo el orden canónico.
2. Simula $M_1$, si $M_1$ rechaza, $B$ vuelve al paso 1.
3. Si $M_1$ acepta la formula booleana generada, $B$ simula $M_2$, si $M_2$ rechaza $B$ vuelve al paso 1.
4. Si $M_2$ acepta, $B$ imprime la formula booleana y termina.