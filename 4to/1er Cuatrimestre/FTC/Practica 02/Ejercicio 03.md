## Probar:

### 1 - La clase R es cerrada con respecto a la operación de unión.

Si $L_1 \in R$ y $L_2 \in R$ entonces $L_1 \cup L_2 \in R$ 

Es decir: Si existe una MT $M_1$ que decide $L_1$ y existe una MT $M_2$ que decide $M_2$, existe también una MT $M$ que decide $L_1 \cup L_2$.

Idea general: Construir una MT $M$ que ejecute secuencialmente las MT $M_1$ y $M_2$ y acepte la entra $w$ si $M_1$ o $M_2$ la aceptan.

### 2 - La clase RE es cerrada con respecto a la operación de intersección.

Si $L_1 \in RE$ y $L_2 \in RE$ entonces $L_1 \cap L_2 \in RE$

Es decir: Si existe una MT $M_1$ que acepta $L_1$ y existe una MT $M_2$ que acepta $L_2$, existe también una MT $M$ que acepta $L_1 \cap L_2$.

Idea general: Construir una MT $M$ que ejecute paralelamente las MT $M_1$ y $M_2$ y acepte la entra $w$ si $M_1$ y $M_2$ la aceptan, con que $M_1$ o $M_2$ la rechace alcanza para que $M$ rechace la palabra. Es aceptable que si $M_1$ o $M_2$ loopean, $M$ loopean porque $M$ acepta $L_1 \cap L_2 \in RE$

