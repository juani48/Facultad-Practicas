## Ejercicio de Parcial
```bash
curl -X ?? www.redes.unlp.edu.ar/??

HEAD /metodos/ HTTP/??
Host: www.redes.unlp.edu.ar
User-Agent: curl/7.54.0


HTTP/?? 200 OK
Server: nginx/1.4.6 (Ubuntu)
Date: Wed, 31 Jan 2018 22:22:22 GMT
Last-Modified: Sat, 20 Jan 2018 13:02:41 GMT
Content-Type: text/html; charset=UTF-8
Connection: close
```
### A -¿Qué versión de HTTP podría estar utilizando el servidor?

El servidor utiliza HTTP/1.1 debido envia como respuesta la cabecera `Connection: close`

### B - ¿Qué método está utilizando? Dicho método, ¿retorna el recurso completo solicitado?

Se esta utilizando un metodo `GET`. Si el recurso solicitado posee imagenes, plantillas de estilo o archivos JavaScript, el recurso no sera retornado por completo, dado que se puede retornar un objeto por requerimiento y en este caso se retorna el documento HTML

### C - ¿Cuál es el recurso solicitado?

`/metodos/`

### D - ¿El método funcionó correctamente?

Si, esto es visible en la respuesta del servidor, indicando mediante el codigo (200) y el mensaje (OK) de estado que la operacion funciono correctamente.   


### E - Si la solicitud hubiera llevado un encabezado que diga: If-Modified-Since: Sat, 20 Jan 2018 13:02:41 GMT ¿Cuál habría sido la respuesta del servidor web? ¿Qué habría hecho el navegador en este caso?

La respuesta del servidor seria: `HTTP/1.1 304 Not Modified`.


