## ID: Iniciar sesión
### TITUTLO: Como usuario, quiero iniciar sesión, para poder comprar bebidas alcohólicas.
Reglas de negocios: ---

## Criterios de Aceptación (Iniciar sesión)

### Escenario 1: Autentificación exitosa.
- Dado: Que el correo “@ABC” y la contraseña “1234” corresponden un usuario registrado.
- Cuando: El usuario ingrese el correo “@ABC” y la contraseña “1234” y presione “Iniciar sesión”.
- Entonces: El sistema informara “Inicio de sesión exitoso” y redirige al usuario a la lista de bebidas.

### Escenario 2: Autentificación fallida por correo inexistente
- Dado: Que el correo “@CBA” no se encuentra cargado y la contraseña “1234” corresponde un usuario registrado.
- Cuando: El usuario ingrese el correo “@CBA” y la contraseña “1234” y presione “Iniciar sesión”.
- Entonces: El sistema informara “Inicio de fallido por correo inexistente”.

### Escenario 3: Autenticación fallida por contraseña errónea.
- Dado: Que el correo “@ABC” y la contraseña “1234” corresponden un usuario registrado.
- Cuando: El usuario ingrese el correo “@ABC” y la contraseña “4321” y presione “Iniciar sesión”.
- Entonces: El sistema informara “Inicio de fallido por contraseña errónea”.