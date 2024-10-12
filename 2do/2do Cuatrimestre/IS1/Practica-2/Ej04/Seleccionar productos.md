## ID: Seleccionar productos.
### TITULO: Como usuario, quiero seleccionar los productos en venta, para consumir las bebidas.
Reglas de Negocios: Si el usuario es premiun, se realiza un 20% de descuento. Si el monto de la compra es superior a $4500, se realiza un 10% de descuento.

## Criterios de Aceptación (Seleccionar productos)

### Escenario 1: Descuento máximo.
- Dado: Que existen productos para listar y el usuario “ABC” es un usuario premiun y que el monto de la compra es de $6000.
- Cuando: El usuario “ABC” seleccione los productos y presione “Seleccionar”.
- Entonces: El sistema informara “Monto total a pagar: $4200 / 30% descuento”.

### Escenario 2: Sin descuento.
- Dado: Que existen productos para listar y el usuario “ABC” no es un usuario premiun y que el monto de la compra es de $4000.
- Cuando: El usuario “ABC” seleccione los productos y presione “Seleccionar”.
- Entonces: El sistema informara “Monto total a pagar: $4000 / Sin descuento”.

### Escenario 3: Descuento del 10%.
- Dado: Que existen productos para listar y el usuario “ABC” no es un usuario premiun y que el monto de la compra es de $6000.
- Cuando: El usuario “ABC” seleccione los productos y presione “Seleccionar”.
- Entonces: El sistema informara “Monto total a pagar: $5400 / 10% descuento”.

### Escenario 4: Descuento del 20%.
- Dado: Que existen productos para listar y el usuario “ABC” es un usuario premiun y que el monto de la compra es de $4000.
- Cuando: El usuario “ABC” seleccione los productos y presione “Seleccionar”.
- Entonces: El sistema informara “Monto total a pagar: $3200 / 20% descuento”.

### Escenario 5: Error al listar
- Dado: Que no existen productos para listar.
- Cuando: El usuario “ABC” quiera seleccionar productos.
- Entonces: El sistema informara “Error al listar, sin productos para vender”.