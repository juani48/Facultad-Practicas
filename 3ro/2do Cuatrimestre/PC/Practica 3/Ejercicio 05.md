## En un corralón de materiales se deben atender a N clientes de acuerdo con el orden de llegada. Cuando un cliente es llamado para ser atendido, entrega una lista con los productos que comprará, y espera a que alguno de los empleados le entregue el comprobante de la compra realizada.

### A - Resuelva considerando que el corralón tiene un único empleado.
```c
Monitor Corralon{
    cond empledo;
    cond cola;
    cond cliente;
    int espera = 0;

    procedure ser_atendido(){
        espera++;
        signal(empleado);
        wait(cola);
        // Entregar lista de compra al empleado
        signal(empleado);
        wait(cliente);
    }

    procedure atender(){
        if (espera == 0){
            wait(empledo);
        }
        espera--; 
        signal(cola);
        wait(empleado);
        // Generar comprobante y entregar al cliente
        signal(cliente);
    }
}
process Cliente[i = 0 to N-1]{
    Corralon.ser_atendido();
}
process Empleado{
    for(int i = 0; i < N; i++){
        Corralon.atender()
    }
}
```

### B - Resuelva considerando que el corralón tiene E empleados (E > 1). Los empleados no deben terminar su ejecución.
```c
Monitor Corralon{
    cond libre; cond empleado;
    cond cola; 
    cond cliente;
    int esperando = 0;

    procedure ser_atendido(){
        esperando++;
        signal(libre);
        wait(cola);
        // Entregar lista de compra al empleado
        signal(empleado);
        wait(cliente);
    }

    procedure atender(){
        if (esperando == 0){
            wait(libre);
        }
        esperando--;
        signal(cola); 
        wait(empleado);
        // Generar comprobante y entregar al cliente
        signal(cliente);
    }
}
process Cliente[i = 0 to N-1]{
    Corralon.ser_atendido();
}
process Empleado[i = 0 to E-1]{
    while(true){
        Corralon.atender();
    }
}
```

### C - Modifique la solución (b) considerando que los empleados deben terminar su ejecución cuando se hayan atendido todos los clientes.
```c
int total = 0;
Monitor Corralon{
    cond libre; cond empleado;
    cond cola; 
    cond cliente;
    int esperando = 0;

    procedure ser_atendido(){
        esperando++;
        signal(libre);
        wait(cola);
        // Entregar lista de compra al empleado
        signal(empleado);
        wait(cliente);
    }

    procedure atender(){
        if (esperando == 0){
            wait(libre);
        }
        esperando--;
        signal(cola); 
        wait(empleado);
        // Generar comprobante y entregar al cliente
        signal(cliente);
        total++;
    }
}
process Cliente[i = 0 to N-1]{
    Corralon.ser_atendido();
}
process Empleado[i = 0 to E-1]{
    while(total < N){
        Corralon.atender();
    }
}
```