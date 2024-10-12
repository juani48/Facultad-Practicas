## ID: Cargar Mobiliaria.
### TITULO: Como encargado de mobiliario, quiero ingresar mobiliaria, para que sea alquilada.
Regalas de Negocios: No pueden existir códigos de mobiliario repetido. El precio debe cargarse en dólares.

## Criterios de Aceptación (Cargar Mobiliario)

### Escenario 1: Carga exitosa.
- Dado: Que el código 1234 no se encuentra cargado.
- Cuando: El encargado de mobiliario ingrese los datos del mobiliario con el código 1234 y presione “Cargar”.
- Entonces: El sistema informara “Carga exitosa del mueble”.

### Escenario 2: Carga fallida por códigos duplicados.
- Dado: Que el código 1234 ya se encuentra cargado.
- Cuando: El encargado de mobiliario ingrese los datos del mobiliario con el código 1234 y presione “Cargar”.
- Entonces: El sistema informara “Falla en la carga, códigos de mobiliario duplicados”.
