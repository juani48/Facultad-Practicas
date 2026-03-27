## Describir la idea general de una MT con varias cintas que acepte, de la manera más eficiente posible (menor cantidad de pasos), el lenguaje $L\ =\ \{a^nb^nc^n\ |\ n\ ≥\ 0\}$

Una MT M con 4 cintas:
1. Escribe tantas $X$ en la cinta 2 como $a$ en la cinta de entrada 1.
2. Escribe tantas $X$ en la cinta 3 como $b$ en la cinta de entrada 1.
3. Escribe tantas $X$ entradas en la cinta 4 como $c$ en la cinta de entrada 1.
4. Se desplaza a al izquierda en las cintas 2, 3 y 4 escribiendo en $B$ si en las 3 cintas hay $X$. Si se encuentra en las 3 cintas $B$ en la misma posición, acepta la entrada, caso contrario rechaza la entrada.