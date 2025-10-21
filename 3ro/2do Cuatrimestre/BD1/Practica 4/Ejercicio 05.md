## Escribe y ejecute la sentencia correspondiente para crear la siguiente tabla:
APPOINTMENTS_PER_PATIENT
- idApP: int(11) PK AI
- id_patient: int(11) 
- count_appointments: int(11) 
- last_update: datetime 
- user: varchar(16)

```bash
mysql -h localhost -u appointments_user -p
```
```sql
use appointments;
CREATE TABLE appointments.appointments_per_patient (
    idApP integer(11) primary key auto_increment, 
    id_patient integer(11), 
    count_appointments integer(11), 
    last_update datetime, 
    user varchar(20) 
);
```

