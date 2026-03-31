## Sea el lenguaje $D_{HP} = \{w_i | M_i\ \text{para a partir de}\ w_i\}$ (considerar el orden canónico). Encontrar una reducción de $D_{HP}$ a $HP$. 
> Hay que definir la función de reducción y probar su total computabilidad y correctitud.

Siendo el lenguaje $HP = \{ (<M>, w) | M \text{para a partir de} w\}$.

- Reducción: $<M_i>$ es la codificación de una MT $M_i$ que acepta $w_i$.
- Compatibilidad:  $M_f$ genera la codificación $<M_i>$ a partir de encontrar el $i$ generando palabras $w$ en orden canónico y comparándolas con $w_i$.
- Correctitud:
	- $w_i \in D_{HP} \rightarrow M_i\ \text{para a partir de}\ w_i \rightarrow (<M_i>, w_i) \in HP \rightarrow <M_i> \text{para a partir de}\ w_i$
	- $w_i \notin D_{HP}$: 
		- $\text{si } w_i \text{ es una cadena valida: } M_i \text{ no para a partir de } w_i \rightarrow \text{ por lo que } <M_i> \text{ no para a partir de } w_i \rightarrow (<M_i, w_i) \notin HP$ 
		- $\text{si } w_i \text{ es una cadena invalida: } (<M_i>, w_i) \text{ tambien es invalida } \rightarrow (<M_i, w_i) \notin HP$ 