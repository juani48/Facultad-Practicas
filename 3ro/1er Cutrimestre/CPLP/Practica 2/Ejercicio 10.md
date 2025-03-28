## A - Defina con EBNF la gramática para una expresión numérica, dónde intervienen variables y números. Considerar los operadores +, -, * y / sin orden de prioridad. No considerar el uso de paréntesis.
```
G = {
    N, T, S, P
}

N = {
    < exp > ,
    < num > ,
    < var >
}

T = {
    0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
    A, B, ... , Z, a, b, ... , z, _,
    +, -, *, /
}

S = {
    < exp >
}

P = {
    < exp > ::= (< num > | < var >){ (+ | - | * | /) < exp > }*
    < num > ::= (0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9)
    < var > ::= (A | B | ... | Z | a | b | ... | z | _ ){< var >}*
}
```