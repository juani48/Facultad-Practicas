## Para el siguiente programa concurrente suponga que todas las variables están inicializadas en 0 antes de empezar. Indique cual/es de las siguientes opciones son verdaderas:
1. [x] En algún caso el valor de x al terminar el programa es 56. -> Con una ejecucion secunecial de los procesos
2. [ ] En algún caso el valor de x al terminar el programa es 22.
3. [ ] En algún caso el valor de x al terminar el programa es 23.

P1:
```
If (x = 0) then
    y:= 4*2;
    x:= y + 2;
```

P2: 
```
If (x > 0) then
    x:= x + 1;
```

P3:
```
x:= (x*3) + (x*2) + 1;
```

