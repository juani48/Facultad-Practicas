## Realice en EBNF la gramática para la definición un tag div en html 5. (Puede ayudarse con el siguiente enlace (https://developer.mozilla.org/es/docs/Web/HTML/Elemento/div))

G = {

    N, T, S, P
}

N = {

    < exp_div >,
    < atributo >,
    < texto >,
    < sentencia >
}

T = {

    <, />, >, div, A, B, ... , Z, a, b, ... , z, -, /, ".", ",", ",
}

S = {

    < exp_div >
}

P = {

    < exp_div > ::= < div {< atributo > = " < texto > "}* > < sentencia > < div />
    < atributo > ::= (a | b | ... | z){< atributo >}*
    < texto > ::= (A | B | ... | Z | a | b | ... | z | - | / | . | ,){ < texto > }*
}