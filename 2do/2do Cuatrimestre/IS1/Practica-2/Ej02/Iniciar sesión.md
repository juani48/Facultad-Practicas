## ID: Iniciar Sesión.
### TITULO: Como empleado administrativo o alumno, quiero ingresar al sistema, para cargar o inscribirme a posgrados.
Reglas de Negocios: ---

## Criterios de Aceptación (Iniciar Sesión)

### Escenario 1: Autentificación exitosa.
- Dado: Que existe un registro con el nombre de usuario ‘ABC’ y la contraseña ‘D1234’.
- Cuando: El usuario ingrese el nombre de usuario ‘ABC’ y la contraseña ‘D1234’ y presione “Iniciar Sesión”.
- Entonces: El sistema redirige al usuario listado de posgrados.

### Escenario 2: Autentificación fallida por nombre de usuario erróneo.
- Dado: Que existe un registro con el nombre de usuario ‘ABC’ y la contraseña ‘D1234’.
- Cuando: El usuario ingrese el nombre de usuario ‘CBA y la contraseña ‘D1234’ y presione “Iniciar Sesión”.
- Entonces: El sistema informara “Autentificación fallida, el nombre de usuario es incorrecto”.

### Escenario 3: Autentificación fallida por contraseña errona.
- Dado: Que existe un registro con el nombre de usuario ‘ABC’ y la contraseña ‘D1234’.
- Cuando: El usuario ingrese el nombre de usuario ‘ABC’ y la contraseña ‘4321D y presione “Iniciar Sesión”.
- Entonces: El sistema informara “Autentificación fallida, la contraseña es incorrecto”.