## ID: Iniciar Sesión.
### TITULO: Como persona, quiero autentificarme, para poder ingresar mobiliaria.
Reglas de Negocios: ---

## Criterios de Aceptación (Iniciar Sesión)

## Escenario 1: Autentificación exitosa.
- Dado: Que existe un registro con el nombre de usuario ‘ABC’ y contraseña ‘D1234’.
- Cuando: La persona ingrese el nombre de usuario ‘ABC’ y la contraseña ‘D1234’ y presione ‘Iniciar Sesión”.
- Entonces: El sistema redirige al usuario al ingreso de mobiliaria.

### Escenario 2: Autentificación fallida por nombre de usuario erróneo.
- Dado: Que existe un registro con el nombre de usuario ‘ABC’ y contraseña ‘D1234’.
- Cuando: El usuario ingrese el nombre de usuario ‘CBA’ y la contraseña ‘D1234’ y presione ‘Iniciar Sesión”.
- Entonces: El sistema informara “Autentificación fallida, el nombre de usuario es incorrecto”.

### Escenario 3: Autentificación fallida por contraseña erróneo.
- Dado: Que existe un registro con el nombre de usuario ‘ABC’ y contraseña ‘D1234’.
- Cuando: La persona ingrese el nombre de usuario ‘ABC y la contraseña ‘4321D’y presione ‘Iniciar Sesión”.
- Entonces: El sistema informara “Autentificación fallida, el contraseña es incorrecto”.
