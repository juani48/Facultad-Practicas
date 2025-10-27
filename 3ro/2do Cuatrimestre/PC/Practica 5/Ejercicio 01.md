## Se requiere modelar un puente de un único sentido que soporta hasta 5 unidades de peso. El peso de los vehículos depende del tipo: cada auto pesa 1 unidad, cada camioneta pesa 2 unidades y cada camión 3 unidades. Suponga que hay una cantidad innumerable de vehículos (A autos, B camionetas y C camiones). Analice el problema y defina qué tareas, recursos y sincronizaciones serán necesarios/convenientes para resolverlo.

### A - Realice la solución suponiendo que todos los vehículos tienen la misma prioridad.
```ada
PROCEDURE Porgram IS
    
    TASK Puente IS
        ENTRY EntrarAuto
        ENTRY EntrarCamionete
        ENTRY EntrarCamion
        ENTRY Salir(peso: IN int)
    END Puente
    TASK BODY Puente IS
        max: int = 0;
    BEGIN
        LOOP
            SELECT
                WHEN (max + 1 <= 5) => 
                    ACCEPT EntrarAuto IS
                        max += 1;
                    END ACCEPT;
                OR WHEN (max + 2 <= 5) => 
                    ACCEPT EntrarCamioneta IS
                        max += 2;
                    END ACCEPT;
                OR WHEN (max + 3 <= 5) => 
                    ACCEPT EntrarCamion IS
                        max += 3;
                    END ACCEPT;
                OR 
                    ACCEPT Salir(peso: IN int) IS
                        max -= peso;
                    END ACCEPT;
        END LOOP
    END Puente;

    TASK TYPE Auto;
    TASK TYPE Camioneta;
    TASK TYPE Camion;

    arrAuto: array (1 to N) of Auto;
    arrCamioneta: array (1 to N) of Camioneta;
    arrCamion: array (1 to N) of Camion;

    TASK BODY Auto;
    BEGIN
        Puente.EntrarAuto;
        // Pasar por el puente;
        Puente.Salir(1);
    END

    TASK BODY Camioneta;
    BEGIN
        Puente.EntrarCamioneta;
        // Pasar por el puente;
        Puente.Salir(2);
    END

    TASK BODY Camion;
    BEGIN
        Puente.EntrarCamion;
        // Pasar por el puente;
        Puente.Salir(3);
    END

BEGIN
    null;
END Program;
```

### B - Modifique la solución para que tengan mayor prioridad los camiones que el resto de los vehículos.
```ada
PROCEDURE Porgram is
    
    TASK Puente IS
        ENTRY EntrarAuto
        ENTRY EntrarCamionete
        ENTRY EntrarCamion
        ENTRY Salir(peso: IN int)
    END Puente
    TASK BODY Puente IS
        max: int = 0;
    BEGIN
        LOOP
            SELECT
                WHEN (max + 1 <= 5 and EntrarCamion.count == 0) => 
                    ACCEPT EntrarAuto IS;
                        max += 1; 
                    END ACCEPT;
                OR WHEN (max + 2 <= 5 and EntrarCamion.count == 0) => 
                    ACCEPT EntrarCamioneta IS
                        max += 2; 
                    END ACCEPT;
                OR WHEN (max + 3 <= 5) => 
                    ACCEPT EntrarCamion IS
                        max += 3; 
                    END ACCEPT;
                OR 
                    ACCEPT Salir(peso: IN int) IS
                        max -= peso; 
                    END ACCEPT;
        END LOOP
    END Puente;

    TASK TYPE Auto;
    TASK TYPE Camioneta;
    TASK TYPE Camion;

    arrAuto: array (1 to N) of Auto;
    arrCamioneta: array (1 to N) of Camioneta;
    arrCamion: array (1 to N) of Camion;

    TASK BODY Auto;
    BEGIN
        Puente.EntrarAuto;
        // Pasar por el puente;
        Puente.Salir(1);
    END

    TASK BODY Camioneta;
    BEGIN
        Puente.EntrarCamioneta;
        // Pasar por el puente;
        Puente.Salir(2);
    END

    TASK BODY Camion;
    BEGIN
        Puente.EntrarCamion;
        // Pasar por el puente;
        Puente.Salir(3);
    END

BEGIN
    null;
END Program;
```