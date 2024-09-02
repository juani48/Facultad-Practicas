## FileSystem:

### A - ¿Cómo son definidos los permisos sobre archivos en un sistema GNU/Linux?

Los permisos pueden ser de 3 tipos (R: Lectura, W: Escritura, X: Ejecución) y a su vez dividirse en 3 niveles, el usuario que creo el archivo (usuario dueño, U), el grupo dueño del archivo (que puede contener varios usuarios, G), y de los demás usuarios que no pertenecen al grupo dueño (O).

### B - Investigue la funcionalidad y parámetros de los siguientes comandos relacionados con los permisos en GNU/Linux:
- chmod: El comando chmod, o modo de cambio, permite a un administrador establecer o modificar los permisos de un archivo. chmod [Mode] [File]
  - 0: Ninguno = 000
  - 1: Solo Ejecutar = 001
  - 2: Solo escribir = 010
  - 3: Escribir y ejecutar = 011
  - 4: Solo leer = 100
  - 5: Leer y ejecutar = 101
  - 6: Leer y escribir = 110
  - 7: Leer, escribir y ejecutar	= 111
- chown: Permite cambiar la propiedad de los archivos y directorios por parte del usuario y/o del grupo. Chown [Opciones] usuario[:grupo] archivo.
  - -R: De manera descendente cambia el propietario de los directorios junto con todos sus contenidos. De manera opcional también permite cambiar el grupo al cual pertenecen.
  - -v (o --verbose): Salida más descriptiva.
  - --version: Ver el número de versión del programa.
  - --dereference: Actúa sobre enlaces simbólicos en lugar de hacerlo sobre el destino.
  - -h (o --no-dereference): En el caso de enlaces simbólicos, cambia el propietario del destino en lugar del propio enlace.
  - --reference: Cambia el propietario de un archivo, tomando como referencia el propietario de otro.
- chgrp: El comando chgrp permite cambiar el grupo de usuarios de un archivo o directorio en sistemas tipo UNIX. chgrp nuevogrp archivo1 [ archivo2 archivo3...]
  - -R: De manera descendente cambia el propietario de los directorios junto con todos sus contenidos. De manera opcional también permite cambiar el grupo al cual pertenecen.
  - -v (o --verbose): Salida más descriptiva.
  - --version: Ver el número de versión del programa.
  - --dereference: Actúa sobre enlaces simbólicos en lugar de hacerlo sobre el destino.
  - -h (o --no-dereference): En el caso de enlaces simbólicos, cambia el propietario del destino en lugar del propio enlace.
  - --reference: Cambia el propietario de un archivo, tomando como referencia el propietario de otro.

### C - Al utilizar el comando chmod generalmente se utiliza una notación octal asociada para definir permisos. ¿Qué significa esto? ¿A qué hace referencia cada valor?

Cada valor octal define un permiso de como el usuario puede utilizar el archivo.
- 0: Ninguno = 000
- 1: Solo Ejecutar = 001
- 2: Solo escribir = 010
- 3: Escribir y ejecutar = 011
- 4: Solo leer = 100
- 5: Leer y ejecutar = 101
- 6: Leer y escribir = 110
- 7: Leer, escribir y ejecutar	= 111

### D - ¿Existe la posibilidad de que algún usuario del sistema pueda acceder a determinado archivo para el cual no posee permisos? Nómbrelo, y realice las pruebas correspondientes.

Existen formas de “burlar” la seguridad de los permisos, utilizando el Acceso como superusuario (root) o utilizando el comando sudo. 
Un usuario con privilegios de superusuario (root) tiene la capacidad de acceder a cualquier archivo en el sistema, independientemente de los permisos. Si un usuario consigue acceso a la cuenta root, puede acceder y modificar cualquier archivo.
Un usuario que tenga acceso al comando sudo puede ejecutar comandos con permisos de superusuario. Esto incluye acceder a archivos restringidos.

### E - Explique los conceptos de “full path name” y “relative path name”. De ejemplos claros de cada uno de ellos.

Una ruta absoluta es una ruta que especifica la ubicación completa de un archivo o directorio desde el directorio raíz del sistema de archivos. Esta ruta no depende de la ubicación actual dentro del sistema de archivos y siempre es la misma sin importar desde dónde se acceda.

Una ruta relativa es una ruta que se especifica en relación con el directorio actual de trabajo (el directorio desde el cual se está operando en ese momento). La ruta depende del contexto en el que te encuentres, es decir, la ubicación actual dentro del sistema de archivos. Dos puntos (..) representan el traslado a un directorio principal

### F - ¿Con qué comando puede determinar en qué directorio se encuentra actualmente? ¿Existe alguna forma de ingresar a su directorio personal sin necesidad de escribir todo el path completo? ¿Podría utilizar la misma idea para acceder a otros directorios? ¿Cómo? Explique con un ejemplo.

### G - Investigue la funcionalidad y parámetros de los siguientes comandos relacionados con el uso del FileSystem:

- cd
- umount
-mkdir
- du
- rmdir
- df
- mount
- ln
- ls
- pwd
- cp
- mv
