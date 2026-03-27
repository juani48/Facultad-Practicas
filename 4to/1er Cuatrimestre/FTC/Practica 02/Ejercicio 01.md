## Responder breve y claramente los siguientes incisos: 
### 1 - ¿En qué se diferencian los lenguajes recursivos, los lenguajes recursivamente enumerables no recursivos y los lenguajes no recursivamente enumerables? 

Se diferencian en que los lenguajes recursivos representan sólo los problemas computables decidibles, porque las MT $M$ que los reconocen se detienen siempre. Los lenguajes recursivamente enumerables no recursivos son aquellos problemas computables no decidibles, donde una MT $M$ lo reconoce pero no siempre se detiene al rechazar el lenguaje. Por ultimo los lenguajes no recursivamente enumerables son aquellos problemas que no tienen una una MT $M$ que los reconozca; son el complemento de los lenguajes recursivamente enumerables no recursivos.

### 2 - Probar que $R \subseteq RE \subseteq 𝔏$. 


### 3 - Dijimos en clase que el hecho de que si $L$ es recursivo entonces $L^C$ también lo es, significa en términos de problemas que si un problema es decidible entonces también lo es el problema contrario. ¿Qué  significa en términos de problemas que la intersección de dos lenguajes recursivos es también un lenguaje recursivo? 

La intersección de lenguajes recursivos significa que: Si dos problemas son decidibles, también es decidible el problema de verificar si una instancia satisface ambos simultáneamente.
### 4 - Explicar por qué no es correcta la siguiente prueba de que si $L \in RE$, también $L^C \in RE$: dada una MT $M$ que acepta $L$, entonces la MT $M’$, igual que $M$ pero con los estados finales permutados, acepta $L^C$.

Esta prueba es incorrecta porque por definición 
### 5 - ¿Qué lenguajes de la clase $CO \text{-}RE$ tienen MT que los aceptan? ¿También los deciden?  

Los lenguajes $L^C$ de $L \in CO \text{-}RE$ ($L^C \in RE$) tienes MT que los aceptan, pero estos son no decidibles.
### 6 - Probar que el lenguaje $Ʃ^*$ de todas las cadenas y el lenguaje vacío $∅$ son recursivos. Alcanza con plantear la idea general. 

Si dado el alfabeto $Ʃ = \{a \}$ , entonces $Ʃ^* = \{λ, a, aa, aaa, ..., a^n \}$ es decidible si existe una MT $M$ que acepte el leguaje $a^n$

Idea general: $M$ ejecuta $n$ movimientos verificando que en cada celda haya una $a$, acepta la palabra si encuentra un $B$ al final de los $n$ movimientos y si no eocntro otro caracte que $a$ en los $n$ movimientos. Entonces $Ʃ^*$ es recursivo.


### 7 - Probar que todo lenguaje finito es recursivo. Alcanza con plantear la idea general. Ayuda: encontrar una MT que lo decida (pensar cómo definir sus transiciones para cada una de las cadenas del lenguaje).
