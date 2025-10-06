## Implemente una solución para el siguiente problema. 
### Se debe simular el uso de una máquina expendedora de gaseosas con capacidad para 100 latas por parte de U usuarios. Además, existe un repositor encargado de reponer las latas de la máquina. Los usuarios usan la máquina según el orden de llegada. Cuando les toca usarla, sacan una lata y luego se retiran. En el caso de que la máquina se quede sin latas, entonces le debe avisar al repositor para que cargue nuevamente la máquina en forma completa. Luego de la recarga, saca una botella y se retira. 
> Nota: maximizar la concurrencia; mientras se reponen las latas se debe permitir que otros usuarios puedan agregarse a la fila.

```c
cola maquina := (100 push(gaseosa)) // 100 push() con las gaseosa
sem R_mutex := 0;
sem U_mutex := 0;

cola cola;
bool libre := true;
sem mutex := 1;
sem privados[U] := (U 0);


process Usuario[i := 0 to U-1]{
    int refresco;

    P(mutex);
    if(!libre){
        cola.push(i);
        V(mutex);
        P(privados[i]);
    }
    libre := false;
    V(mutex);

    if(maquina.empty()){
        V(R_mutex);
        P(U_mutex);
    }
    refresco := maquina.pop();

    P(mutex);
    libre := true;
    if(!cola.empty()){
        int sig := cola.pop();
        V(privados[sig]);
    }
    else{
        V(mutex);
    }
}

process Respositor {
    int refresco := 0;
    while(true){
        P(R_mutex);
        while(refresco < 100){
            maquina.push(refresco);
            refresco++;
        }
        V(U_mutex);
        refresco := 0;
    }
}
```

