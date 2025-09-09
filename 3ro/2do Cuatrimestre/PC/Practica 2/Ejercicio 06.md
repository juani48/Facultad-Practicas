## Existen N personas que deben imprimir un trabajo cada una. Resolver cada ítem usando semáforos:

### A - Implemente una solución suponiendo que existe una única impresora compartida por todas las personas, y las mismas la deben usar de a una persona a la vez, sin importar el orden. Existe una función Imprimir(documento) llamada por la persona que simula el uso de la impresora. Sólo se deben usar los procesos que representan a las Personas.
```c
sem mutex := 1;

process Persona[i := 1 to N]{
    P(mutex);
    Imprimir(documento);
    V(mutex);
}
```

### B - Modifique la solución de (A) para el caso en que se deba respetar el orden de llegada.
```c
sem mutex := 1;
cola C; sem c_mutex := 1;
sem privados[N] := (N 0);
bool libre := true

process Persona[i := 0 to N-1]{
    P(mutex);
    if (not libre){
        P(c_mutex) push(C, i); V(c_mutex);
        V(mutex);
        P(privados[i]);
    }
    libre := false;
    V(mutex);
    Imprimir(documento);
    P(mutex); P(c_mutex);
    if (not empty(cola)){
        int id := pop(C);
        V(c_mutex);
        V(privados[id]);
    }
    else {
        libre:= true;
        V(mutex); V(c_mutex);
    }
}
```

### C - Modifique la solución de (A) para el caso en que se deba respetar estrictamente el orden dado por el identificador del proceso (la persona X no puede usar la impresora hasta que no haya terminado de usarla la persona X-1).
```c
sem privados[N] := (0 1) + (N 0); // EL primer semaforo en 1 el resto en 0

process Persona[i := 0 to N-1]{
    P(privados[i]);
    Imprimir(documento);
    V(privados[i+1]);
}
```

### D - Modifique la solución de (B) para el caso en que además hay un proceso Coordinador que le indica a cada persona que es su turno de usar la impresora.
```c
sem cola := 1, c_mutex := 1
cola C;
sem privados[N] := (N 0);
bool libre := true;

process Persona[i := 0 to N]{
    P(cola);
    push(C, i);
    V(cola);
    V(c_mutex);

    P(privados[i]);
    Imprimir(documento);
    libre := true
    V(c_mutex);

}
process Coordinador{
    while(true){
        P(c_mutex);
        if (libre){
            P(cola);
            id := pop(C);
            V(cola);
            libre := false
            V(privados[id]) 
        }
    }
}
```

### E - Modificar la solución (D) para el caso en que sean 5 impresoras. El coordinador le indica a la persona cuando puede usar una impresora, y cual debe usar.
```c
sem c_P := 1, c_mutex := 1, c_I := 1;
cola P;
cola I := (5 {0, 1, 2, 3, 4, 5}); // Se carga la cola con las impresoras
sem privados[N] := (N 0), impresora[5]:= (N 1);
int mensaje[N] := (N 0);
int libre := 0, ocupado := 0;

process Persona[i := 0 to N]{
    P(c_P);
    push(P, i); // Me encolo
    V(c_P);
    V(c_mutex); // Aviso

    P(privados[i]); // Espero a que me llamen
    P(impresora[mesaje[i]]); // Accedo a la impresora
    Imprimir(documento);

    P(c_I); 
    push(I, mensaje[i]); // Libero mi impresora
    V(c_I);

    V(impresora[mesaje[i]]) // Libero mi impresora
    V(c_mutex); // Aviso

}
process Coordinador{
    while(true){
        P(c_mutex);
        if (not empty(I) and not empty(P)){
            P(c_P);
            int id := pop(P); // ID de la persona esperando
            V(c_P);

            P(c_I);
            int impr := pop(I);
            V(c_I);

            mensaje[id] := impr;
            V(privados[id]);
        }
    }
}
```