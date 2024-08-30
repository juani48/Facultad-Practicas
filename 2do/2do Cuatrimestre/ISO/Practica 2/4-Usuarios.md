## Usuarios:

### A - ¿Qué archivos son utilizados en un sistema GNU/Linux para guardar la información de los usuarios?

Generalmente se almacena la lista de usuarios en el archivo /etc/passwd y el archivo /etc/shadow almacena las contraseñas con hash.

### B1 -¿A qué hacen referencia las siglas UID y GID?

User ID (UID) El número de ID asignado al usuario en el sistema.

Group ID (GID) El número de grupo primario del usuario en el sistema.

### B2 - ¿Pueden coexistir UIDs iguales en un sistema GNU/Linux? Justifique.

Se supone que no pueden coexistir UIDs iguales, debido a que son utilizados para identificar unívocamente a dicho usuario en el SO.

### C -¿Qué es el usuario root? ¿Puede existir más de un usuario con este perfil en GNU/Linux? ¿Cuál es la UID del root?

Usuario root, también llamado súper usuario o administrador. Su UID (User ID) y GID es 0 y es la única cuenta de usuario con privilegios sobre todo el sistema. Pueden llegar a haber más de un root y estos coexistirían.

### D - Agregue un nuevo usuario llamado iso2017 a su instalación de GNU/Linux, especifique que su home sea creada en /home/iso_2017, y hágalo miembro del grupo catedra (si no existe, deberá crearlo). Luego, sin iniciar sesión como este usuario cree un archivo en su home personal que le pertenezca. Luego de todo esto, borre el usuario y verifique que no queden registros de él en los archivos de información de los usuarios y grupos.

### E - Investigue la funcionalidad y parámetros de los siguientes comandos:
- useradd ó adduser: El comando agrega un nuevo usuario al sesitma. useradd <opciones> NOMBREDEUSUARIO.
  - -m: Para crear un usuario con la carpeta de inicio predeterminada (home).
  - -m -d: Para crear la carpeta de inicio con otro nombre.
  - -s: Cambia el Shell de inicia de sesión de in/bash o bin/sh a uno a elección.
- usermod: Permite modificar todos los parámetros de la cuenta de un usuario creado con anterioridad. usermod [options] LOGIN:
  - –a o -append : Agrega al usuario a los grupos complementarios.
  - -c o -comment COMENTARIO : COMENTARIO será el nuevo valor del campo de comentario en el archivo /etc/passwd.
  - -d, – -home HOME_DIR : HOME_DIR será el nuevo valor para el directorio de inicio del usuario. Si se utiliza conjuntamente con la opción -m, el contenido del directorio de inicio actual se moverá al nuevo directorio de inicio, que se crea si aún no existe.
  - -e, – -expiredate EXPIRE_DATE : Establece la fecha en la que expira la cuenta de usuario. 
  - -f, – -inactive INACTIVE : En INACTIVE se establece el número de días que transcurrirán desde que expira una contraseña hasta que la cuenta se deshabilita permanentemente. Un valor de 0 deshabilita la cuenta tan pronto como la contraseña ha expirado y un valor de -1 deshabilita la función.
  - -g, – -gid GROUP : En GROUP se establece el nombre del grupo o el identificador de grupo (GID) del nuevo grupo primario del usuario. El grupo debe existir previamente antes de establecerlo.
  - -G, – -groups GROUP1[,GROUP2,…[,GROUPn]]] : Similar a la opción anterior, pero permite introducir varios grupos separados por comas. Los grupos deben existir con anterioridad para poder añadirlo. Si el usuario es actualmente miembro de un grupo que no está en la lista, el usuario será eliminado del grupo.
  - -l, – -login NEW_LOGIN : Permite cambiar el nombre de cuenta del usuario al establecido en NEW_LOGIN. Probablemente, el nombre del directorio de inicio del usuario deberá cambiarse manualmente para que tenga el nuevo nombre de cuenta.
  - -L, – -lock : Bloquea la contraseña del usuario.
  - -m, – -move-home : Mueve el contenido del directorio de inicio del usuario a la nueva ubicación. Esta opción solo es válida en combinación con la opción -d (o – -home).
  - -o, – -non-unique : Cuando esta opción se usa conjuntamente con la opción -u, permite cambiar el identificador de usuario (UID) a un valor no único.
  - -p, – -password PASSWORD : Establece una nueva contraseña de usuario.
  - -s, – -shell SHELL : Permite establecer una nueva shell de inicio de sesión del usuario. Dejando este campo en blanco hace que el sistema seleccione la shell de inicio de sesión predeterminada.
  - -u, – -uid UID : Establece el nuevo valor numérico del identificador de usuario (UID). Este valor debe ser único, a menos que se utilice la opción -o.
  - -U, – -unlock : Desbloquea la contraseña de un usuario.
  - -Z, – -selinux-user SEUSER : Establece el usuario de SELinux para el inicio de sesión del usuario.
