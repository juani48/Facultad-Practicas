## Ejecute a continuación los siguientes comandos:
```bash
curl -v -s www.redes.unlp.edu.ar > /dev/null
curl -I -v -s www.redes.unlp.edu.ar
```
### A - ¿Qué diferencias nota entre cada uno?

Que el primer comadno requiere redireccionamiento porque no posee el parametro `-I` por lo que se muestra el cuerpo de la respuesta del servidor. En cambio el segundo comando al incluir `-I` no requiere redireccionar el cuerpo de la respuesta, ademas de utilizar el parametro `-v` activa el modo detallado (verbose mode), lo que hace que `curl` muestre información detallada sobre la solicitud y la respuesta, incluyendo la petición enviada, los encabezados de respuesta, y otros detalles del proceso de transferencia.

### B - ¿Qué ocurre si en el primer comando se quita la redirección a /dev/null? ¿Por qué no es necesaria en el segundo comando?

Muestra tanto el encabezado como el cuerpo de la respuesta del servidor. No es necesario en el segundo comando porque utiliza el parametro `-I` que solicita solo los encabezados HTTP de la respuesta (sin el cuerpo).

### C - ¿Cuántas cabeceras viajaron en el requerimiento? ¿Y en la respuesta?

Una cabecera para el requerimiento y uno en la respuesta.