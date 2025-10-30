## Se debe calcular el valor promedio de un vector de 1 millón de números enteros que se encuentra distribuido entre 10 procesos Worker (es decir, cada Worker tiene un vector de 100 mil números). Para ello, existe un Coordinador que determina el momento en que se debe realizar el cálculo de este promedio y que, además, se queda con el resultado.
> Nota: Maximizar la concurrencia; este cálculo se hace una sola vez.

```ada
PROCEDURE Program IS

    TASK TYPE Worker IS
        ENTRY Init();
    END Worker;

    TASK Master IS
        ENTRY Resul(total: IN double);
    END Master;

    arrWorker: array (1 to 10) of Worker;

    TASK BODY Worker IS
        arr: array (1 to 100_000) of int;
        total: double = 0.0;
    BEGIN
        ACCPET Init();
        FOR i IN (1 to 100_000) LOOP
            total = total + arr[i];
        END LOOP;
        total = total / 100_000;
        Master.Resul(total);
    END Worker;

    TASK BODY Master IS
        resul: double = 0.0;
        total: double = 0.0;
    BEGIN
        FOR i IN (1 to 10) LOOP
            arrWorker[i].Init();
        END LOOP;
        FOR i IN (1 to 10) LOOP
            ACCEPT Resul(total: IN double);
            resul = resul + total;
        END LOOP;
        resul = resul / 10;
    END;

BEGIN
    null;
END Program;
```