- userdel: El mandato userdel elimina la cuenta de usuario identificada por el parámetro login .
  - -r: Elimina el directorio de inicio del usuario. Los archivos ubicados en otros sistemas de archivos deben buscarse manualmente y suprimirse. La eliminación del directorio de inicio, que comparten otros usuarios, puede dejar el sistema en un estado incoherente.
- su: Permite cambiar a la cuenta de otro usuario o ejecutar comandos como un usuario diferente. su [options] [username]
  - -m, -p, --preserve-environment: Evita que las variables de entorno se restablezcan al cambiar de usuario. Conserva las variables de entorno actuales del usuario original.
  - -P, --pty: Crea un nuevo pseudo-terminal para la sesión del usuario.
  - -s, --shell [shell]: Ejecuta el shell especificado después de cambiar de usuario.
  - -f, --fast: Inicia un shell rápidamente omitiendo la lectura de los archivos de inicialización (~/.bashrc, ~/.bash_profile, etc.). Es útil para sesiones de shell no interactivas y para ejecutar comandos únicos sin cargar el entorno de shell completo.
  - -c, --command [command]: Pasa un único comando al shell después de cambiar de usuario.
  - --session-command [command]: Pasa un único comando al shell después de cambiar de usuario, pero no crea una nueva sesión.
  - -, -l, --login: Convierte el shell en un shell de inicio de sesión, lo que significa que lee el perfil de inicio de sesión del usuario e inicializa el entorno como si el usuario hubiera iniciado sesión directamente.
  - -g, --group [group]: Establece el grupo principal para la nueva sesión de usuario.
  - -G, --supp-group [group]: Determina un grupo suplementario para la nueva sesión de usuario..
  - -w, --whitelist-environment [list]: Especifica la lista de variables de entorno que no deben restablecerse al cambiar de usuario.
- groupadd: Este comando nos permite añadir grupos al sistema. groupadd [opciones] nombre_de_grupo
  - -g GID o –gid GID: permite especificar el ID de grupo (GID) para el nuevo grupo.
  - -r o –system: crea un grupo de sistema en lugar de un grupo de usuario regular.
  - -f o –force: fuerza la creación del grupo incluso si ya existe otro grupo con el mismo nombre.
  - -K KEY=VALUE o –key KEY=VALUE: permite establecer atributos clave-valor para el grupo.
- who: Una herramienta que imprime información sobre los usuarios que actualmente están conectados.
- groupdel: Permite eliminar grupos de usuarios existentes. groupdel nombre_del_grupo.
- passwd: Permite cambiar las contraseñas de un grupo o de un usuario. passwd [Opciones] [Usuario].
  - -a o –all: esta opción, en combinación con la opción -s, garantiza que recibas información sobre todos los usuarios.
  - -d o –delete: esta opción permite desactivar una contraseña.
  - -e o –expire: esta opción hace que la contraseña pierda su validez. En el próximo inicio de sesión, se deberá determinar una nueva contraseña con el comando passwd.
  - -i o –inactive [Días]: esta opción permite determinar cuándo debe eliminarse una cuenta. Aquí se tiene en cuenta el número de días que un usuario ha estado inactivo después de que su contraseña haya caducado.
  - -k o –keep-tokens: esta opción limita las opciones de cambio para las contraseñas que ya han caducado.
  - -l o –lock: esta opción permite bloquear la contraseña de un usuario.
  - -n o –mindays [Días]: esta opción permite determinar el mínimo de días que hay que esperar antes de poder volver a cambiar la contraseña.
  - -S o –status: esta opción muestra los valores actuales de un usuario.
  - -u o –unlock: esta opción anula la opción -l o –lock.
  - -w o –warndays [Días]: esta opción se utiliza para avisar a un usuario de que una contraseña está a punto de caducar. El parámetro “[Días]” determina con cuánto tiempo de antelación debe enviarse el aviso.
  - -x o –maxdays [Días]: esta opción determina después de cuántos días debe renovarse una contraseña.
