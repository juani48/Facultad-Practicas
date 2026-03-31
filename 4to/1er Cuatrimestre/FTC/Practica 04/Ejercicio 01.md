## Considerando la reducción de $HP$ a $L_U$ descripta en clase, responder: 

### A - Explicar por qué la función identidad, es decir la función que a toda cadena le asigna la misma cadena, no es una reducción de $HP$ a $L_U$. 
Porque la codificación $<M_1>$ no es idéntica a $<M_2>$, debido a que los estados $q_R$ de $<M_1>$ son cambiados a $q_A$ en $<M_2>$.

### B - Explicar  por  qué  las  MT  $M_2$  generadas  en  los  pares  de  salida  $(<M_2>,  w)$, o bien paran aceptando, o bien loopean. 
Porque $M_2$ es $M_1$ con sus estados $q_R$ cambiados a $q_A$, por lo que el proceso para entrar en loop de $M_1$ no se ve altera si $M_2$ cambia el estado de rechazo por aceptación.

### C - Explicar por qué la función utilizada para reducir $HP$ a $L_U$ también sirve para reducir $HP^C$ a $L_U^C$.
Porque se reduce a "invertir" los conjuntos aplicando el complemento, por lo que si el par $(<M_1>, w) \notin HP$, entonces $(<M_2>, w) \notin L_U$, por lo que $(<M_1>, w) \in HP^C$ y entonces $(<M_2>, w) \in L_U^C$.

### D - Explicar por qué la función utilizada para reducir $HP$ a $L_U$ no sirve para reducir $L_U$ a $HP$. 
Porque si $L_U = \{(<M_1>, w) | M\ \text{acepta}\ w \}$ y $HP = \{ (<M_2>, w) | M\ \text{para a partir de}\ w \}$ y $M_f$ cambia los estados $q_R$ de $M_1$ a $q_A$ de $M_2$;si una MT $M_1$ acepta $w$, $M_1 \in L_U$ por lo que $M_2$ para y $M_2 \in HP$; ahora si una $M_1 \notin L_U$,  significa que $M_2$ no acepta $w$, por lo que $M_2 \in HP$ porque para a partir de $w$. Esto no respeta que si $L_1 \le L_2$ y $w_1 \notin L_1$, entonces $w_2 \notin L_2$.

### E - Explicar por qué la siguiente MT $M_f$ no computa una reducción de $HP$ a $L_U$: Dada una cadena válida $(<M>, w)$, $M_f$ ejecuta $M$ sobre $w$, si $M$ acepta entonces genera la salida $(<M>, w)$, y si $M$ rechaza entonces genera la cadena 1. 
Por $<M>$ podría no parar a partir de $w$, por lo que $M_f$ no pararía al simular $M$.