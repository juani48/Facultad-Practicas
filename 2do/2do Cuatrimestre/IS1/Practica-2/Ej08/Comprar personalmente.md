## ID: Comprar personalmente
### TITULO: Como vendedor, quiero realizar un compra, para que el cliente pueda ver una función.
Reglas de Negocios: ---

## Criterios de Aceptación (Comprar personalmente)

### Escenario 1: Compra exitosa.
- Dado: Que el usuario con DNI “1234” reserva 1 entrada y la función “ABC” tiene cupo.
- Cuando: El vendedor selecciones la función “ABC”, ingrese el DNI “1234” y 1 en la cantidad de lugares solicitados y presiona  “Pagar”.
- Entonces: El sistema redirige al vendedor al pago con tarjeta, espera respuestas, informa “Compara exitosa” e imprime las entradas.

### Escenario 2: Compra fallida por error de pago.
- Dado: Que el usuario con DNI “1234” reserva 1 entrada y la función “ABC” tiene cupo.
- Cuando: El vendedor selecciones la función “ABC”, ingrese el DNI “1234” y 1 en la cantidad de lugares solicitados y presiona  “Pagar”.
- Entonces: El sistema redirige al vendedor al pago con tarjeta, espera respuestas, informa “Compra fallida por error al pagar”.

### Escenario 3: Compra fallida por función llena.
- Dado: Que el usuario con DNI “1234” reserva 1 entrada y la función “ABC” no tiene cupo.
- Cuando: El vendedor selecciones la función “ABC”, ingrese el DNI “1234” y 1 en la cantidad de lugares solicitados y presiona  “Pagar”.
- Entonces: El sistema informa “Compra fallida por función llena”.

