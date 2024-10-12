## ID: Registrar Sesión.
### TITULO: Como empleado administrativo o alumno, quiero registrarme en el sistema, para cargar o inscribirme a posgrados.
Reglas de negocios: El nombre de usuario es único. La contraseña debe poseer, como mínimo 6 caracteres.

## Criterios de Aceptación (Registrar Sesión).

### Escenario 1: Registro exitoso.
- Dado: Que no existe un registro del nombre del usuario ‘ABC’ y la contraseña ‘D12345’.
- Cuando: El usuario ingrese el nombre de usuario ‘ABC’ y la contraseña ‘D12345’ y presione “Registrase”.
- Entonces: El sistema registra al usuario y lo redirige al listado de posgrados.

### Escenario 2: Registro fallido por nombre de usuario duplicado.
- Dado: Que ya existe un registro del nombre de usuario ‘CBA’.
- Cuando: El usuario ingrese el nombre de usuario ‘CBA’  y la contraseña ‘D12345’ y presione “Registrar”.
- Entonces: El sistema informara “Falla al registrar al usuario, el nombre de usuario ya existe”. 

### Escenario 3: Registro fallido por contraseña incorrecta.
- Dado: Que no existe un registro del nombre del usuario ‘ABC’ y la contraseña ‘D123’ posee menos de 6 caracteres.
- Cuando: El usuario ingrese el nombre de usuario ‘ABC  y la contraseña ‘D123’ y presione “Registrar”.
- Entonces: El sistema informara “Falla al registrar al usuario, la contraseña tiene menos de 6 caracteres”. 