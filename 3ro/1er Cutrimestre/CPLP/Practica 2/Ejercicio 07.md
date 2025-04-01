## Defina en EBNF la gramática para la definición de números reales. Inténtelo desarrollar para BNF y explique las diferencias con la utilización de la gramática EBNF.

# EBNF
```
G = {
	N, T, S, P
}

N = {
	< numero >,
	< digito >
}

T = {
	0, 1, 2, 3, 4, 5, 6, 7, 8, 9, '+', '-', '.'
}

S = {
	< numero >
}

P = {
	< numero > ::= [('+' | '-')] {< digito >}+ '.' {< digito >}+
	< digito > ::= (0 | 1 | ... | 9)
}
```

# BNF
```
G = {
	N, T, S, P
}

N = {
	< numero_real >,
	< digito >,
	< signo >
}

T = {
	0, 1, 2, 3, 4, 5, 6, 7, 8, 9, '+', '-', '.'
}

S = {
	< numero_real >
}

P = {
	< numero_real > ::= < signo > < digito > '.' < digito > | < digito > '.' < digito >
	< signo > ::= '+' | '-'
	< digito > ::= 0 | 1 | ... | 9
}
```
