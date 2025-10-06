## Resolver el siguiente problema. 
### En una empresa trabajan 20 vendedores ambulantes que forman 5 equipos de 4 personas cada uno (cada vendedor conoce previamente a qué equipo pertenece). Cada equipo se encarga de vender un producto diferente. Las personas de un equipo se deben juntar antes de comenzar a trabajar. Luego cada integrante del equipo trabaja independientemente del resto vendiendo ejemplares del producto correspondiente. Al terminar cada integrante del grupo debe conocer la cantidad de ejemplares vendidos por el grupo. 
> Nota: maximizar la concurrencia.

```c
monitor Equipo{
    cond equipo[5]
    int cant_equipo[5] := (5 0);
    int res_equipo[5] := (5 0);

    procedure IniciarVenta(int: id_equipo){
        if (cant_equipo[id_equipo] < 4){

            cant_equipo[id_equipo]++;
            wait(equipo[id_equipo]);
        }
        else {
            cant_equipo[id_equipo] := 0;
            signal_all(equipo[id_equipo]);
        }
    }

    procedure TerminarVenta(int: id_equipo, int: total){
        res_equipo[id_equipo] += total;
        if (cant_equipo[id_equipo] < 4){

            cant_equipo[id_equipo]++;
            wait(equipo[id_equipo]);
        }
        else {

            signal_all(equipo[id_equipo]);
        }
        // cada vendedor conoce la cantidad todal vendida por el equipo en este punto
        int total_equipo := res_equipo[id_equipo];  
    }
}
process Vendedor[i := 0 to 20-1]{
    int equipo; // Cada vendedor conoce su equipo
    Equipo.IniciarVenta(equipo);
    int total := Vender(); // El vendedor va a vender y me rotarna el total que vendio
    Equipo.TerminarVenta(equipo, total);
}
```
