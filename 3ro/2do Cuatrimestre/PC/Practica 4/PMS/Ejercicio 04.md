## En una exposición aeronáutica hay un simulador de vuelo (que debe ser usado con exclusión mutua) y un empleado encargado de administrar su uso. Hay P personas que esperan a que el empleado lo deje acceder al simulador, lo usa por un rato y se retira.
> Nota: cada persona usa sólo una vez el simulador.

### A - Implemente una solución donde el empleado sólo se ocupa de garantizar la exclusión mutua (sin importar el orden).
```c
process Persona[i := 0 to P-1]{
    Empleado!espera(i);
    Empleado?();
    // Usa la maquina
    Empleado!();
}
process Empleado{
    int id;
    for(0 to P-1){
        Persona[*]?espera(id);
        Persona[id]!();
        Persona[id]?();
    }
}
``` 

### B - Modifique la solución anterior para que el empleado los deje acceder según el orden de su identificador (hasta que la persona i no lo haya usado, la persona i+1 debe esperar).
```c
process Persona[i := 0 to P-1]{
    Empleado?();
    // Usa la maquina
    Empleado!();
}
process Empleado{
    for(j := 0 to P-1){
        Persona[j]!();
        Persona[j]?();
    }
}
``` 

### C - Modifique la solución A para que el empleado considere el orden de llegada para dara cceso al simulador.
```c
process Persona[i := 0 to P-1]{
    Buffer!(i);
    Empleado?();
    // Usa la maquina
    Empleado!();
}
process Buffer{
    bool ok := true;
    cola cola;
    int id;
    do
    [] ok; Persona[*]?(id) -> cola.push(id);
    [] (ok) and (!cola.empty()); Empleado?ready() -> Emplado!send(cola.pop()); 
    [] ok; Empleado?fin() -> ok := false;
    od
}
process Empleado{
    int id;
    for(0 to P-1){
        Buffer!ready();
        Buffer?send(id);
        // La Persona usa la maquina
        Persona[id]!();
        Persona[id]?();
    }
    Buffer!fin();
}
``` 
