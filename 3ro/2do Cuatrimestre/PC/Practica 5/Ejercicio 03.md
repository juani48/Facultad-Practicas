## Se dispone de un sistema compuesto por 1 central y 2 procesos periféricos , que se comunican continuamente. Se requiere modelar su funcionamiento considerando las siguientes condiciones:
- La central siempre comienza su ejecución tomando una señal del proceso 1; luego toma aleatoriamente señales de cualquiera de los dos indefinidamente. Al recibir una señal de proceso 2, recibe señales del mismo proceso durante 3 minutos.
- Los procesos periféricos envían señales continuamente a la central. La señal del proceso 1 será considerada vieja (se deshecha) si en 2 minutos no fue recibida. Si la señal del proceso 2 no puede ser recibida inmediatamente, entonces espera 1 minuto y vuelve a mandarla (no se deshecha).
```ada
PROCEDURE Program IS
    TASK Central IS
        ENTRY Proceso1;
        ENTRY Proceso2;
        ENTRY StopTimer;
    END Central;

    TASK Timer IS
        ENTRY Start;
    END Timer;

    TASK Periferico1;
    TASK Periferico2;

    TASK BODY Central IS
    BEGIN
        ACCEPT Proceso1;
        LOOP
            SELECT 
                ACCEPT Proceso1;
            OR
                ACCEPT Proceso2;
                    Timer.Start();
                END ACCEPT;
                    LOOP 
                        SELECT 
                            ACCEPT Proceso2;
                        OR 
                            ACCEPT StopTimer DO
                                EXIT;
                            END ACCEPT;
                        END SELECT;
                    END LOOP;
            END SELECT;
        END LOOP;
    END Central;

    TASK BODY Timer IS
    BEGIN
        LOOP
            ACCEPT Start;
            DELAY 3; 
            Central.StopTimer;
        END LOOP;
    END;

    TASK BODY Periferico1 IS
    BEGIN
        LOOP
            SELECT 
                Central.Proceso1;
            OR DELAY 2;
                null;
            END SELECT
        END LOOP;
    END Proceso1;

    TASK BODY Periferico2 IS
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