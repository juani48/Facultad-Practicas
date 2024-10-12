## ID: Confeccionar minuta
### TITULO: Como empleado de mesa de entrada, quiero confeccionar una minuta, para su posterior aprobación.
Reglas de Negocios: El monto del contrato no puede superar $25.000. La duración no puede superar los 6 meses.

## Criterios de Aceptación (Confeccionar minuta)

### Escenario 1: Confección exitosa.
- Dado: Que el monto del contrato es de $20.000 y la duración es de 5 meses.
- Cuando: El empleado de mesa de entrada ingrese el número de CUIT ‘1234’ y presione “Confeccionar minuta”.
- Entonces: El sistema asociara un número de minuta al contrato e informara “Minuta aceptada”.

### Escenario 2: Confección fallida por monto excedido.
- Dado: Que el monto del contrato es de $30.000 y la duración es de 5 meses.
- Cuando: El empleado de mesa de entrada ingrese el número de CUIT ‘1234’ y presione “Confeccionar minuta”.
- Entonces: El sistema informara “Minuta rechazada, monto máximo excedido”.

### Escenario 3: Confección fallida por duración excedida.
- Dado: Que el monto del contrato es de $20.000 y la duración es de 7 meses.
- Cuando: El empleado de mesa de entrada ingrese el número de CUIT ‘1234’ y presione “Confeccionar minuta”.
- Entonces: El sistema informara “Minuta rechazada, duración máxima excedida”.
