## En un sistema para acreditar carreras universitarias, hay UN Servidor que atiende pedidos de U Usuarios de a uno a la vez y de acuerdo con el orden en que se hacen los pedidos. Cada usuario trabaja en el documento a presentar, y luego lo envía al servidor; espera la respuesta de este que le indica si está todo bien o hay algún error. Mientras haya algún error, vuelve a trabajar con el documento y a enviarlo al servidor. Cuando el servidor le responde que está todo bien, el usuario se retira. Cuando un usuario envía un pedido espera a lo sumo 2 minutos a que sea recibido por el servidor, pasado ese tiempo espera un minuto y vuelve a intentarlo (usando el mismo documento).

```ada
PROCEDURE Program IS

    TASK Servidor IS
        ENTRY RecibirDoc(doc: IN text; err: OUT bool);
    END Servidor

    TASK TYPE Usuario;

    arrUsuario: array (1 to U) from Usuario;

    TASK BODY Usuario IS
        err: bool = true;
        doc: text = "doc";
    BEGIN
        WHILE err LOOP
            --Tabaja en el doc
            SELECT
                Servidor.RecibirDoc(doc, err);
            OR DELAY 2; -- 2 minutos
                DELAY 1; -- 1 minuto
                Servidor.RecibirDoc(doc, err);
            END SELECT;
        END LOOP;
    END Usuario;

    TASK BODY Servidor IS
    BEGIN
        LOOP
            ACCEPT RecibirDoc(doc: IN text; err: OUT bool) DO
                --valido el doc y guarda el res si esta bien o no
                err = res;
            END ACCEPT
        END LOOP
    END Servidor;

BEGIN
    null;
END Program;
```
