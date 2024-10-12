## ID: Listar funciones.
### TITULO: Como usuario, quiero ver las funciones disponibles, para seleccionar una.
Reglas de Negocios: ---

## Criterios de Aceptación (Listar funciones)

### Escenario 1: Listado exitoso.
- Dado: Que existen funciones para seleccionar.
- Cuando: El usuario sea redirigido a la lista de funciones.
- Entonces: El sistema listara las funciones disponibles.

### Escenario 2: Listado fallido por falta de funciones.
- Dado: Que no existen funciones para seleccionar.
- Cuando: El usuario sea redirigido a la lista de funciones.
- Entonces: El sistema no listara las funciones e informara “No hay funciones disponibles”.

