## Ejecute el comando curl sin ningún parámetro adicional y acceda a `www.redes.unlp.edu.ar`. Luego responda:

### A - ¿Cuántos requerimientos realizó y qué recibió? Pruebe redirigiendo la salida (>) del comando curl a un archivo con extensión html y abrirlo con un navegador.

Se realizo el envio de un unico requerimiento `GET` a la url `www.redes.unlp.edu.ar` y recibi el contenido HTML del documento index.html

### B - ¿Cómo funcionan los atributos href de los tags link e img en html?

El atributo `href` en HTML se utiliza para especificar la dirección de destino de un enlace. 

El atributo `href` en la etiqueta `<link>` establece una relación entre el documento HTML y un recurso externo, normalmente un archivo `.css`.

En el contexto de imágenes, el atributo `href` no se aplica directamente al elemento `<img>`, ya que este no posee un atributo `href`. En su lugar, para convertir una imagen en un hipervínculo, se debe envolver la etiqueta `<img>` dentro de una etiqueta `<a>` y colocar el atributo `href` en esta última. De esta forma, al hacer clic en la imagen, el navegador redirigirá al usuario a la URL especificada en el atributo `href` del elemento `<a>`.

### C - Para visualizar la página completa con imágenes como en un navegador, ¿alcanza con realizar un único requerimiento?

NO, se deberan realizar tanto requerimientos `GET` como objetos haya en servior con url `www.redes.unlp.edu.ar`

### D - ¿Cuántos requerimientos serían necesarios para obtener una página que tiene dos CSS, dos JavaScript y tres imágenes? Diferencie cómo funcionaría un navegador respecto al comando curl ejecutado previamente.

En total serian necesarios 8 requerimientos `GET`:
- Un primer requerimiento para el documento HTML
- Luego deberan realizarce dos para los archivos CSS
- Dos para los archivos JavaScript
- Y finalmente tres para obtener las tres imagenes.

**Comportamiento del Navegador:**
- Realiza una solicitud inicial para el documento HTML
- Analiza el HTML y descubre todos los recursos vinculados (CSS, JS, imágenes)
- Inicia solicitudes paralelas para cada recurso (generalmente con un límite de conexiones simultáneas por dominio)
- A medida que recibe los recursos, los procesa:
    - Aplica los estilos CSS
    - Ejecuta los scripts JavaScript
    - Renderiza las imágenes

**Comportamiento de cURL:**
- Realiza una sola solicitud para el recurso especificado en la línea de comandos
- Devuelve el contenido de ese recurso específico
- No analiza el contenido en busca de referencias adicionales
- No ejecuta JavaScript ni aplica estilos

La diferencia fundamental radica en que los navegadores están diseñados para renderizar contenido web completo, lo que implica múltiples solicitudes y procesamiento de recursos, mientras que cURL es simplemente una herramienta de transferencia de datos que se limita a recuperar el recurso específico que se le solicita. Para obtener todos los recursos de una página con cURL, se necesitaria ejecutar múltiples comandos, uno para cada recurso, o utilizar herramientas más avanzadas como wget con la opción de descarga recursiva.