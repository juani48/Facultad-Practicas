## Se dispone de un sistema compuesto por 1 central y 2 procesos periféricos , que se comunican continuamente. Se requiere modelar su funcionamiento considerando las siguientes condiciones:
- La central siempre comienza su ejecución tomando una señal del proceso 1; luego toma aleatoriamente señales de cualquiera de los dos indefinidamente. Al recibir una señal de proceso 2, recibe señales del mismo proceso durante 3 minutos.
- Los procesos periféricos envían señales continuamente a la central. La señal del proceso 1 será considerada vieja (se deshecha) si en 2 minutos no fue recibida. Si la señal del proceso 2 no puede ser recibida inmediatamente, entonces espera 1 minuto y vuelve a mandarla (no se deshecha).
```ada
PROCEDURE Program;
    TASK Central IS
        ENTRY Proceso1;
        ENTRY Proceso2;
    END Central;

    TASK Periferico1;
    TASK Periferico2

    TASK BODY Central
        block: bool = false;
    BEGIN
        ACCEPT Proceso1;
        LOOP
            SELECT 
                OR WHEN (!block) => 
                    ACCEPT Proceso1
                OR 
                    ACCEPT Proceso2 IS
                        block = true;
                    END ACCEPT;
                        SELECT 
                            OR
                                ACCEPT Proceso2
                            OR DELAY 3;
                                block = false;
                        END SELECT;
            END SELECT;
        END LOOP;
    END Central;

    TASK BODY Proceso1
    BEGIN
        LOOP
            SELECT 
                Central.Proceso1;
            OR DELAY 2;
                null;
            END SELECT
        END LOOP;
    END Proceso1;

    TASK BODY Proceso2
    BEGIN
        LOOP
            SELECT 
                Central.Proceso2;
            ELSE
                DELAY 1;
                Central.Proceso2;
            END SELECT
        END LOOP;
    END Proceso2;

BEGIN
    null;
END Program;
```