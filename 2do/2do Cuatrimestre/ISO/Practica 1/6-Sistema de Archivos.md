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