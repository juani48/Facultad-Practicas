## ¿Qué es una MT universal? 
Una MT universal es aquella que recibe como entrada el código de una MT cualquiera y posee como función de transición especifica como ejecutar el código de la MT recibida. Por lo general la entrada de una MT $U$ es un par $(<M>, w)$ donde $<M>$ es el código de una MT y $w$ es una entrada para $M$. Entonces una MT $U$ simula la ejecución de $M$ en base a su $<M>$ y decide el $w$, osea que una MT $U$ responde a una entrada $w$ en base a la respuesta que provoque $M$ una vez simulada, esto implicando el no detenerse si es que $M$ no se detiene.

La MT $U$ posee una única cinta con varias celdas para simulas las diferentes MT. 

La función de transición de $U$ consiste en recorrer las 5-tuplas del código de $M$ hasta encontrar el par formado por el estado actual simulado de $M$ y el o los valores actuales apuntados, si se encuentra dicha 5-tupla $U$ sigue simulando $M$, caso contrario rechaza la entrada $w$.