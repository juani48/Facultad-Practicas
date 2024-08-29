## 1. Características de GNU/Linux:

### A - Mencione y explique las características más relevantes de GNU/Linux.

- Es multiusuario: Está diseñado para ejecutarse en un servidor o una red que admite varios usuarios y tareas simultáneamente.
- Es multitarea y multiprocesador:
  - Multitarea: Divide el tiempo de procesador disponible entre los procesos o subprocesos que lo necesitan.
  - Multiprocesador: Computadora que contiene dos o más unidades de procesamiento que trabajan sobre una memoria común bajo un control integrado.
-	Es altamente portable: Puede ejecutarse en cualquier ordenador sin necesidad de instalación, lo que permite llevar software en dispositivos de almacenamiento externo para resolver problemas informáticos de forma rápida.
-	Posee diversos intérpretes de comandos, de los cuales algunos son programables.
-	Todo es un archivo: La información del dispositivo de hardware, así como los ajustes de configuración propios del núcleo se almacenen en archivos especiales que residen en directorios virtuales.
-	Cada directorio puede estar en una partición diferente (/temp, /home, etc.)
-	Es case sensitive: E sensible a mayúsculas y minúsculas.
-	Es código abierto: Una vez obtenido, puede ser usado, copiado, estudiado, modificado y redistribuido libremente.

### C - ¿Qué es GNU?

GNU es un sistema operativo de tipo Unix, desarrollado por y para el Proyecto GNU y auspiciado por la Free Software Foundation. Está formado en su totalidad por software libre. GNU es el acrónimo recursivo de "GNU's Not Unix"nombre elegido debido a que GNU sigue un diseño tipo Unix y se mantiene compatible con este, pero se distingue de Unix por ser software libre y por no contener código de Unix.

### D - Indique una breve historia sobre la evolución del proyecto GNU

Iniciado por Richard Stallman en 1983 con el fin de crear un Unix libre (el sistema GNU). En 1985, Stallman crea la FSF (Free Software Foundation), con el fin de financiar el proyecto GNU. En 1990, GNU ya contaba con un editor de textos (Emacs), un compilador (GCC) y gran cantidad de bibliotecas que componen un Unix típico. Linus Torvalds ya venía trabajando desde 1991 en un Kernel denominado Linux, el cual se distribuirla bajo licencia GPL y en el año 1992, Torvalds y Stallman deciden fusionar ambos proyectos, y es allí donde nace GNU/Linux.

### E - Explique qué es la multitarea, e indique si GNU/Linux hace uso de ella.

Multitarea: Divide el tiempo de procesador disponible entre los procesos o subprocesos que lo necesitan. GNU/Linux lo posee como una de sus caracterisitcas fundamentales.

### F - ¿Qué es POSIX?

POSIX (acrónimo de Portable Operating System Interface, y X viene de UNIX) es una norma escrita por la IEEE, que define una interfaz estándar del sistema operativo y el entorno, incluyendo un intérprete de comandos (o"shell").

## 2. Distribuciones de GNU/Linux:

### A - ¿Qué es una distribución de GNU/Linux? Nombre al menos 4 distribuciones de GNU/Linux y cite diferencias básicas entre ellas.
Una distribución Linux o distribución GNU/Linux (abreviada con frecuencia distro) es un conjunto de aplicaciones reunidas que permiten brindar mejoras para instalar fácilmente un sistema operativo basado en GNU/Linux.
1.	Debian
2.	Arch
3.	Gentoo
4.	Red Hat Linux

### B - ¿En qué se diferencia una distribución de otra?

Las distribuciones difieren principalmente en su administrador de paquetes y sus opciones predeterminadas (entorno de escritorio, etc.). Además, hay claramente diferentes niveles de dificultad para utilizarlas.

### C - ¿Qué es Debian? Acceda al sitio 1 e indique cuáles son los objetivos del proyecto y una breve cronología del mismo.

El Proyecto Debian es una asociación de personas que han hecho causa común para crear un sistema operativo (SO) libre, dicho software se denomina Debian. 
Su objetivo: “Queremos crear un sistema operativo libre, disponible para todo el mundo”.

Debian comenzó en agosto de 1993 gracias a Ian Murdock, como una nueva distribución que se realizaría de forma abierta, en la línea del espíritu de Linux y GNU. Debian estaba pensado para ser creada de forma cuidadosa y concienzuda, y ser mantenida y soportada con el mismo cuidado. Comenzó como un grupo de pocos y fuertemente unidos hackers de Software Libre, y gradualmente creció hasta convertirse en una comunidad grande y bien organizada de desarrolladores y usuarios.

