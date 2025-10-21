## Se quiere modelar el funcionamiento de un banco, al cual llegan clientes que deben realizar un pago y retirar un comprobante. Existe un único empleado en el banco, el cual atiende de acuerdo con el orden de llegada.

### A - Implemente una solución donde los clientes llegan y se retiran sólo después de haber sido atendidos.
```ada
PROCEDURE Program;
    TASK Empleado IS
        ENTRY Atender(comprobante: OUT text);
    END Empleado;

    TASK TYPE Cliente;

    arrCliente: array (1 to N) of Cliente;

    TASK BODY Empleado IS;
    BEGIN
        LOOP
            ACCEPT Atender(comprobante: OUT text) DO
                comprobante := "Pago realizado";
            END ACCEPT
        END LOOP;
    END Empleado;

    TASK BODY Cliente IS;
        comprobante: text
    BEGIN
        Empleado.Atender(comprobante)
    END;
BEGIN
    null;
END Program;
```
### B - Implemente una solución donde los clientes se retiran si esperan más de 10 minutos para realizar el pago.
```ada
PROCEDURE Program;
    TASK Empleado IS
        ENTRY Atender(comprobante: OUT text);
    END Empleado;

    TASK TYPE Cliente;

    arrCliente: array (1 to N) of Cliente;

    TASK BODY Empleado IS;
    BEGIN
        LOOP
            ACCEPT Atender(comprobante: OUT text) IS
                comprobante := "Pago realizado";
            END ACCEPT
        END LOOP;
    END Empleado;

    TASK BODY Cliente IS;
        comprobante: text
    BEGIN
        SELECT 
            Empleado.Atender(comprobante)
        OR DELAY 600.0; 
            null;
        END SELECT
    END;
BEGIN
    null;
END Program;
```

### C - Implemente una solución donde los clientes se retiran si no son atendidos inmediatamente.
```ada
PROCEDURE Program;
    TASK Empleado IS
        ENTRY Atender(comprobante: OUT text);
    END Empleado;

    TASK TYPE Cliente;

    arrCliente: array (1 to N) of Cliente;

    TASK BODY Empleado IS;
    BEGIN
        LOOP
            ACCEPT Atender(comprobante: OUT text) IS
                comprobante := "Pago realizado";
            END ACCEPT
        END LOOP;
    END Empleado;

    TASK BODY Cliente IS;
        comprobante: text
    BEGIN
        SELECT 
            Empleado.Atender(comprobante)
        OR ELSE;
            null;
        END SELECT
    END;
BEGIN
    null;
END Program;
```

### D - Implemente una solución donde los clientes esperan a lo sumo 10 minutos para ser atendidos. Si pasado ese lapso no fueron atendidos, entonces solicitan atención una vez más y se retiran si no son atendidos inmediatamente.
```ada
PROCEDURE Program;
    TASK Empleado IS
        ENTRY Atender(comprobante: OUT text);
    END Empleado;

    TASK TYPE Cliente;

    arrCliente: array (1 to N) of Cliente;

    TASK BODY Empleado IS;
    BEGIN
        LOOP
            ACCEPT Atender(comprobante: OUT text) IS
                comprobante := "Pago realizado";
            END ACCEPT
        END LOOP;
    END Empleado;

    TASK BODY Cliente IS;
        comprobante: text
    BEGIN
        SELECT 
            Empleado.Atender(comprobante)
        OR DELAY 600.0;
            null;
        END SELECT

        SELECT 
            Empleado.Atender(comprobante)
        OR ELSE;
            null;
        END SELECT
    END;
BEGIN
    null;
END Program;
```