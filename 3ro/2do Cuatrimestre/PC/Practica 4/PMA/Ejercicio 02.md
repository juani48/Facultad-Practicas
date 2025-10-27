## Se desea modelar el funcionamiento de un banco en el cual existen 5 cajas para realizar pagos. Existen P clientes que desean hacer un pago. Para esto, cada una selecciona la caja donde hay menos personas esperando; una vez seleccionada, espera a ser atendido. En cada caja, los clientes son atendidos por orden de llegada por los cajeros. Luego del pago, se les entrega un comprobante. 
> Nota: maximizar la concurrencia.

```c
chan cajero[3](int id);
chan privado[P](int pos);
chan add_fila(int: id), delete_fila(int: pos), message();

process Cliente[i := 0 to P-1]{
    int pos;
    send message();
    send add_fila(i);
    recive privado[i](pos);
    
    send cajero[pos](i);
    recive privado[i](pos); // espera a ser atendido
}
process Cajero[i := 0 to 2]{
    int id;
    while(true){
        recive cajero[i](id);
        // atiende al cliente
        send privado[id](i);
        send message();
        send delete_fila(i);
    }
}
process Fila{
    int id, pos;
    int cant[3] := (3 0);
    while(true){
        recive massage();
        if
        [] (not empty(add_fila)) ->
            recive add_fila(id);
            int min := 999, pos := 0;
            for(j := 0 to 3){
                if (cant[j] < min){
                    pos := j;
                    min := cant[j];
                }
            }
            cant[pos]++;
            privado[id](pos);
        [] (not empty(delete_fila)) ->
            recive delete_fila(pos);
            cant[pos]--;
        fi
    }
}
```