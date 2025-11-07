## Resolver el siguiente problema. 
### La oficina central de una empresa de venta de indumentaria debe calcular cuántas veces fue vendido cada uno de los artículos de su catálogo. La empresa se compone de 100 sucursales y cada una de ellas maneja su propia base de datos de ventas. La oficina central cuenta con una herramienta que funciona de la siguiente manera: ante la consulta realizada para un artículo determinado, la herramienta envía el identificador del artículo a las sucursales, para que cada una  calcule  cuántas  veces  fue  vendido  en  ella.  Al  final  del  procesamiento,  la  herramienta  debe conocer cuántas veces fue vendido en total, considerando todas las sucursales. Cuando ha terminado de procesar un artículo  comienza con  el siguiente (suponga que la herramienta tiene una función generarArtículo()  que  retorna el  siguiente  ID  a  consultar).  
> Nota:  maximizar  la  concurrencia.  Existe una  función  ObtenerVentas(ID)  que  retorna  la  cantidad  de  veces  que  fue  vendido  el  artículo  con identificador ID en la base de la sucursal que la llama.

```ada
PROCEDURE Program IS
    
    TASK Herramienta IS
        ENTRY Resul(ventas: IN int);
        ENTRY ProximaCategoria(id_categoria: OUT int);
    END Herramienta;

    TASK TYPE Sucursal;

    arrSucursal: array (0 to 99) of Sucursal;

    TASK BODY Herramienta IS
        id_c: int
        total: int
    BEGIN
        LOOP
            total := 0;
            id_c := obtenerArticulo();

            FOR i IN (0 to 99) LOOP
                ACCEPT ProximaCategoria(id_categoria: OUT int) IS
                    id_categoria := id_c;
                END ACCEPT;
            END LOOP;
            FOR i IN (0 to 99) LOOP
                ACCEPT Resul(ventas: IN int) IS
                    total := total + ventas;
                END ACCEPT
            END LOOP;
            print(id_c + total);
        END LOOP;
    END Herramienta;

    TASK BODY Sucursal IS
        categoria: int
        ventas: int
    BEGIN   
        LOOP
            Herramienta.ProximaSucursal(categoria);
            ventas := ObtenerVentas(categoria);
            Herramienta.Resul(ventas); 
        END LOOP;
    END Sucursal;

BEGIN
    null;
END Program;
```