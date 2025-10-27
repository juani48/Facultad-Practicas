## En una clínica existe un médico de guardia que recibe continuamente peticiones de atención de las E enfermeras que trabajan en su piso y de las P personas que llegan a la clínica ser atendidos. 
- Cuando una persona necesita que la atiendan espera a lo sumo 5 minutos a que el médico lo haga, si pasado ese tiempo no lo hace, espera 10 minutos y vuelve a requerir la atención del médico. Si no es atendida tres veces, se enoja y se retira de la clínica. 
- Cuando una enfermera requiere la atención del médico, si este no lo atiende inmediatamente le hace una nota y se la deja en el consultorio para que esta resuelva su pedido en el momento que pueda (el pedido puede ser que el médico le firme algún papel). Cuando la petición ha sido recibida por el médico o la nota ha sido dejada en el escritorio, continúa trabajando y haciendo más peticiones. 
- El médico atiende los pedidos dándole prioridad a los enfermos que llegan para ser atendidos. Cuando atiende un pedido, recibe la solicitud y la procesa durante un cierto tiempo. Cuando está libre aprovecha a procesar las notas dejadas por las enfermeras.

```ada
PROCEDURE Program IS

    TASK Medico IS
        ENTRY AtenderPersona;
        ENTRY AtenderEfermera;
        ENTRY EnviarNota(nota: IN text)
    END Medico;

    TASK Buffer IS
        ENTRY DejarNota(nota: IN text);
        ENTRY MedicoList;
    END Buffer;

    TASK TYPE Enfermera;
    TASK TYPE Persona;

    arrEnfermera: array (1 to E) of Enfermera;
    arrPersona: array (1 to P) of Persona;

    TASK BODY Persona IS
    BEGIN
        SELECT
            Medico.AtenderPersona();
        OR DELAY 300.0;
            SELECT
                Medico.AtenderPersona();
            OR DELAY 600.0;
                SELECT
                    Medico.AtenderPersona();
                OR DELAY 900.0;
                    null;
                END SELECT;
            END SELECT;
        END SELECT;
    END Persona;

    TASK BODY Enfermera IS
    BEGIN
        LOOP
            SELECT
                Medico.AtenderEnfermera;
            ELSE 
                Buffer.DejarNota("Nota");
            END SELECT;
        END LOOP
    END Enfermera;

    TASK BODY Buffer IS
        buf: queue;
    BEGIN
        LOOP
            SELECT
                ACCEPT DejarNota(nota: IN text) DO
                    push(queue, nota);
                END ACCEPT;
            OR 
                WHEN NOT empty(queue) =>
                    ACCEPT MedicoList DO
                        nota: text;
                        pop(queue, nota);
                        Medico.EnviarNota(nota);
                    END ACCEPT;
            END SELECT;
        END LOOP;
    END Buffer;

    TASK BODY Medico IS
    BEGIN
        LOOP
            SELECT
                ACCEPT AtenderPersona;
            OR
                WHEN AtenderPersona`count = 0 =>
                    ACCEPT AtenderEnfermera;
            ELSE
                Buffer.MedicoListo;
                ACCEPT EnviarNota(nota: IN text);
            END SELECT;
        END LOOP;
    END Medico;

BEGIN
    null;
END Program;
```