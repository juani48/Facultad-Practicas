## Se debe modelar el funcionamiento de una casa de comida rápida, en la cual trabajan 2 cocineros y 3 vendedores, y que debe atender a C clientes. El modelado debe considerar que:
- Cada cliente realiza un pedido y luego espera a que se lo entreguen.
- Los pedidos que hacen los clientes son tomados por cualquiera de los vendedores y se lo pasan a los cocineros para que realicen el plato. Cuando no hay pedidos para atender, los vendedores aprovechan para reponer un pack de bebidas de la heladera (tardan entre 1 y 3 minutos para hacer esto).
- Repetidamente cada cocinero toma un pedido pendiente dejado por los vendedores, lo cocina y se lo entrega directamente al cliente correspondiente.

> Nota: maximizar la concurrencia.

```c
chan pedido(int id, pedido p);
chan cocinero(int id, pedido p);
chan privados[C](plato p);

process Cliente[i := 0 to C]{
    pedido p; // cada cliente conoce su pedido
    plato plato;
    send pedido(i, p);
    recive privados[i](plato);
}
process Cocinero[i := 0 to 1]{
    int id; pedido p;
    while(true){
        recive cocinero(id, p);
        // cocinan el pedido y obitienen el plato
        send privados[id](plato)
    }   
}
process Vendedor[i := 0 to 2]{
    int id;
    pedido p;
    do
    [] not empty(pedido) ->
        recive pedido(id, p);
        send cocinero(id, p);
    [] empty(pedido) ->
        delay(1, 3); // El vendedor limpia de 1 a 3 minutos 
    od
}
```