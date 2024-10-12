## ID: Aprobar minuta
### TITULO: Como empleado de rendiciones, quiero aprobar un minuta, para su posterior impresión.
Reglas de Negocios: La persona no puede tener más de 3 minutas vigentes.

## Criterios de Aceptación (Aprobar minuta)

### Escenario 1: Aprobación exitosa.
- Dado: Que el número de minuta ‘1234’ está asociado a “Juan”, que tiene 1 sola minuta vigente.
- Cuando: El empleado de rendiciones ingrese el número de minuta ‘1234’ y presione “Inspeccionar minuta”.
- Entonces: El sistema redirige al empleado a la verificación de CUIT, espera respuesta e imprime la minuta”.

### Escenario 2: Aprobación fallida por límite de minutas vigentes
- Dado: Que el número de minuta ‘4321’ esa asociado a “Ignacio”, que tiene 3 minutas vigentes.
- Cuando: El empleado de rendiciones ingrese el número de minuta ‘4321’ y presione “Inspeccionar minuta”.
- Entonces: El sistema informara “Minuta negada, minutas vigentes máximas excedida”.

### Escenario 3: Aprobación fallida por error de verificación. 
- Dado: Que el número de minuta ‘1234’ esa asociado a “Juan”, que tiene 1 sola minuta vigente.
- Cuando: El empleado de rendiciones ingrese el número de minuta ‘1234’ y presione “Inspeccionar minuta”.
- Entonces: El sistema redirige al empleado a la verificación de CUIT, espera respuesta e informa “Minuta negada, por error de verificación”.
