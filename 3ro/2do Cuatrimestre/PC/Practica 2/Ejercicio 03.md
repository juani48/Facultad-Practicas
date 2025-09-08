## Un sistema operativo mantiene 5 instancias de un recurso almacenadas en una cola. Además, existen P procesos que necesitan usar una instancia del recurso. Para eso, deben sacar la instancia de la cola antes de usarla. Una vez usada, la instancia debe ser encolada nuevamente para su reúso.
```c
cola C;
sem mutex := 1;
process Proceso[i:=1 to P]{
    // declaro recurso
    while(true){
        // espera hasta que el recurso esta disponible
        P(mutex);
        if (not empty(cola)){ 
            pop(cola, recurso); 
        }
        
        V(mutex);
        if (not empty(recuruso)){
            // procesado de recurso
            P(mutex);
            push(C, recurso);
            V(mutex);
        }
    }
}
```
