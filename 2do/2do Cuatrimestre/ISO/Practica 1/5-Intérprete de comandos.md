## Intérprete de comandos (Shell)

### A - ¿Qué es?

### B - ¿Cuáles son sus funciones?

El shell-también conocido como el intérprete de comandos, línea de comandos, terminal o consola- es un programa que actúa como interfaz para comunicar al usuario con el sistema operativo mediante una ventana que espera comandos textuales ingresados por el usuario en el teclado, los interpreta y los entrega al SO para su ejecución.

### C - Mencione al menos 3 intérpretes de comandos que posee GNU/Linux y compárelos entre ellos.
1.	Korn-Shell (ksh)
2.	Bourne-Shell (sh)
3.	C-Shell (csh).

### D - ¿Dónde se ubican (path) los comandos propios y externos al Shell?

Los comandos propios son reconocidos y ejecutados por el shell directamente y sin ayuda de ningún otro ejecutable. 

Los comandos externos estar en */bin*, */usr/bin*, */usr/local/bin* o cualquier otra ubicación si se la agrega a la variable PATH

### E - ¿Por qué considera que el Shell no es parte del Kernel de GNU/Linux?

Porque no parte del software creado para administrar los recursos y le hardware de la computara, sino que es una extensión que permite el diálogo del usuario con el SO y, por ende, el mismo Kernel.

### F - ¿Es posible definir un intérprete de comandos distinto para cada usuario? ¿Desde dónde se define? ¿Cualquier usuario puede realizar dicha tarea?

Si es posible definir un intérprete distinto y se puede definir al crear o modificar usuarios en el sistema, y en el archivo */etc/passwd/*