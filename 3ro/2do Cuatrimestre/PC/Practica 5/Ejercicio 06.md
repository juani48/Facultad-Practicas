## En una playa hay 5 equipos de 4 personas cada uno (en total son 20 personas donde cada una conoce previamente a que equipo pertenece). Cuando las personas van llegando esperan con los de su equipo hasta que el mismo esté completo (hayan llegado los 4 integrantes), a partir de ese momento el equipo comienza a jugar. El juego consiste en que cada integrante del grupo junta 15 monedas de a una en una playa (las monedas pueden ser de 1, 2 o 5 pesos) y se suman los montos de las 60 monedas conseguidas en el grupo. Al finalizar cada persona debe conocer el grupo que más dinero junto. 
>Nota: maximizar la concurrencia. Suponga que para simular la búsqueda de una moneda por parte de una persona existe una función Moneda() que retorna el valor de la moneda encontrada.

```ada
PROCEDURE Program IS

    TASK TYPE Equipo IS
        ENTRY ID(id: IN int);
        ENTRY Completar(persona: IN int);
        ENTRY SumarMoneda(moneda: IN int);
    END Equipo;

    TASK TYPE Persona IS
        ENTRY ID(id: IN int);
        ENTRY Empezar();
        ENTRY Ganador(id: IN int);
    END Persona;

    TASK Buffer IS
        ENTRY Equipo(total: IN int, id_grupo: IN int)
    END Buffer;

    arrPersona: array (1 to 20) of Persona;
    arrEquipo: array (1 to 5) of Equipo;

    TASK BODY Persona IS
        grupo: int; --cada persona conoce su equipo
        id: int
        moneda: int = 0;
    BEGIN
        ACCPET ID(id: IN int);
        Equipo.Completar(id);
        ACCEPT Empezar();
        FOR i IN 1 to 15 LOOP
            moneda = Moneda();
            Equipo[equipo].SumarMoneda(moneda);
        END LOOP;
        ACCEPT Ganador(grupo: IN int); --cada persona conoce al ganador
    END Persona;

    TASK BODY Equipo IS
        id: int;
        equipo: array (1 to 4) of int; persona: int;
        
        moneda: int; total: int = 0;
        BEGIN
        ACCEPT ID(id: IN int);
        FOR i IN (1 to 4) LOOP
            ACCEPT Completar(persona: IN int);
            equipo[i] = persona;
        END LOOP;
        FOR i IN (1 to 4) LOOP
            Persona[equipo[i]].Empezar();
        END LOOP;
        FOR i IN (1 TO 60) LOOP
            ACCEPT SumarMoneda(moneda: IN int);
            total = total + moneda;
        END LOOP;
        Buffer.Equipo(total, id);
    END Equipo;

    TASK BODY Buffer IS
    max: int = 0;
    id_grupo_max: int;
    grupo: int; total: int;
    BEGIN
        FOR i IN (1 to 5) LOOP
            ACCEPT Equipo(total, grupo)
            IF (total > max) THEN
                max = totalM
                id_grupo_max = grupo;
            END IF;
        END LOOP;
        FOR i IN (1 to 20) LOOP
            Persona.Ganador(id_grupo_max);
        END LOOP;
    END Buffer;

BEGIN
    FOR i IN (1 to 5) LOOP
        arrEquipo[i].ID(i);
    END LOOP;
    FOR i IN (1 TO 20) LOOP
        arrPersona[i].ID(i);
    END LOOP;
END Program;
```