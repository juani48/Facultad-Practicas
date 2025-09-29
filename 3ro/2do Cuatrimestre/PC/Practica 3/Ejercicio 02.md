## Existen N procesos que deben leer información de una base de datos, la cual es administrada por un motor que admite una cantidad limitada de consultas simultáneas.

### A - Analice el problema y defina qué procesos, recursos y monitores/sincronizaciones serán necesarios/convenientes para resolverlo.
- N procesos lectores
- Un monitor Administrador
- habra un contador que indique los recursos utilizados
- una variable condicion para dormir procesos

### B - Implemente el acceso a la base por parte de los procesos, sabiendo que el motor de base de datos puede atender a lo sumo 5 consultas de lectura simultáneas.

```c
monitor Admin{
    cond cola;
    int recursos = 5;

    procedure acceder(){
        while(recurso < 0){
            wait(cola);
        }
        recursos--;
    }
    procedure liberar(){
        recursos++;
        signa(cola);
    }
}

process Lector[i = 1 to N]{
    while(true){
        Admin.acceder();
        // Lee la base de datos
        Admin.liberar();
    }
}
```

