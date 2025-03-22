## Defina en BNF (Gramática de contexto libre desarrollada por Backus- Naur) la gramática para la definición de una palabra cualquiera.

G = {

	N, T, S, P
}

N = { 

	< palabra >, 
	< letra >
}

T = {
	
	A, B, C, ...., Z, a, b, c, ... , z 
}

S = { 

	< palabra > 
}

P = {

	< palabra > ::= < letra > | < letra >< palabra >,

	< letra > ::= T
}
