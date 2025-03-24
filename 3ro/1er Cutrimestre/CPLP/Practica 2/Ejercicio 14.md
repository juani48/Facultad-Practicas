##  Sobre un lenguaje de su preferencia escriba en EBNF la gramática para la definición de funciones o métodos o procedimientos (considere los parámetros en caso de ser necesario).

Metodos en C#

G = {

    N, T, S, P
}

N = {

    < metodo >, 
    < visibilidad >, 
    < tipo >, 
    < etiqueta >, 
    < parametro >, 
    < sentencia >, 
    < valor >, 
    < numero_real >, 
    < numero >, 
    < call_metodo > , 
    < instancia >
}

T = {

    private, public, protected, void, int, string, float, double, long, short, bool, class, interface, return
    A, B, ... , Z, a, b, ... , z, _, (, ), {, }, ;, ",",
    0, 1, 2, 3, 4, 5, 6, 7, 8, 9, true, false, 
    +, -, *, /
}

S = {

    < metodo >
}

P = {

    < metodo > ::= [< visibilidad >] (< tipo > | void ) < etiqueta > "(" {< etiqueta > , }* ")" "{" {< sentencia > ;}* [ return < valor > ;] "}"
    < visibilidad > ::= (private | public | protected)
    < tipo > ::= (int | string | flota | double | long | short | bool | class | interface )
    < etiqueta > ::= (A | B | ... | Z | a | b | ... | z | _ )
    < valor > ::= (true | false | < instancia > | < exp >)
    < numero_real > ::= { < numero >}+ [,]{ < numero >}* 
    < numero > ::= (0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 ){< numero >}*
    < exp > ::= (< numero_real >{ (+ | - | * | /)< exp > }* | < call_metodo >) 
    < call_metodo > ::= < etiqueta > "(" {< etiqueta > , }* ")"
}