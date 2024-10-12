## ID: Retirar entradas con código
### TITULO: Como vendedor, quiero retirar entradas con código, para otorgárselas al cliente.
Reglas de Negocios: ---

## Criterios de Aceptación (Retirar entradas con código)

### Escenario 1: Retiro exitoso
- Dado: Que el código “1234” representa un compra de entradas.
- Cuando: El empleado ingrese el código “1234” y presione “Retirar entradas”.
- Entonces: El sistema redirige al empleado al pago con tarjeta, espera respuestas, informa “Retiro exitoso” e imprime las entradas.

### Escenario 2: Retiro fallido por código inexistente
- Dado: Que el código “4321” no representa un compra de entradas.
- Cuando: El empleado ingrese el código “4321” y presione “Retirar entradas”.
- Entonces: El sistema informa “Fallo al retirar entradas código inexistente”.

### Escenario 3: Retiro fallido por error de pago
- Dado: Que el código “1234” representa un compra de entradas.
- Cuando: El empleado ingrese el código “1234” y presione “Retirar entradas”.
- Entonces: El sistema redirige al empleado al pago con tarjeta, espera respuestas, informa “Fallo al retirar entradas por error de pago”.

