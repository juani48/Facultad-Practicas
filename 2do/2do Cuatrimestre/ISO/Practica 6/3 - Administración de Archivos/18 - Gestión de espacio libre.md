## Gestión de espacio libre. Dados los siguientes métodos de gestión de espacio libre en un disco: Tabla de bits, lista ligada, agrupamiento y recuento.

### A - Describa como trabajan estos métodos.
### B - Cite ventajas y desventajas de cada uno.

- **Tabla de bits:** Tabla (vector) con 1 bit por cada bloque de disco (0 = bloque libre y 1 = bloque ocupado). 
  - Ventajas:
    - Requiere poco espacio para almacenar información (un bit por bloque).
    - Eficiente para encontrar bloques contiguos libres, ya que se pueden escanear rápidamente.
  - Desventajas:
    - Requiere cálculos adicionales para localizar el bloque específico en el disco (traducción de bit a bloque).
    - Puede ser lenta si el disco es grande, debido a la búsqueda en la tabla.
- **Lista Ligada:** Se tiene un puntero al primer bloque libre. Cada bloque libre tiene un puntero al siguiente bloque libre. 
  - Ventajas:
    - No necesita espacio adicional.
    - Acceso directo al primer bloque libre, útil para asignaciones rápidas.
  - Desventajas:
    - Ineficiente para la búsqueda de bloques libres, debido a las multiples operaciones de E/S.
    - Difícil encontrar bloques libres consecutivos. 
    - Los punteros dentro de los bloques libres consumen espacio que podría usarse para datos.
- **Agrupamiento:** Variante de “bloques libres encadenados”. El primer bloque libre contiene las direcciones de N bloques libres.  Las N-1 primeras direcciones son bloques libres. La N-ésima dirección referencia otro bloque con N direcciones de bloques libres. 
  - Ventajas:
    - Reduce el número de accesos al disco necesarios para encontrar múltiples bloques libres (mejora delista ligada).
    - Más eficiente para discos grandes comparado con la lista ligada.
  - Desventajas:
    - Aún requiere espacio dentro de los bloques libres para los punteros.
    - La estructura puede ser más compleja de manejar.
- **Recuento:** En lugar de listar cada bloque libre individualmente, se almacenan solo los bloques iniciales de cada grupo contiguo de bloques libres junto con un contador que indica cuántos bloques están en el grupo.
  - Ventajas:
    - Requiere muy poco espacio para almacenar información sobre bloques libres.
    - Muy eficiente para discos con grandes áreas de bloques contiguos libres.
  - Desventajas:
    - No es adecuado para discos fragmentados, donde los bloques libres están dispersos.
    - Acceso aleatorio a bloques libres puede ser menos eficiente.