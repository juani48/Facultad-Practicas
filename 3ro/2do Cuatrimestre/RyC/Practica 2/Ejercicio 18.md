## Investigue cuál es el principal uso que se le da a las cabeceras Set-Cookie y Cookie en HTTP y qué relación tienen con el funcionamiento del protocolo HTTP.

`Set-Cookie:` contiene un numero identificador que el servidor envia como encabezado en su respuesta a un cliente. Este identificador es guardado por el cliente (navegador web) para su proxima utilizacion.

`Cookie:` en cambio es enviado por el cliente el su peticion a un servidor. Al igual que con `Set-Cookie`, `Cookie` contiene un numero identificador que le navegador web almaceno y asocio al servidor solicitado previamente, de esta forma el servidor puede "recordar" que cliente esta realizando una peticion. 
