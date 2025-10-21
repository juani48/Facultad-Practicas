## Crear un Stored Procedure que realice los siguientes pasos dentro de una transacción:
1. Realizar la siguiente consulta: para cada pacient (identificado por id_patient), calcule la cantidad de appointments que tiene registradas. Registrar la fecha en la que se realiza esta carga y además del usuario con el que se realiza.
2. Guardar el resultado de la consulta en un cursor.
3. Iterar el cursor e insertar los valores correspondientes en la tabla APPOINTMENTS PER PATIENT. Tenga en cuenta que last_update es la fecha en que se realiza esta carga, es decir la fecha actual, mientras que user es el usuario logueado actualmente, utilizar las correspondientes funciones para esto. 


```bash
mysql -h localhost -u appointments_user -p
```
```sql
use appointments;

DELIMITER //

CREATE PROCEDURE appointments_per_user_count()

BEGIN
    DECLARE fin INT DEFAULT 0;
    DECLARE aux_id INT(11);
    DECLARE aux_count INT(11);
    DECLARE app_per_user CURSOR FOR 
        SELECT P.patient_id, count(*) AS appointment_count  
        FROM patient AS P INNER JOIN appointment AS A ON (P.patient_id = A.patient_id)
        GROUP BY P.patient_id;
    DECLARE CONTINUE handler FOR NOT FOUND SET fin = 1;
    OPEN app_per_user;
    _loop: LOOP
        FETCH app_per_user INTO aux_id, aux_count;
        IF fin = 1 THEN 
            LEAVE _loop;
        END IF;
        INSERT INTO appointments.appointments_per_patient (id_patient, count_appointments, last_update, `user` )
        VALUES (aux_id, aux_count, NOW(), SUBSTRING_INDEX(USER(), '@', 1));
    END LOOP;
    CLOSE app_per_user;

END//

DELIMITER ;
```