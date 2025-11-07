## Resolver el siguiente problema. 
### La página web del Banco Central exhibe las diferentes cotizaciones del dólar oficial de 20 bancos del país, tanto para la compra como para la venta. Existe una tarea programada que se ocupa de actualizar la página en forma periódica y para ello consulta la cotización de cada uno de los 20 bancos. Cada banco dispone de una API, cuya única función es procesar las solicitudes de aplicaciones externas. La tarea programada consulta de a una API por vez, esperando a lo sumo 5 segundos por su respuesta. Si pasado ese tiempo no respondió, entonces se mostrará vacía la información de ese banco.

```ada
PROCEDURE Program IS

    TASK Tarea;

    TASK TYPE API IS
        ENTRY Consultar(valor: OUT int)
    END API;

    arrAPI: array (0 to 19) of API;

    TASK BODY Tarea IS
        valores: array (0 t 19) of int
    BEGIN
        LOOP
            DELAY X; -- el que espera para refrescar la pagina
            FOR i IN 0 to 19 LOOP
                SELECT
                    arrAPI[i].Consultar(valores[i]);
                OR Delay 5; -- esperar 5 segundos
                    null;
                END SELECT;
            END LOOP;
            Print(valores); -- funcion refresca la pagina
        END LOOP;
    END Tarea;

    TASK BODY API IS
        cotizacion: int
    BEGIN
        LOOP
            ACCEPT Consultar(valor: OUT int) IS
                -- procesa el valor de la cotizacion
                valor := cotizacion;
            END ACCEPT;
        END LOOP;
    END API;

BEGIN
    null;
END Porgram;
```