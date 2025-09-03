## Responder las siguientes preguntas:

### A - ¿Qué función cumple la cabecera Host en HTTP 1.1? ¿Existía en HTTP 1.0? ¿Qué sucede en HTTP/2? 

En HTTP/1.1 el encabezado de solicitud `Host` especifica el nombre de dominio del servidor y opcionalmente el número de puerto TCP en el que el servidor esta escuchando.

La cabecera `Host` no existe en HTTP/1.0. Esta cabecera fue introducida específicamente en HTTP/1.1 para permitir el alojamiento virtual, es decir, que múltiples sitios web puedan compartir la misma dirección IP y puerto.

HTTP/2.0 posee el concepto de cabecera `Host` implementado en una pseudo-cabecera `:authority`. Opcionalmente la cabecera `Host` se puede seguir utilizando por cuestiones de retrocompatibilidad. De esta forma HTTP/2.0 reemplaza la cabecera `Host` con la pseudo-cabecera `:authority`.

### B - En HTTP/1.1, ¿es correcto el siguiente requerimiento?
```bash
GET /index.php HTTP/1.1
User-Agent: curl/7.54.0
```

El requerimiento HTTP/1.1 anterior no es válido porque le falta la cabecera Host. En HTTP/1.1, la cabecera Host es obligatoria según el estándar RFC 2616.

### C - ¿Cómo quedaría en HTTP/2 el siguiente pedido realizado en HTTP/1.1 si se está usando https?
```bash
GET /index.php HTTP/1.1
Host: www.info.unlp.edu.ar
```

El formato del requerimiento se modifica considerablemente debido a que HTTP/2 implementa un protocolo binario y pseudo-cabeceras:
```bash
:method = GET
:path = /index.php  
:scheme = https
:authority = www.info.unlp.edu.ar
```