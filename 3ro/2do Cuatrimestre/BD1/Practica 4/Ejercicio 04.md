## Utiliza la vista generada en el ejercicio anterior para resolver las siguientes consultas:

```bash
mysql -h localhost -u appointments_select -p
```
```sql
use appointments;
```

### A - Obtener la cantidad de doctores por cada paciente que tiene disponible en su ciudad
```sql
SELECT patient_id, count(doctor_id) AS doctor_count, patient_city 
FROM doctors_per_patients 
GROUP BY patient_id, patient_city;
```

### B - Obtener los nombres de los pacientes sin doctores en su ciudad
```sql
SELECT P.patient_name 
FROM patient as P 
WHERE P.patient_id NOT IN (
    SELECT patient_id 
    FROM doctors_per_patients
);
```

### C - Obtener los doctores que comparten ciudad con más de cinco pacientes.
```sql
SELECT D.doctor_name 
FROM doctor AS D 
WHERE D.doctor_id IN (
    SELECT doctor_id 
    FROM doctors_per_patients 
    GROUP BY doctor_id, patient_city 
    HAVING count(*) > 4
);
```