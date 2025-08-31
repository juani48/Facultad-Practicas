## Resolver con SENTENCIAS AWAIT (<> y <await B; S>). Un sistema operativo mantiene 5 instancias de un recurso almacenadas en una cola, cuando un proceso necesita usar una instancia del recurso la saca de la cola, la usa y cuando termina de usarla la vuelve a depositar.

```
int push := 0; int pop := 0; int size := 5;
int array[5] := ([N] 1);
process Consumirdor[i=1 to 5]{
    int elem := 0
    while(true){
        <await (size > 0) size-->
        <elem := array[pop]; pop := (pop - 1) mod 5>
        // procesar recurso
        <array[push] := elem; push := (push + 1) mod 5; size++; >
    }
}
```