## HTTP tiene definido un formato de mensaje para los requerimientos y las respuestas.

### A - ¿Qué información de la capa de aplicación nos indica si un mensaje es de requerimiento o de respuesta para HTTP? ¿Cómo está compuesta dicha información? 

La primeria linea del mesanje HTTP indica si un mensaje es un requerimiento o un respuesta. Si es un requerimiento la primera linea se denomina **linea de solicitud** y esta posee 3 campos: El metodo (`GET`, `POST`, `HEAD`, etc), la URL (identificador del end system servidor dentro de la red) y la version HTTP utilizada. En cambio la primera linea de un mensaje de respuesta se denomina **linea de estado** y tambien posee 3 campos: El campo de versión del protocolo HTTP utilizado, un código de estado y un mensaje de estado correspondiente.

## B - ¿Para qué sirven las cabeceras? ¿Cuál es su formato?

El encabezado, header o cabecera proporciona informacion adicional que sirve para mejorar la comunicacion entre cliente/servidor. Por ejemplo, en la cabecera de una mensaje de requerimiento, un cliente puede especificar en que version de lenguaje quiere recibir la informacion y por otro lado un servidor puede especificar si la conexion se cerrara o se mantendra abierta.

El formato de una cabecera esta compuesto por el nombre del campo (no sensible a las mayusculas) seguido de dos puntos ":", y a continuación su valor (sin saltos de línea). Los espacios en blanco a la izquierda del valor son ignorados. Se pueden agregar campos propietarios personalizadoss usando el prefijo "X-" aunque esta opcion se encuentre desfasada.

## C - Suponga que desea enviar un requerimiento con la versión de HTTP 1.1 desde curl/7.74.0 a un sitio de ejemplo como www.misitio.com para obtener el recurso /index.html. En base a lo indicado, ¿qué información debería enviarse mediante encabezados? Indique cómo quedaría el requerimiento.
```http
GET /index.html HTTP/1.1
Host: www.misitio.com
User-agent: curl/7.74.0
```
