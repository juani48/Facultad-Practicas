## ID: Realizar Reserva. 
### TITULO: Como cliente, quiero reservar muebles, para eventos personales.
Reglas de Negocios: La reserva tiene que incluir como mínimo 3 muebles.

## Criterios de Aceptación (Realizar Reserva)
{
### Escenario 1: Reserva Exitoso.
Dado: Que el cliente selecciono 4 muebles.
Cuando: El cliente realice la reserva de 4 muebles y presione “Reservar”.
Entonces: El sistema redirige al cliente al abono del alquiler, espera respuesta, registra la reserva y devolver un numero de reserva único.

### Escenario 2: Reserva fallida por incumplimiento del mínimo de mobiliaria
Dado: Que el cliente selecciono 2 muebles.
Cuando: El cliente realice la reserva de 2 muebles y presione “Reservar”.
Entonces: El sistema informara “Falla en la reserva de muebles, no se cumple con el mínimo de 3 muebles”.
}