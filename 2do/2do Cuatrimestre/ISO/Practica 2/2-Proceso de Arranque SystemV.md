## Proceso de Arranque SystemV:

### A - Enumere los pasos del proceso de inicio de un sistema GNU/Linux, desde que se prende la PC hasta que se logra obtener el login en el sistema.

1. Se empieza a ejecutar el código del BIOS.
2. El BIOS ejecuta el POST.
3. El BIOS lee el sector de arranque (MBR).
4. Se carga el gestor de arranque (MBC).
5. El bootloader carga el Kernel y el initrd.
6. Se monta el initrd como sistema de archivos raíz y se inicializan componentes esenciales (ej.: scheduler).
7. El Kernel ejecuta el proceso init y se desmonta el initrd.
8. Se lee el /etc/inittab.
9. Se ejecutan los scripts apuntados por el runlevel 1.
10. El final del runlevel 1 le indica que vaya al runlevel por defecto.
11. Se ejecutan los scripts apuntados por el runlevel por defecto.
12. El sistema está listo para usarse.

### B1 - Proceso INIT. ¿Quién lo ejecuta?

El procesó init es ejecutado por el Kernel

### B2 - ¿Cuál es su objetivo?

Su objetivo es cargar todos los subprocesos necesarios para el correcto funcionamiento del SO.

### C1 - RunLevels. ¿Qué son?

Un RunLevel es un conjunto de links a procesos.

### C2 - ¿Cuál es su objetivo?

Con el objetivo levantar (iniciar) o bajar (parar) una serie de servicios.

### D1 - ¿A qué hace referencia cada nivel de ejecución según el estándar?

Según el estándar:
- 0: halt (parada).
- 1: single user mode (monousuario)
- 2: multiuser, without NFS (modo multiusuario sin soperte de red)
- 3: full multiuser mode console (modo multiusuario completo por consola)
- 4: no se utiliza
- 5: X11 (modo multiusuario completo con login gr´ afico basado en X)
- 6: reboot

### D2 - ¿Dónde se define qué Runlevel ejecutar al iniciar el sistema operativo?

Se define en _/etc/inittab_.

### D3 -¿Todas las distribuciones respetan estos estándares?

Todas las distribuciones que implementan el estilo de sistema de arranque de iniciación tipo UNIX System V, respetan el estándar.

### E1 - Archivo /etc/inittab. ¿Cuál es su finalidad? ¿Qué tipo de información se almacena en él?

El archivo /etc/inittab define:
- Que el proceso init se reiniciará.
- Qué procesos se deben iniciar, supervisar e reiniciar si se terminan.
- Qué acciones se deben realizar cuando el sistema ingresa a un nuevo nivel de ejecución.

### E2 -¿Cuál es la estructura de la información que en él se almacena?

La estructura de la información que almacena es *id:nivelesEjecución:acción:proceso*
- **Id**: identifica la entrada en inittab (1 a 4 caracteres).
- **NivelesEjecución**: el/los niveles de ejecución en los que se realiza la acción.
- **Acción**: describe la acción a realizar.
- **Proceso**: el proceso exacto que será ejecutado.

### F - Suponga que se encuentra en el runlevel <X>. Indique qué comando(s) ejecutaría para cambiar al runlevel <Y>. ¿Este cambio es permanente? ¿Por qué?

Con el comando _init Y_ se cambia del runlevel <X> al <Y>.

El cambio de runlevel en un sistema Linux no es necesariamente permanente. El runlevel se puede cambiar de manera temporal para la sesión actual o de manera permanente para que el sistema arranque en ese runlevel específico en cada inicio.

### G1 - Scripts RC. ¿Cuál es su finalidad?

Estos scripts tienen la finalidad de configurar el entorno del sistema, inicializar servicios y realizar tareas necesarias para que el sistema esté en un estado funcional después de arrancar.

### G2 - ¿Dónde se almacenan?

La ubicación típica de estos scripts es en _/etc/rc.d_ o _/etc/init.d_.

### G3 - Cuando un sistema GNU/Linux arranca o se detiene se ejecutan scripts, indique cómo determina qué script ejecutar ante cada acción. ¿Existe un orden para llamarlos? Justifique.

Los scripts RC en los directorios /etc/rc.d o /etc/init.d suelen tener nombres que siguen una convención como SXXnombre o KXXnombre, donde:
- S indica que el script inicia el servicio.
- K indica que el script detiene el servicio.
XX es un número que determina el orden de ejecución. Cuanto más bajo sea el número, antes se ejecutará el script.

Durante el arranque, los scripts de inicio del sistema se ejecutan en el siguiente orden:
- Se ejecutan los scripts que comienzan con S y tienen los números más bajos primero. Estos scripts inician los servicios necesarios en el orden especificado por los números.
- Luego, se ejecutan los scripts que comienzan con K y tienen números más altos. Estos scripts se utilizan para detener servicios o realizar tareas de limpieza al detener el sistema.
- Este proceso asegura que los servicios se inicien en un orden controlado y que, al apagar el sistema, se detengan en el orden adecuado para evitar conflictos o problemas de dependencia.

