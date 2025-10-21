## Crear una vista llamada ‘doctors_per_patients’ que muestre los id de los pacientes y los id de doctores de la ciudad donde vive el paciente.

```bash
mysql -h localhost -u appointments_user -p
```
```sql 
use appointments;
CREATE VIEW appointments.doctors_per_patients AS (SELECT P.patient_id, D.doctor_id, P.patient_city FROM patient AS P INNER JOIN doctor AS D ON (P.patient_city = D.doctor_city));
```