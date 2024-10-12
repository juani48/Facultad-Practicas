## ID: Pagar con Tarjeta.
### TITUTLO: Como alumno, quiero pagar la inscripción, para tener mis comprobantes de inscripción y pago.
Reglas de Negocios: Solo se aceptan números de tarjetas de crédito. La tarjeta debe tener fondos.

## Criterios de Aceptación (Pagar con Tarjeta)

### Escenario 1: Pago exitoso.
- Dado: Que la conexión con el servidor del banco es exitosa, que le numero ‘1234’ corresponde a una tarjeta de crédito y la tarjeta tiene saldo.
- Cuando: El alumno ingrese el código de tarjeta ‘1234’ y presione “Pagar inscripción”.
- Entonces: El sistema registra el pago y retorna un resultado exitoso.

### Escenario 2: Pago fallido por código de tarjeta inexistente.
- Dado: Que la conexión con el servidor del banco es exitosa, que le numero ‘4321’ no corresponde a una tarjeta de crédito y la tarjeta tiene saldo.
- Cuando: El alumno ingrese el código de tarjeta ‘4321’ y presione “Pagar inscripción”.
- Entonces: El sistema retorna error por número de tarjeta inexistente.

### Escenario 3: Pago fallido por saldo insuficiente.
- Dado: Que la conexión con el servidor del banco es exitosa, que le numero ‘1234’ corresponde a una tarjeta de crédito y la tarjeta no tiene saldo.
- Cuando: El alumno ingrese el código de tarjeta ‘1234’ y presione “Pagar inscripción”.
- Entonces: El sistema retorna error por saldo insuficiente.

### Escenario 4: Pago fallido por error de conexión.
- Dado: Que la conexión con el servidor del banco no es exitosa.
- Cuando: El alumno ingrese el código de tarjeta ‘1234’ y presione “Pagar inscripción”.
- Entonces: El sistema retorna error por conexión fallida.