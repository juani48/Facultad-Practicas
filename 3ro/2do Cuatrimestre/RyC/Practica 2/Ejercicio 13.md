## Utilizando curl, realice un requerimiento con el método HEAD al sitio www.redes.unlp.edu.ar e indique:
### A - ¿Qué información brinda la primera línea de la respuesta?
La version de HTTP con la que respndio el servidor (HTTP/1.1), un codigo de retorno (200) y un mensaje de retorno (OK)

### B - ¿Cuántos encabezados muestra la respuesta?
7 encabezados:
- `Date`
- `Server`
- `Last-Modified`
- `ETAg`
- `Accept-Ranges`
- `Content-Length`
- `Content-Type`

### C - ¿Qué servidor web está sirviendo la página?
Un servidor Apache/2.4.56 (Unix)

### D - ¿El acceso a la página solicitada fue exitoso o no?
Si, esto se obtiene a partir del codigo de respuesta o estado (que en este caso fue 200) y por el mesaje de estado (que fue OK)  

### E - ¿Cuándo fue la última vez que se modificó la página?
Sun, 19 Mar 2023 19:04:46 GMT

### F - Solicite la página nuevamente con curl usando GET, pero esta vez indique que quiere obtenerla sólo si la misma fue modificada en una fecha posterior a la que efectivamente fue modificada. ¿Cómo lo hace? ¿Qué resultado obtuvo? ¿Puede explicar para qué sirve?
Se obtiene ejecutando el siguiente comando:
```bash
curl -H "If-modified-since: Sun, 19 Mar 19:04:46 GMT" www.redes.unlp.edu.ar
```
De respuesta, solo se obtiene el encabezado con el codigo de estado 304 y el mesanje de estado `Not Modified`.

De esta forma se realizan peticiones condicionales, donde en este caso, el servidor solo enviara el objeto solicitado si este fue modificado posteriormente a la fecha indicada.

