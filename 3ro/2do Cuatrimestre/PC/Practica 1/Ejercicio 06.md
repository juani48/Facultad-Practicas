## Dada la siguiente solución para el Problema de la Sección Crítica entre dos procesos (suponiendo que tanto SC como SNC son segmentos de código finitos, es decir que terminan en algún momento), indicar si cumple con las 4 condiciones requeridas:
```
int turno = 1;
Process SC1::{
    while (true){ 
        while (turno == 2) skip;
        SC;
        turno = 2;
        SNC;
    }
}
Process SC2::{ 
    while (true){ 
        while (turno == 1) skip;
        SC;
        turno = 1;
        SNC;
    }
}
```

Se cuple la propiedad de exclusión mutua, debido a que solo un proceso se puede econtrar en la SC. Cumple la condicion de livelock debido a que si los dos procesos intentar acceder a la SC, solo uno tiene exito. Cumple la propiedad de ausencia de demora innecesaria, dado que si un proceso quiere entrar a la SC y el otro esta en su SNC o ya termino de ejecutar, el primero puede entrar. Y la eventual entrada se da porque las SC y SNC son finitas.

