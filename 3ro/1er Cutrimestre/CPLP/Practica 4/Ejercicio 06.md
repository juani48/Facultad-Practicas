## Sea el siguiente archivo con funciones de C
```c
{
    int x=1; //(1)
    ​int func1();{
        int i;
        for (i:=0; i < 4; i++)
            x=x+1;
    }
    int func2();{
        int i, j;
        /*
        sentencias que contienen declaraciones 
        y sentencias que no contienen declaraciones
        */​
        for (i:=0; i < 3; i++) 
            j=func1 + 1;
        }
}
```

### Analice si llegaría a tener el mismo comportamiento en cuanto a alocación de memoria, sacar la declaración (1) y colocar dentro de func1() la declaración: 
```c
static int x =1;
```

Si, llegaria a tener el mismo comportamiento en memoria, aunque su locacion seria en el area de datos y no en la pila.



