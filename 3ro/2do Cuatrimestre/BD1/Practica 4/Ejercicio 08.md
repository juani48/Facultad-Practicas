## Crear un Trigger de modo que al insertar un dato en la tabla Appointment, se actualice la cantidad de appointments del paciente, la fecha de actualización y el usuario responsable de la misma (actualiza la tabla APPOINTMENTS PER PATIENT).

```bash
mysql -h localhost -u appointments_user -p
```
```sql
use appointments;

DELIMITER //

CREATE TRIGGER update_appointments_per_user
AFTER INSERT
ON appointment FOR EACH ROW
BEGIN
    
END //
    DECLARE patient_count INT;
    DECLARE current_user VARCHAR(50);
    
    SET current_user = SUBSTRING_INDEX(USER(), '@', 1);
    
    SELECT COUNT(*) INTO patient_count 
    FROM appointment 
    WHERE patient_id = NEW.patient_id;
    
    IF EXISTS (SELECT 1 FROM appointments_per_patient WHERE id_patient = NEW.patient_id) THEN
        UPDATE appointments_per_patient 
        SET count_appointments = patient_count,
            last_update = NOW(),
            `user` = current_user
        WHERE id_patient = NEW.patient_id;
    ELSE
        INSERT INTO appointments_per_patient (id_patient, count_appointments, last_update, `user`)
        VALUES (NEW.patient_id, patient_count, NOW(), current_user);
    END IF;
DELIMITER ;
```