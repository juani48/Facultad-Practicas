## ID: Pagar con Tarjeta.
### TITULO: Como cliente, quiero pagar la reserva, para obtener mi número de reserva.
Reglas de Negocios: El pago de la reserva se realiza únicamente con tarjeta de crédito. Se debe abonar el 20% del total del alquiler.

## Criterios de Aceptación (Pagar con Tarjeta)

### Escenario 1: Pago exitoso.
- Dado: Que la conexión con el servidor del banco es exitosa, el número 1234 corresponde a una tarjeta de crédito y la tarjeta tiene saldo para pagar el 20% de la reserva.
- Cuando: El cliente ingrese el número de tarjeta 1234 y presione “Pagar”.
- Entonces: El sistema registra el pago y retorna un resultado exitoso.

### Escenario 2: Pago fallido por número de tarjeta de crédito inexistente.
- Dado: Que la conexión al servidor del banco en exitosa y el numero 4321 no corresponde a una tarjeta de crédito.
- Cuando: El cliente ingrese el número de tarjeta 4321 y presione “Pagar”.
- Entonces: El sistema retorna error por número de tarjeta inexistente.

### Escenario 3: Pago fallido por saldo insuficiente
- Dado: Que la conexión con el servidor del banco es exitosa, el número 1234 corresponde a una tarjeta de crédito y la tarjeta tiene saldo para pagar el 18% de la reserva.
- Cuando: El cliente ingrese el número de tarjeta 1234 y presione “Pagar”.
- Entonces: El sistema retornara error por saldo insuficiente.

### Escenario 4: Pago fallido por error de conexión
- Dado: Que la conexión al banco no fue exitosa
- Cuando: El cliente ingrese el número de tarjeta 1234 y presione “Pagar”.
- Entonces: El sistema retornara error por conexión fallida.
