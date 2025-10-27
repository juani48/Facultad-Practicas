## Simular la atención en un locutorio con 10 cabinas telefónicas, el cual tiene un empleado que se encarga de atender a N clientes. Al llegar, cada cliente espera hasta que el empleado le indique a qué cabina ir, la usa y luego se dirige al empleado para pagarle. El empleado atiende a los clientes en el orden en que hacen los pedidos. A cada cliente se le entrega un ticket factura por la operación.
> Nota: maximizar la concurrencia; suponga que hay una función `Cobrar()` llamada por el empleado que simula que el empleado le cobra al cliente.

### A - Implemente una solución para el problema descrito.
```c
chan p_maquina[N](int pos);
chan p_tikect[N](ticket t);
chan cobrar(int id, int pos), fila(int id), message();

process Cliente[i := 0 to N]{
    send message();
    send fila(i);
    int pos;
    recive p_maquina(pos);
    // utiliza la maquina de la pos indicada
    send message();
    send cobrar(i, pos);
    recive p_ticket(t);
}
process Empleado{
    bool maquina[10] := (10 true); int cant := 10;
    while(true){
        recive message();
        if
        [] (cant > 0) and (not empty(fila)) ->
            int id;
            recive fila(id);
            cant--;
            int pos;
            for(j := 0 to 9){
                if (maquina[j]){
                    pos := j;
                    break;
                }
            }
            maquina[pos] := false;
            send p_maquina[id](pos);
        [] (not empty(cobrar)) ->
            int pos; int id;
            recive cobrar(id, pos);
            cant++;
            maquina[pos] := true;
            send p_ticket[id](Cobrar());
        fi
    }
}
```

### B - Modifique la solución implementada para que el empleado dé prioridad a los que terminaron de usar la cabina sobre los que están esperando para usarla.
```c
chan p_maquina[N](int pos);
chan p_tikect[N](ticket t);
chan cobrar(int id, int pos), fila(int id), meesage();

process Cliente[i := 0 to N]{
    send message();
    send fila(i);
    int pos;
    recive p_maquina(pos);
    // utiliza la maquina de la pos indicada
    send message();
    send cobrar(i, pos);
    recive p_ticket(t);
}
process Empleado{
    bool maquina[10] := (10 true); int cant := 10;
    while(true){
        recive message();
        if
        [] (cant > 0) and (not empty(fila)) ->
            int id;
            recive fila(id);
            cant--;
            int pos;
            for(j := 0 to 9){
                if (maquina[j]){
                    pos := j;
                    break;
                }
            }
            maquina[pos] := false;
            send p_maquina[id](pos);
        [] (cant > 5) and (not empty(cobrar)) ->
            int pos; int id;
            recive cobrar(id, pos);
            cant++;
            maquina[pos] := true;
            send p_ticket[id](Cobrar());
        fi
    }
}
```
