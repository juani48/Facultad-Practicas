## ID: Cargar Posgrados.
### TITULO: Como empleado administrativo, quiero cargar los posgrados, para que los alumnos se inscriban.
Reglas de Negocios: El nombre del posgrado no puede repetirse. El posgrado no puede durar más de 5 años.

## Criterios de Aceptación (Cargar Posgrados)

### Escenario 1: Carga exitosa.
- Dado: Que el nombre del posgrado ‘ABC’ no se encuentra repetido y que su duración es de 4 años.
- Cuando: El empleado administrativo ingrese el nombre del posgrado ‘ABC’ y su duración en 4 años y presione “Cargar posgrado”.
- Entonces: El sistema informara “Carga exitosa”.

### Escenario 2: Carga fallida por nombre repetido.
- Dado: Que el nombre del posgrado ‘CBA’ se encuentra repetido y que su duración es de 4 años.
- Cuando: El empleado administrativo ingrese el nombre del posgrado ‘CBA’ y su duración en 4 años y presione “Cargar posgrado”.
- Entonces: El sistema informara “Carga  fallida, el nombre del posgrado se repite”.

### Escenario 3: Carga fallida por límite de duración excedida.
- Dado: Que el nombre del posgrado ‘ABC’ no se encuentra repetido y que su duración es de 6 años.
- Cuando: El empleado administrativo ingrese el nombre del posgrado ‘ABC’ y su duración en 6 años y presione “Cargar posgrado”.
- Entonces: El sistema informara “Carga  fallida, el posgrado excede la duración máxima”.