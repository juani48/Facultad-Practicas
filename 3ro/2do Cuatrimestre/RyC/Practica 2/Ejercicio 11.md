## En HTTP/1.0, ¿cómo sabe el cliente que ya recibió todo el objeto solicitado de manera completa? ¿Y en HTTP/1.1?

En HTTP/1.0, hay dos formas principales:
- **Cierre de conexión:** La forma más común era que el servidor cerraba la conexión TCP después de enviar la respuesta completa. Cuando el cliente detectaba el fin de la conexión, sabía que había recibido todos los datos.
- **Cabecera Content-Length:** Algunas implementaciones usaban la cabecera `Content-Length:` para indicar el tamaño exacto del cuerpo de la respuesta en bytes.

En HTTP/1.1 utiliza un metodo de HTTP/1.0 y agrega uno nuevo:
- **Cabecera Content-Length:** AL igual que en HTTP/1.0 el campo `Content-Length` indica el tamaño exacto del cuerpo en bytes. El cliente cuenta los bytes recibidos hasta alcanzar este valor.
- **Transfer-Encoding: chunked:** Permite enviar el cuerpo en fragmentos (chunks). Cada chunk viene precedido por su tamaño en hexadecimal. El cliente sabe que la transferencia terminó cuando recibe un chunk de tamaño 0.

A diferencia de HTTP/1.0, las conexiones no se cierran automáticamente después de cada respuesta, por lo que el cierre de conexión ya no es un indicador confiable de fin de contenido.
