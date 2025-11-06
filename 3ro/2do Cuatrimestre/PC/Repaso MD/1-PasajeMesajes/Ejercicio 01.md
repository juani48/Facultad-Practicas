## En  una  oficina  existen  100  empleados  que  envían  documentos  para  imprimir  en  5  impresoras  compartidas. Los pedidos de impresión son procesados por orden de llegada y se asignan a la primera impresora que se encuentre libre: 

### A - Implemente un programa que permita resolver el problema anterior usando PMA. 
```c
chan imprimir(doc: str, id: int);
chan documento[100](doc: str)

process Empleado[i := 0 to 99] {
    while(true){
        // crea el documento
        send enviar(doc, i);
        recive documento[i](doc);
    }
}
process Impresora[i := 0 to 4]{
    doc: str;
    id: int;
    while(true){
        recive enviar(doc, id);
        // procesa el pedido
        send documento[id](doc);
    }
}
```

### B - Resuelva el mismo problema anterior pero ahora usando PMS.
```c
process Empleado[i := 0 to 99] {
    while(true){
        // crea el documento
        Buffer!(doc, i);
        Impresora[*](doc);
    }
}
process Buffer {
    doc: str
    cola: cola
    id_e: int
    id_i
    do
    [] Empleado[*]?recive(doc, id_e) ->
        cola.push(doc, id_e); // guarda el documento y el id en la misma posicion
    [] !cola.empty(); Impresora[*]?(id_i) ->
        doc, id_e = cola.pop(); // saca de la cola el documento y el id juntos
        Impresora[id_i]!(doc, id_e);
    od
}
process Impresora[i := 0 to 4] {
    doc: str;
    id: int;
    while(true){
        Buffer!(i);
        Buffer?(doc, id);
        // procesa el pedido
        Empleado[id]!(doc);
    }
}
```