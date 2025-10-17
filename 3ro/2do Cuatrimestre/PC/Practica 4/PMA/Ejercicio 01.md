## Suponga que N clientes llegan a la cola de un banco y que serán atendidos por sus empleados. Analice el problema y defina qué procesos, recursos y canales/comunicaciones serán necesarios/convenientes para resolverlo. Luego, resuelva considerando las siguientes situaciones:

### A - Existe un único empleado, el cual atiende por orden de llegada.

```c
chan input(int: id);
chan output[N];

process Cliente[i := 0 to N-1]{
    send input(i);
    recive output[i];
}

process Empleado {
    int cliente; 
    while(true){
        recive(cliente);
        // Atiende al cliente
        send output[cliente]();
    }
}
```

### B - Ídem A pero considerando que hay 2 empleados para atender, ¿qué debe modificarse en la solución anterior?
```c
chan input(int: id);
chan output[N];

process Cliente[i := 0 to N-1]{
    send input(i);
    recive output[i];
}

process Empleado[i := 1 to 2] {
    int cliente; 
    while(true){
        recive(cliente);
        // Atiende al cliente
        send output[cliente]();
    }
}
```

### C - Ídem B pero considerando que, si no hay clientes para atender, los empleados realizan tareas administrativas durante 15 minutos. ¿Se puede resolver sin usar procesos adicionales? ¿Qué consecuencias implicaría?
```c
chan input(int: id);
chan output[N];
chan reday(int e);
chan data[2](int id)

process Cliente[i := 0 to N-1]{
    send input(i);
    recive output[i];
}
process Buffer{
    int id, e;
    while(true){
        recive ready(e);
        if (not empty(input)){
            recive input(id);
        }
        else {
            id := -1;
        }
        send data[e](id);
    }
}
process Empleado[i := 1 to 2] {
    int cliente; 
    while(true){
        send ready(i);
        recive data[i](cliente)
        if (cliente != -1){
            // Atiende al cliente
            send output[cliente]();
        }
        else {
            delay(15); // realiza tareas administrativas durante 15 min
        }
    }
}
```