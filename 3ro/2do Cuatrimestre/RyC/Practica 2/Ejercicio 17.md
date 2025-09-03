## En el siguiente ejercicio veremos la diferencia entre los métodos POST y GET. Para ello, será necesario utilizar la VM y la herramienta Wireshark.

### D - ¿Qué diferencias detectó en los mensajes enviados por el cliente?
Con el metodo `POST` los datos de formulario son enviados a traves del cuerpo del mensaje. En cambio con el metodo `GET` son enviados a traves del encabezado, en la primera linea, al momento de definir el objeto a solicitar al servidor

### E - ¿Observó alguna diferencia en el browser si se utiliza un mensaje u otro?

Con el metodo `GET` se ven los parametros enviados en la URL