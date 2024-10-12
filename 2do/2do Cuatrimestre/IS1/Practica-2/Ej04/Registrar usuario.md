## ID: Registrar usuario
### TITULO: Como persona, quiero registrarme, para tener un usuario.
Reglas de Negocios: El mail debe ser único. La persona debe ser mayor de 18 años.

## Criterios de Aceptación (Registrar usuario)

### Escenario 1: Registro exitoso.
- Dado: Que el mail “@ABC” no se encuentra repetido y que la persona tiene 20 años de edad.
- Cuando: La persona ingrese el correo “@ABC” y su edad (20 años) y presione “Registrarse al sistema”.
- Entonces: El sistema registra al usuario, genera la contraseña “1234” y es enviada al correo “@ABC”, luego redirige al usuario a la página de bebidas.

### Escenario 2: Registro fallido por correo repetido.
- Dado: Que el mail “@CBA” se encuentra repetido y que la persona tiene 20 años de edad.
- Cuando: La persona ingrese el correo “@CBA” y su edad (20 años) y presione “Registrarse al sistema”.
- Entonces: El sistema informara “Registro fallido por correo repetido”.

### Escenario 3: Registro fallido por incumplimiento de edad requerida.
- Dado: Que el mail “@ABC” no se encuentra repetido y que la persona tiene 16 años de edad.
- Cuando: La persona ingrese el correo “@ABC” y su edad (16 años) y presione “Registrarse al sistema”.
- Entonces: El sistema informara “Registro fallido por incumplimiento de edad” para luego informar el texto de la ley que impide la venta de bebidas alcohólicas a menores.