## 3. Estructura de GNU/Linux:

### A - Nombre cuales son los 3 componentes fundamentales de GNU/Linux.
### B - Mencione y explique la estructura básica del Sistema Operativo GNU/Linux.

Los tres elementos fundamentales son:
- El Kernel (núcleo): El Kernel de Linux se podría definir como el corazón de este sistema operativo. Es, a grandes rasgos, el encargado de que el software y el hardware de una computadora puedan trabajar juntos.
-	El Shell (intérprete de comandos): Es el programa que recibe lo que se escribe en la terminal y lo convierte en instrucciones para el sistema operativo.
-	El FileSystem (sistema de archivos): Es la forma en que dentro de un SO se organizan y se administran los archivos.

## 4. Kernel:

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

## 5. Intérprete de comandos (Shell))

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

## 6. Sistema de Archivos (File System)

### A - ¿Qué es?

Es la forma en la que el SO organiza y administra los archivos.

### B - Mencione sistemas de archivos soportados por GNU/Linux.

Linux soporta varios sistemas de archivos: ext2, ext3, ReiserFS, XFS, JFS, UFS, ISO9660, FAT, FAT32 o NTFS.

### C - ¿Es posible visualizar particiones del tipo FAT y NTFS en GNU/Linux?

Sí, es posible visualizar y acceder a particiones de tipo FAT y NTFS en un sistema GNU/Linux.

### D1 - ¿Cuál es la estructura básica de los File System en GNU/Linux? Mencione los directorios más importantes e indique qué tipo de información se encuentra en ellos. 

La estructura básica de los sistemas de archivos en GNU/Linux es:
-	*/*: Es el directorio raiz
-	*/home*: Contiene los directorios "home" de los usuarios.
-	*/var*: Información que varıa de tamaño
-	*/etc*: Almacena configuración del sistema
-	*/bin*: Almacena ejecutables o binarios.
-	*/dev*: Almacena controladores de dispositivo
-	*/usr*: Aplicaciones de usuarios
-	*/sbin*: Almacena programas esenciales del sistema
-	*/lib*: Contiene las imágenes de las librerías compartidas.
-	*/proc*: Es un "sistema de ficheros virtual"
-	*/root*: Directorio home de root
-	*/tmp*: Almacena archivos temporales.

### D2 - ¿A qué hace referencia la sigla FHS?

FHS significa Filesystem Hierarchy Standard o Jerarquía del Sistema de Archivos Estandar.

## 7. Particiones

### A - Definición. Tipos de particiones. Ventajas y Desventajas.

Es una forma de dividir lógicamente el disco físico. Los tipos son:
-	Partición primaria: División cruda del disco (puede haber 4 por disco). Se almacena información de la misma en el MBR.
-	Partición extendida: Sirve para contener unidades lógicas en su interior. Solo puede existir una partición de este tipo por disco. No se define un tipo de FS directamente sobre ella.
-	Partición lógica: Ocupa la totalidad o parte de la partición extendida y se le define un tipo de FS. Las particiones de este tipo se conectan como una lista enlazada.

*Ventajas*:
-	Una unidad bien organizada puede ahorrarte tiempo en la gestión.
-	Crea copias de seguridad fácilmente.
-	Permite aplicar Sistema de Archivos Múltiple y Estilo de Partición.
-	Facilita la instalación en múltiples sistemas operativos.
-	Colocar los archivos importantes en particiones diferentes puede reducir el riesgo de pérdida y corrupción de archivos.

*Desventajas*:
-	Error de operación de partición al tener demasiadas particiones.
-	No es necesario para gente sin experiencia.
-	Todas las particiones permanecen en un disco duro. Si tu disco está dañado, desaparecerán todos los datos que contenga.

### B - ¿Cómo se identifican las particiones en GNU/Linux? (Considere discos IDE, SCSI y SATA).

Las particiones en cada disco son representadas añadiendo un número al nombre del disco.
En la primera unidad SCSI o SATA: */dev/sda1*, */dev/sda2*, …
En la primera unidad IDE: */dev/hda1*, */dev/hda2*, …

### C - ¿Cuántas particiones son necesarias como mínimo para instalar GNU/Linux? Nómbrelas indicando tipo de partición, identificación, tipo de File System y punto de montaje.

Como mínimo es necesaria una sola partición primaria, para la raíz (/).

### E - ¿Qué tipo de software para particionar existe? Menciónelos y compare.
- Particionadores destructivos: Permiten crear y eliminar particiones.
- Particionadores no destructivos: Permiten crear, eliminar y modificar particiones, generalmente las distribuciones permiten hacerlo desde la interfaz de instalación.
