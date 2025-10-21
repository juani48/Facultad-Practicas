## Hallar aquellos pacientes que para todas sus consultas médicas siempre hayan dejado su número de teléfono primario (nunca el teléfono secundario).

```bash
mysql -h localhost -u appointments_select -p
```
```sql
use appointments;
select distinct p.patient_name, primary_phone from appointment as a inner join patient as p on (a.contact_phone = p.primary_phone);
```