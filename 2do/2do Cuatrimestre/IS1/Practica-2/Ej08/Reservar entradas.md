## ID: Reservar entradas
### TITULO: Como empleado, quiero realizar un reserva, para que los clientes accedan a las funciones.
Reglas de Negocios: Se reservan máximo 2 entradas.

## Criterios de Aceptación (Reservar entradas)

### Escenario 1: Reserva exitosa
- Dado: Que el cliente reserva 2 entradas y la función “ABC” tiene cupo.
- Cuando: El empleado seleccione la función “ABC”, ingrese el DNI “1234” y las 2 entradas a reservar y presione “Realizar reserva”.
- Entonces: El sistema registra la reserva e informa “Reserva exitosa”.

### Escenario 2: Reservar fallida por límite de reservas excedida.
- Dado: Que el cliente reserva 3 entradas y la función “ABC” tiene cupo.
- Cuando: El empleado seleccione la función “ABC”, ingrese el DNI del cliente “1234” y las 3 entradas a reservar y presione “Realizar reserva”.
- Entonces: El sistema informa “Reserva fallida por límite de reservas excedido”.

### Escenario 3: Reservar fallida por función llena.
- Dado: Que el cliente con DNI “1234” reserva 1 entradas pero la función “ABC” no tiene cupo.
- Cuando: El empleado seleccione la función “ABC”, ingrese el DNI del cliente “1234” y las 1 entradas a reservar y presione “Realizar reserva”.
- Entonces: El sistema informa “Reserva fallida por función llena”.

