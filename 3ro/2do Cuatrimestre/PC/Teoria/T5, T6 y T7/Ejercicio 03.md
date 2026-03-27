## Analice qué tipo de mecanismos de pasaje de mensajes son más adecuados para resolver problemas de tipo Cliente/Servidor, Pares que interactúan, Filtros, y Productores y Consumidores. Justifique claramente su respuesta.

- C/S: El mejor mecanismo el PMA, ya que permite al servidor enviar las respestas de los clinetes, sin demorarse en la sentencia de envio a que el cliente que espera la respueste se encuentre en la sentencia de recepcion.

- Peers: El mejor mecanismo es PMS, porque los pares deben estar sincronizados respecto a los datos, por lo que es necesario demorar a aquellos pares que ya hayan resulto su parte hasta que todos se encuentren en el mismo punto de ejecucion y poder compartir su informacion.

- Filtros: El mejor mecanismo es PMA, ya que permite que un de los nodos del pipeline haga su parte del trabajo, le envie su parte al nodo siguiente y trabajar con un nuevo conjunto de datos, sin demorarse en el envio de datos.

- Productores/Consumidores: El mejor mecanismo es PMA, ya que permite a los productores generar datos y depositarlos en la cola de mensajes que permite el PMA, de esta forma los conusmidores, al estar listos, consumen los datos en el orden el que fueron depositados en el canal.