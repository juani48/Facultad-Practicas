## Crea un usuario para las bases de datos usando el nombre ‘appointments_user’. Asigne a estos todos los permisos sobre sus respectivas tablas. Habiendo creado este usuario evitaremos el uso de ‘root’ para el resto del trabajo práctico. 

```bash
mysql -h localhost -u root -p
```
```sql
create user 'appointments_user'@'localhost' identified with caching_sha2_password by 'bbdd1';
grant all on appointments.* to 'appointments_user'@'localhost';
flush privileges;
```

## Adicionalmente, con respecto a esta base de datos:
### A - Cree un usuario sólo con permisos para realizar consultas de selección, es decir que no puedan realizar cambios en la base. Use el nombre ‘appointments_select’.
```sql
create user '‘appointments_select’'@'localhost' identified with caching_sha2_password by 'bbdd1';
grant select on appointments.* to 'appointments_select'@'localhost';
flush privileges;
```

### B - Cree un usuario que pueda realizar consultas de selección, inserción, actualización y eliminación a nivel de filas, pero que no puedan modificar el esquema. Use el nombre ‘appointments_update’.
```sql
create user 'appointments_update'@'localhost' identified with caching_sha2_password by 'bbdd1';
grant select, insert, update, delete on appointments.* to 'appointments_update'@'localhost';
flush privileges;
```

### C - Cree un usuario que tenga los permisos de los anteriores, pero que además pueda modificar el esquema de la base de datos. Use el nombre 'appointments_schema’.
```sql
create user 'appointments_schema'@'localhost' identified with caching_sha2_password by 'bbdd1';
grant select, insert, update, delete, create, drop on appointments.* to 'appointments_update'@'localhost';
flush privileges;
```