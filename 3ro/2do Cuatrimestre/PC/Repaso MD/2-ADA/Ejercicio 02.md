## Resolver el siguiente problema. 
### En un negocio de cobros digitales hay P personas que deben pasar por la única caja de cobros para realizar el pago de sus boletas. Las personas son atendidas de acuerdo con el orden de llegada, teniendo prioridad aquellos que deben pagar menos de 5 boletas de los que pagan más. Adicionalmente, las personas ancianas tienen prioridad sobre los dos casos anteriores. Las personas entregan sus boletas al cajero y el dinero de pago; el cajero les devuelve el vuelto y los recibos de pago

```ada
PROCEDURE Program IS
    
    TASK TYPE Persona IS
        ENTRY Init(pos: IN int);
        ENTRY Privado();
    END Persona;

    arrPersona: array (0 to P-1) of Persona;

    TASK Buffer IS
        ENTRY Encolar(id: IN int, boletas: IN int, anciano: IN bool);
        ENTRY Atender(id: OUT int);
    ENN Buffer;

    TASK Cajero IS
        ENTRY Atender(boletas: IN boleta, pago: IN double, vuelto: OUT double, recibo: OUT str);
    END Cajero; 

    TASK BODY Persona IS
        boletas: boleta; cant: int; anciano: bool;
        id: int;
        vuelto: double; recibos: str;
        pago: double;
    BEGIN
        -- una persona conoce de antemano sus boletas, la cant de estas, si es anciano o no y el valor de pago de sus boletas

        ACCEPT Init(pos: IN int) IS id := pos; END ACCEPT;

        Buffer.Encolar(id, cant, anciano);

        ACCETP Privado();
        
        Cajero.Atender(boletas, pago, vuelto, recibo);
    END Persona;

    TASK Buffer IS
        menos_boleta, cola_anciano, normal: cola;
        cantidad: int = 0;
    BEGIN
        SELECT
            ACCEPT Encolar(id: IN int, cant: IN int, anciano: IN bool) IS
                cantidad := cantidad + 1;
                if (anciano) {
                    cola_anciano.push(id);
                } else if (cant < 5) {
                    menos_boleta.push(id);
                } else {
                    normal.push(id);
                }
            END ACCEPT;
        OR 
            WHEN (cantidad > 0) => ACCEPT Atender(id: OUT int) IS
                cantidad := cantidad - 1;
                if (!anciano.empty()) {
                    id := anciano.pop();
                } else if (!menos_boleta.empty()) {
                    id := menos_boleta.pop();
                } else {
                    id := normal.pop();
                }
            END ACCEPT; 
    END Buffer

    TASK BODY Cajero IS
        id: int;
    BEGIN
        LOOP
            Buffer.Atender(id);
            arrPersona[id].Privado();
            ACCEPT Atender(boletas: IN boleta, pago: IN double, vuelto: OUT double, recibo: OUT str) IS
                -- procesa las boletas y genera el vuelto y el recibo
                recibo := recibo;
                vuelto := vuelto;
            END ACCEPT;
        END LOOP;
    END Cajero;

BEGIN
    FOR i IN (0 to P-1) LOOP
        arrPersona[i].Init(i);
    END LOOP
END Program;

```