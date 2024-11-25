##  Dados los siguientes métodos de administración de espació de un archivo: Asignación contigua, asignación enlazada, asignación indexada.

### A - Describa como trabaja cada uno.
### B - Cite ventajas y desventajas de cada uno

- **Asignación contigua:** Conjunto continuo de bloques (sector o cluster) que son utilizados para almacenar el archivo de forma contigua.
  - Ventajas:
    - La File Allocation Table (FAT) es simple: Sólo una entrada que incluye Bloque de inicio y longitud. 
    - El archivo puede ser leído con una única operación. 
  - Desventajas: 
    - Se requiere una pre-asignación. 
    - Se debe conocer el tamaño del archivo durante su creación. 
    - Puede existir fragmentación externa.
    - Problemas para encontrar bloques libres continuos en el disco.
    - Problemas al incrementar el tamaño de un archivo. 
- **Asignación enlazada:** Asignación en base a bloques individuales. Cada bloque tiene un puntero al próximo bloque del archivo, formando una lista enlazada. El último bloque contiene un indicador especial (como un valor nulo) que señala el fin del archivo.
  - Ventajas:
    - La File Allocation Table (FAT) es simple: Única entrada por archivo que almacena el bloque de inicio y tamaño del archivo. 
    - No hay fragmentación externa.
    - Útil para acceso secuencial.
    - Los archivos pueden crecer bajo demanda.
  - Desventajas: 
    - No existe el acceso aleatorio.
    - Cada bloque requiere espacio para almacenar el puntero al siguiente bloque.
    - La distribución de los bloques no contiguos puede dificultar el uso óptimo del disco.
- **Asignación indexada:** Se crea un bloque de índice especial que contiene los punteros a todos los bloques de datos del archivo. La FAT contiene un puntero al bloque índice. 
  - Ventajas:
    - No se produce Fragmentación Externa.
    - El acceso aleatorio a un archivo es eficiente. 
    - Es más fácil manejar archivos grandes
  - Desventajas: 
    - El bloque de índice consume espacio adicional, porque no contiene datos propios del archivo.
    - El acceso secuencia es ineficiente.
    - La cantidad de bloques que un archivo puede usar depende del tamaño del bloque de índice.