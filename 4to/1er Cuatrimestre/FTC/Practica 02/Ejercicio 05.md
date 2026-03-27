## Dada una MT M1 con alfabeto $Γ = \{0, 1, B\}$: 

### 1 - Construir una MT $M_2$, utilizando la MT $M_1$, que acepte, cualquiera sea su cadena de entrada, si la MT $M_1$ acepta al menos una cadena.  

### 2 - ¿Se puede construir además una MT $M_3$, utilizando la MT $M_1$, que acepte, cualquiera sea su cadena de entrada, si la MT $M_1$ acepta a lo sumo una cadena? Justificar. Ayuda para la parte (1): si $M_1$ acepta al menos una cadena, entonces existe al menos una cadena de símbolos 0 y 1, de tamaño $n$, tal que $M_1$ la acepta en $k$ pasos. Teniendo en cuenta esto, pensar cómo $M_2$ podría simular $M_1$ considerando todas las cadenas de símbolos 0 y 1 hasta encontrar eventualmente una que $M_1$ acepte (¡cuidándose de los casos en que M1 entre en loop!).  
