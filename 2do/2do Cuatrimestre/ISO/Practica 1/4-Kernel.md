## Kernel:

### A - ¿Qué es? Indique una breve reseña histórica acerca de la evolución del Kernel de GNU/Linux.

El Kernel es el núcleo de cualquier SO, es software y desde un punto de vista abstracto se encuentra inmediatamente después del hardware.

En 1991 Linus Torvalds inicia la programación de un Kernel Linux basado en Minix (clon de Unix desarrollado por Tenembaum en 1987 con el fin de crear un S.O. de uso didáctico). El 5 de octubre de 1991, se anuncia la primera versión “oficial” de Linux (0.02).

### B - ¿Cuáles son sus funciones principales?

El Kernel controla la memoria, los dispositivos periféricos y los procesos de la CPU. Actúa como enlace entre recursos y procesos, asigna la memoria a los procesos y, si algún proceso requiere acceso a algún componente de hardware, el Kernel se lo adjudica. Además de impedir que algún proceso realice tareas maliciosas sobre la CPU.

### C1 - ¿Cuál es la versión actual?

La versión actual del Kernel de Linux es 6.2.16. 

### C2 - ¿Cómo se definía el esquema de versionado del Kernel en versiones anteriores a la 2.4? 

Antes de la versión 2.6, los números impares indicaban desarrollo, los pares producción.

### C3 - ¿Qué cambió en el versionado se impuso a partir de la versión 2.6?

2.6: Esta versión ha tenido muchas mejoras para el SO dentro de las que se destacan soporte de hilos, mejoras en la planificación y soporte de nuevo hardware.

### D - ¿Es posible tener más de un Kernel de GNU/Linux instalado en la misma máquina?

Puedes tener varios instalados en Linux y eliges uno de ellos cada vez que inicias tu máquina.

### E - ¿Dónde se encuentra ubicado dentro del File System?

El Kernel reside */boot*, pero en */usr/src/linux* se almacena el archivo del código fuente del Núcleo de Linux.

### F - ¿El Kernel de GNU/Linux es monolítico? Justifique

El Kernel de Linux es monolítico, debiado a que todas las funciones se encuentran en un solo lugar, contieniendo todo lo necesario para administrar el funcionamiento del sistema.