## Resolver los problemas siguientes: 

### A - En una estación de trenes, asisten P personas que deben realizar una carga de su tarjeta SUBE en la terminal disponible. La terminal es utilizada en forma exclusiva por cada persona de acuerdo con el orden de llegada. Implemente una solución utilizando únicamente procesos Persona. 
> Nota: La función UsarTerminal() le permite cargar la SUBE en la terminal disponible.  

```c
cola cola;
sem privados[P] := (P 0); // Los P semaforos se settean en 0
bool libre := true;
sem mutex := 1;

process Persona [i := 0 to P-1]{
    P(mutex);
    if (not libre){
        cola.push(i);
        V(mutex);
        P(privados[i]);
    }
    libre := false;
    V(mutex);
    UsarTerminal();
    P(mutex);
    libre := true;
    if (!cola.empty()){
        int sig := cola.pop();
        V(privados[sig]);
    }
    else {
        V(mutex);
    }
}
```

### B - Resuelva el mismo problema anterior pero ahora considerando que hay T terminales disponibles. Las personas realizan  una única fila y la carga la realizan  en  la primera terminal que se libera. Recuerde que sólo debe emplear procesos Persona. 
> Nota: la función UsarTerminal(t) le permite cargar la SUBE en la terminal t.

```c
cola cola;
sem privados[P] := (P 0); // Los P semaforos se settean en 0
cola libre := (T push(t)) // Hace T push(t), siendo t el numero de la terminar
sem mutex := 1;

process Persona [i := 0 to P-1] {
    int t;
    P(mutex);
    if (libre.empty()){
        cola.push(i);
        V(mutex);
        P(privados[i]);
    }
    t := libre.pop();
    V(mutex);
    UsarTerminal(t);
    P(mutex);
    libre.push(t);
    if (!cola.empty()){
        int sig := cola.pop();
        V(privados[sig]);
    }
    else {
        V(mutex);
    }
}
```