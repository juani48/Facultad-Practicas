## Resolver la administración de 3 impresoras de una oficina. Las impresoras son usadas por N administrativos, los cuales están continuamente trabajando y cada tanto envían documentos a imprimir. Cada impresora, cuando está libre, toma un documento y lo imprime, de acuerdo con el orden de llegada.
> Nota: ni los administrativos ni el director deben esperar a que se imprima el documento.

### A - Implemente una solución para el problema descrito.
```c
chan imprimir(doc);
process Administrativo[i := 0 to N-1]{
    while(true){
        // realizan su trabajo
        send imprimir(doc);
    }
}
process Impresora[i := 0 to 2]{
    while(true){
        recive imprimir(doc);
        Imprimir(doc);
    }
}
```

### B - Modifique la solución implementada para que considere la presencia de un director de oficina que también usa las impresas, el cual tiene prioridad sobre los administrativos.
```c
chan admin(doc);
chan direc(doc);
process Administrativo[i := 0 to N-1]{
    while(true){
        // realizan su trabajo
        send imprimir(doc);
    }
}
process Directivo{
    while(true){
        // realizan su trabajo
        send imprimir(doc);
    }
}
process Impresora[i := 0 to 2]{
    while(true){
        if
        [] (not empty(admin)) and (empty(direc)) ->
            recive admin(doc);
            Imprimir(doc)
        [] (not empty(direc)) ->
            recive direct(doc);
            Imprimir(doc);  
        fi
    }
}
```

### C - Modifique la solución (A) considerando que cada administrativo imprime 10 trabajos y que todos los procesos deben terminar su ejecución.
```c
chan admin(doc);
chan impresora[3];
process Administrativo[i := 0 to N-1]{
    for (i := 0 to 9){
        // realizan su trabajo
        send admin(doc);
    }
}
process Impresora[i := 0 to 2]{
    int cant := 0;
    while(true){ // o preguntar si esta bien un for de 1 a n*10
        if
        [] (not empty(admin)) ->
            recive admin(doc);
            Imprimir(doc);
            for(j := 0 to 2){
                if (j == i){ continue; }
                else { send impresora[j]; }
            }
            cant++;
        [] (not empty(impresora[i])) ->
            cant++;
        [] (cant == (N*10)) ->
            break;
        fi
    }
}
```

### D - Modifique la solución (B) considerando que tanto el director como cada administrativo imprimen 10 trabajos y que todos los procesos deben terminar su ejecución.
```c
chan admin(doc);
chan direc(doc);
chan impresora[3];
process Administrativo[i := 0 to N-1]{
    for(j := 0 to 9){
        // realizan su trabajo
        send imprimir(doc);
    }
}
process Directivo{
    for(j := 0 to 9){
        // realizan su trabajo
        send imprimir(doc);
    }
}
process Impresora[i := 0 to 2]{
    int cant_a := 0;
    while(true){
        if
        [] (not empty(admin)) and (empty(direc)) ->
            recive admin(doc);
            Imprimir(doc);
            for(j := 0 to 2){
                if (j == i){ continue; }
                else { send impresora[j]; }
            }
            cant++;
        [] (not empty(direc)) ->
            recive direct(doc);
            Imprimir(doc);
            for(j := 0 to 2){
                if (j == i){ continue; }
                else { send impresora[j]; }
            }
            cant++;
        [] (not empty(impresora[i])) ->
            cant++; 
        [] (cant == (N*10+10)) ->
            break;
        fi
    }
}
```

### E - Si la solución al ítem (D) implica realizar Busy Waiting, modifíquela para evitarlo.
```c
// NO SE
```