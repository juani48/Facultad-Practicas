## ID: Comprar por web
### TITULO: Como usuario, quiero comprar las entradas por la web, para conseguir mi código de compra.
Reglas de Negocios: ---

## Criterios de Aceptación (Comprar por web)

### Escenario 1: Compra exitosa.
- Dado: Que el usuario con DNI “1234” reserva 1 entrada y la función “ABC” tiene cupo.
- Cuando: El usuario selecciones la función “ABC”, ingrese el DNI “1234” y 1 en la cantidad de lugares solicitados y presiona  “Pagar”.
- Entonces: El sistema redirige al usuario al pago con tarjeta, espera respuestas, informa “Compara exitosa” y devuelve el código de compra correspondiente.

### Escenario 2: Compra fallida por error de pago.
- Dado: Que el usuario con DNI “1234” reserva 1 entrada y la función “ABC” tiene cupo.
- Cuando: El usuario selecciones la función “ABC”, ingrese el DNI “1234” y 1 en la cantidad de lugares solicitados y presiona  “Pagar”.
- Entonces: El sistema redirige al usuario al pago con tarjeta, espera respuestas, informa “Compra fallida por error al pagar”.

### Escenario 3: Compra fallida por función llena.
- Dado: Que el usuario con DNI “1234” reserva 1 entrada y la función “ABC” no tiene cupo.
- Cuando: El usuario selecciones la función “ABC”, ingrese el DNI “1234” y 1 en la cantidad de lugares solicitados y presiona  “Pagar”.
- Entonces: El sistema informa “Compra fallida por función llena”.

