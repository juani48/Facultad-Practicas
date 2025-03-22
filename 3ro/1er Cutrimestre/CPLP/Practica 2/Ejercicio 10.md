## A - Defina con EBNF la gramática para una expresión numérica, dónde intervienen variables y números. Considerar los operadores +, -, * y / sin orden de prioridad. No considerar el uso de paréntesis.

G = {

    N, T, S, P
}

N = {

    < exp > ,
    < num > ,
    < var >
}