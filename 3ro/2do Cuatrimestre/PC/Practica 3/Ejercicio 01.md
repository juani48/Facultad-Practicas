## Se dispone de un puente por el cual puede pasar un solo auto a la vez. Un auto pide permiso para pasar por el puente, cruza por el mismo y luego sigue su camino.
```c
Monitor Puente {
    cond cola;
    int cant = 0;
    
    Procedure entrarPuente (){
        while ( cant > 0) {
            wait(cola);
        }
        cant = cant + 1;
    }

    Procedure salirPuente (){
        cant = cant - 1;
        signal(cola);
    }
}

Process Auto [i = 1 to M]{
    Puente.entrarPuente(i);
    // “el auto cruza el puente”
    Puente.salirPuente(i);
}
```
### A - ¿El código funciona correctamente? Justifique su respuesta.
Si, el codigo funciona correctamente porque si un proceso se duerme en la variable condicion, y es desperata por otro proceso, re evaluara la condicion, permitiendo que si otro proceso logra acceder al monitor y ver que `cant == 0` y acceda a la SC, el proceso despertado no accedera a la SC critica, ya que debe ver que la variable `cant == 1`.

### B - ¿Se podría simplificar el programa? ¿Sin monitor? ¿Menos procedimientos? ¿Sin variable condition? En caso afirmativo, rescriba el código.
Con menos procedimientos:
```c
Monitor Puente {
    cond cola;
    bool libre = true;
    
    Procedure acceder(acceder: bool){
        if (acceder){
            while(!libre){
                wait(cola);
            }
            libre = false
        }
        else{
            libre = true
            signal(cola)
        }
    }
}

Process Auto [i = 1 to M]{
    Puente.acceder(true);
    // “el auto cruza el puente”
    Puente.acceder(false);
}
```
Sin monitor:
```c
sem mutex = 1
Process Auto [i = 1 to M]{
    P(mutex);
    // “el auto cruza el puente”
    V(mutex);
}
```
Sin variable condicion (busy waitin):
```c
Monitor Puente {
    bool condecer[M] = (M false);
    int libre = true;
    
    Procedure entrarPuente(pos: int){
        if (libre){
            libre = false;
            condecer[pos] = true;
        }
    }

    Procedure salirPuente(){
        libre = true;
    }
}

Process Auto [i = 1 to M]{
    while(!conceder[i]){
        Puente.entrarPuente(i);
    }
    // “el auto cruza el puente”
    Puente.salirPuente();
}
```
### C - ¿La solución original respeta el orden de llegada de los vehículos? Si rescribió el código en el punto B, ¿esa solución respeta el orden de llegada?
La solucion original no respeta el orden de llegada ni la solucion de B