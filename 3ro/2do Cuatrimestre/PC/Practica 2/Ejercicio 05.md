## En una empresa de logística de paquetes existe una sala de contenedores donde se preparan las entregas. Cada contenedor puede almacenar un paquete y la sala cuenta con capacidad para N contenedores. Resuelva considerando las siguientes situaciones:

### A - La empresa cuenta con 2 empleados: un empleado Preparador que se ocupa de preparar los paquetes y dejarlos en los contenedores; un empelado Entregador que se ocupa de tomar los paquetes de los contenedores y realizar la entregas. Tanto el Preparador como el Entregador trabajan de a un paquete por vez.
```c
int contenedores[N];
int libre := 0; sem ocupado := 0;
sem vacio := N; lleno := 0;

process Preparador{
    while(true){
        // Prepara el apquete
        P(vacio);
        contenedores[libre] := paquete;
        libre := (libre + 1) mod N;
        V(lleno);
    }
}
process Entregador{
    while(true){
        P(vacio);
        paquete := contenedores[ocupado];
        ocupado := (ocupado + 1) mod N;
        V(lleno);
    }
}
```

### B - Modifique la solución A para el caso en que haya P empleados Preparadores.
```c
int contenedores[N];
int libre := 0; sem ocupado := 0;
sem vacio := N; lleno := 0;
sem p_mutex := 1;

process Preparador[i := 1 to P]{
    while(true){
        // Prepara el apquete
        P(vacio);
        P(p_mutex);
        contenedores[libre] := paquete;
        libre := (libre + 1) mod N;
        V(p_mutex);
        V(lleno);
    }
}
process Entregador{
    while(true){
        P(vacio);
        paquete := contenedores[ocupado];
        ocupado := (ocupado + 1) mod N;
        V(lleno);
    }
}
```

### C - Modifique la solución A para el caso en que haya E empleados Entregadores.
```c
int contenedores[N];
int libre := 0; sem ocupado := 0;
sem vacio := N; lleno := 0;
sem e_mutex := 1;

process Preparador{
    while(true){
        // Prepara el apquete
        P(vacio);
        contenedores[libre] := paquete;
        libre := (libre + 1) mod N;
        V(lleno);
    }
}
process Entregador[i := 0 to E]{
    while(true){
        P(vacio);
        P(e_mutex);
        paquete := contenedores[ocupado];
        ocupado := (ocupado + 1) mod N;
        V(e_mutex);
        V(lleno);
    }
}
```

### D - Modifique la solución A para el caso en que haya P empleados Preparadores y E empleadores Entregadores.
```c
int contenedores[N];
int libre := 0; sem ocupado := 0;
sem vacio := N; lleno := 0;
sem e_mutex := 1, p_mutex := 1;

process Preparador[i := 1 to P]{
    while(true){
        // Prepara el apquete
        P(vacio);
        P(p_mutex);
        contenedores[libre] := paquete;
        libre := (libre + 1) mod N;
        V(p_mutex);
        V(lleno);
    }
}
process Entregador[i := 0 to E]{
    while(true){
        P(vacio);
        P(e_mutex);
        paquete := contenedores[ocupado];
        ocupado := (ocupado + 1) mod N;
        V(e_mutex);
        V(lleno);
    }
}
```