## ID: Verificar CUIT
### TITULO: Como empleado de rendiciones, quiero verificar el CUIT de la persona contratada, para la aprobación de la minuta.
Reglas de Negocios: ---

## Criterios de Aceptación (Verificar CUIT)

### Escenario 1: Verificación exitosa.
- Dado: Que la conexión con los servidores de la AFIP es exitosa y que el CUIT ‘1234’ está habilitado.
- Cunado: El empleado de rendiciones ingrese el CUIT ‘1234’ y presione “Verificar CUIT”.
- Entonces: Sistema se conecta con el servidor de la AFIP y retorna éxito.

### Escenario 1: Verificación fallida por error de conexión.
- Dado: Que la conexión con los servidores de la AFIP no es exitosa y que el CUIT ‘1234’ está habilitado.
- Cunado: El empleado de rendiciones ingrese el CUIT ‘1234’ y presione “Verificar CUIT”.
- Entonces: Sistema retorna fracaso por error de conexión..

### Escenario 1: Verificación fallida por CUIT inhabilitado.
- Dado: Que la conexión con los servidores de la AFIP es exitosa y que el CUIT ‘4321’ no está habilitado.
- Cunado: El empleado de rendiciones ingrese el CUIT ‘4321’ y presione “Verificar CUIT”.
- Entonces: Sistema se conecta con el servidor de la AFIP y retorna fracaso por CUIT inhabilitado.
