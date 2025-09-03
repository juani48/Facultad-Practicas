## En base a lo obtenido en el ejercicio anterior, responda:
### A - ¿Qué está haciendo al ejecutar el comando telnet?

Simula la conexcion que realizaria un navegador web a un servidor estableciendo una conexcion TCP

### B - ¿Qué método HTTP utilizó? ¿Qué recurso solicitó?

Utilice un metodo `GET` y solicite documentos HTML (`/http/HTTPS-1.1`)

### C - ¿Qué diferencias notó entre los dos casos? ¿Puede explicar por qué?

En el primer caso (utilizando HTTP/1.0) la conexcion se cerro luego de recibir la respuesta del servidor. En el segundo caso, la conexcion se mantuvo hasta que no envie mas solicitudes o hasta que la cerrara manualmente.

Esto se debe a que HTTP/1.0 no puede mantener conexciones persistentes con servidores, a partir de HTTP/1.1 las conexciones se pueden condfigurar para mantenerse o cerrarce y por defecto estas se mantienen

### D - ¿Cuál de los dos casos le parece más eficiente? Piense en el ejercicio donde analizó la cantidad de requerimientos necesarios para obtener una página con estilos, javascripts e imágenes. El caso elegido, ¿puede traer asociado algún problema?

El segundo caso es mas eficiente, dado que noes necesario realizar nuevas conexciones TCP, sino que esta se mantiene. El problema sociado es que un servidor queda pendiente de clientes que podrian no realizar mas peticiones HTTP y se perderia la posibilidad de anteder otros posibles clientes.