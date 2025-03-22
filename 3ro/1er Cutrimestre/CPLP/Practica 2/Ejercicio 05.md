## Dada la siguiente gramática escrita en BNF

### G = ( N, T, S, P)
### N = {<numero_entero>, <digito> }
### T = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
### S = <numero_entero>
### P = {
### <numero_entero>::=<digito><numero_entero> | <numero_entero><digito> | <digito>
### <digito> ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
### }

## A - Identifique las componentes de la misma

G es la gramatica, el conjunto N es de los elementos no terminales, T es el conjunto de elementos terminales, S indica que es lo que se empezara a describir y P es el conjuto de expresiones para definir los elementos no terminales.


## B - Indique porqué es ambigua y corríjala

Es ambigua al queres definir el elemento <numero_entero> ya que presenta recursividad por izquierda y por derecha, lo que genera un arbol sintactico ambiguo por tener varais posibles definiciones.

Para que sea correcto:
P = {
	<numero_entero> ::= <digito> | <digito><numero_entero>
}
