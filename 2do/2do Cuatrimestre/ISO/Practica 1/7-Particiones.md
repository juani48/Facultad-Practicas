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
