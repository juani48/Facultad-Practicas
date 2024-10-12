## ID: Retirar entradas reservadas
### TITULO: Como empleado, quiero retirar entradas, para otorgárselas al cliente.
Reglas de Negocios: Las entradas no deben estas caducadas.

## Criterios de Aceptación (Retirar entradas reservadas)

### Escenario 1: Retiro exitoso
- Dado: Que el cliente con nombre “ABC” y DNI “1234” posee entradas reservadas y estas no se encuentran caducadas.
- Cuando: El empleado ingrese el nombre “ABC” y el DNI “1234” y presione “Retirar entradas”.
- Entonces: El sistema redirige al empleado al pago con tarjeta, espera respuestas, informa “Retiro exitoso” e imprime las entradas.

### Escenario 2: Retiro fallido por reserva no existente
- Dado: Que el cliente con nombre “ABC” y DNI “1234” no posee entradas reservadas.
- Cuando: El empleado ingrese el nombre “ABC” y el DNI “1234” y presione “Retirar entradas”.
- Entonces: El sistema informa “Fallo al retirar entradas por reserva inexistente por parte del cliente”.

### Escenario 3: Retiro fallido por reserva caducada
- Dado: Que el cliente con nombre “ABC” y DNI “1234” posee entradas reservadas y estas se encuentran caducadas.
- Cuando: El empleado ingrese el nombre “ABC” y el DNI “1234” y presione “Retirar entradas”.
- Entonces: El sistema informa “Fallo al retirar entradas por reserva caducada”.

### Escenario 4: Retiro fallido por error de pago
- Dado: Que el cliente con nombre “ABC” y DNI “1234” posee entradas reservadas y estas no se encuentran caducadas.
- Cuando: El empleado ingrese el nombre “ABC” y el DNI “1234” y presione “Retirar entradas”.
- Entonces: El sistema redirige al empleado al pago con tarjeta, espera respuestas, informa “Fallo al retirar entradas por error de pago”.

