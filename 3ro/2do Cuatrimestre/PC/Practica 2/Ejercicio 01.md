## Existen N personas que deben ser chequeadas por un detector de metales antes de poder ingresar al avión.

### A - Analice el problema y defina qué procesos, recursos y semáforos/sincronizaciones serán necesarios/convenientes para resolverlo.
- N procesos persona
- El recurso es el dectector de metales
- Solo una persona puede acceder al detector por lo que se necesitara un semaforo global o publico

### B - Implemente una solución que modele el acceso de las personas a un detector (es decir, si el detector está libre la persona lo puede utilizar; en caso contrario, debe esperar).
```c
sem s := 1;

process Persona[i=0 to N]{
    P(s);
    // Accede al detector
    V(s);
    // Libera el detector
}
```

### C - Modifique su solución para el caso que haya tres detectores.
```c
sem s := 3;

process Persona[i=0 to N]{
    P(s);
    // Accede al detector
    V(s);
    // Libera el detector
}
```

### D - Modifique la solución anterior para el caso en que cada persona pueda pasar más de una vez, siendo aleatoria esa cantidad de veces.
```c
sem s := 3;

process Persona[i=0 to N]{
    int cant := random_integer() // Retorna un numero entero aleatorio
    for int j := 0; j < cant; j++{
        P(s);
        // Accede al detector
        V(s);
        // Libera el detector
    } 
}
```