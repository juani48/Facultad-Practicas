## Una fábrica de piezas metálicas debe producir T piezas por día. Para eso, cuenta con E empleados que se ocupan de producir las piezas de a una por vez. La fábrica empieza a producir una vez que todos los empleados llegaron. Mientras haya piezas por fabricar, los empleados tomarán una y la realizarán. Cada empleado puede tardar distinto tiempo en fabricar una pieza. Al finalizar el día, se debe conocer cual es el empleado que más piezas fabricó.

### A - Implemente una solución asumiendo que T > E.
```c
sem barrera[E] := (E 0);
int empleado[E] := (E 0);
cola C := (T pieza); // psuh de las T piezas
sem c_mutex := 1;
process Empleado[i := 0 to E-1]{
    // Se espera aque lleguen los empleados
    if (i == 0){
        V(barrera[i+1]);
        P(barrera[i]);
    }
    else{
        P(barrera[i]);
        V(barrera[i+1]);
    }
    
    P(c_mutex);
    while(not empty(C)){
        _pieza := pop(C);
        V(c_mutex);
        // Produccion de pieza
        empleado[i]++;
        P(c_mutex);
    }
    V(c_mutex);
}
```

### B - Implemente una solución que contemple cualquier valor de T y E.