## 1 - ¿Qué es una red? ¿Cuál es el principal objetivo para construir una red?

Una red de computadoras: es un grupo de computadora/dispositivos interconectados. Que se centran en compartir recursos (dispositivos, información, servicios). 
## 2 - ¿Qué es Internet? Describa los principales componentes que permiten su funcionamiento.

Internet es el conjunto computadoras, software de red, medios y dispositivos de interconexión. Los principales componentes que periten que internet funcione son:
- Fuente (Software).
- Emisor/Transmisor (Hardware).
- Medio de transmisión y dispositivos intermedios (Hardware).
- Procesos intermedios que tratan la información (Software y Hardware).
- Receptor (Hardware).
- Destino (Software).
- Protocolos (Software)
- Información (Software)

## 3 - ¿Qué son las RFCs?

Los RFCs son solicitudes generales de comentarios (de ahí su nombre) para resolver problemas de diseño de redes y protocolos de Internet. Definen protocolos como TCP, IP, HTTP (para la Web) y SMTP (para el correo electrónico).

## 4 - ¿Qué es un protocolo?

Un protocolo define el formato y el orden de los mensajes intercambiados entre dos o más entidades que se comunican, así como las acciones que se llevan a cabo durante la transmisión y/o recepción de un mensaje u otro evento.

Un protocolo de red es un conjunto de reglas que especifican el intercambio de datos u órdenes durante la comunicación entre las entidades que forman parte de una red. Permiten la comunicación y están implementados en las componentes.

## 5 - ¿Por qué dos máquinas con distintos sistemas operativos pueden formar parte de una misma red?

Porque respetan los mismo protocolos de red estandar.

## 6 - ¿Cuáles son las 2 categorías en las que pueden clasificarse a los sistemas finales o End Systems? Dé un ejemplo del rol de cada uno en alguna aplicación distribuida que corra sobre Internet.

Las dos categorias en las que se puede clasificar un sistema final son cliente y servidor, siendo el cliente un consumidor de los servicios que ofrece el servidor. Un servidor podria proveer servicion de musica como Spotify y un cliente podria consumir dichos servicios desde un navegador web.

## 7 - ¿Cuál es la diferencia entre una red conmutada de paquetes de una red conmutada de circuitos?

En las redes conmutadas por circuitos, los recursos necesarios a lo largo de un camino (como buffers y la tasa de transmisión del enlace) para proporcionar comunicación entre los sistemas finales se reservan durante toda la sesión de comunicación entre los sistemas finales. En las redes conmutadas por paquetes, estos recursos no se reservan; los mensajes de una sesión utilizan los recursos según demanda y, como consecuencia, pueden tener que esperar (hacer cola) para acceder a un enlace de comunicación.

Como analogía sencilla, consideremos dos restaurantes: uno que requiere reservas y otro que no las requiere ni las acepta. Para el restaurante que requiere reservas, tenemos que pasar por el trámite de llamar antes de salir de casa. Pero cuando llegamos al restaurante, en principio, podemos ser sentados de inmediato y hacer nuestro pedido. Para el restaurante que no requiere reservas, no necesitamos preocuparnos por reservar una mesa. Pero cuando llegamos al restaurante, podemos tener que esperar antes de que nos asignen una mesa.

## 10 - ¿Qué ventajas tiene una implementación basada en capas o niveles?

Una arquitectura en capas nos permite analizar una parte bien definida y específica de un sistema grande y complejo. Esta simplificación por sí misma tiene un valor considerable, ya que proporciona modularidad, haciendo mucho más fácil cambiar la implementación del servicio que brinda la capa. Mientras la capa proporcione el mismo servicio a la capa superior y utilice los mismos servicios de la capa inferior, el resto del sistema permanece sin cambios cuando se modifica la implementación de una capa. Para sistemas grandes y complejos que se actualizan constantemente, la capacidad de cambiar la implementación de un servicio sin afectar otros componentes del sistema es otra ventaja importante de la arquitectura en capas.

## 11 - ¿Cómo se llama la PDU de cada una de las siguientes capas: Aplicación, Transporte, Red y Enlace?

- Aplicación: Mensaje.
- Transporte: Segmento.
- Red: Datagrama.
- Enlace: Frame.

## 12 - ¿Qué es la encapsulación? Si una capa realiza la encapsulación de datos, ¿qué capa del nodo receptor realizará el proceso inverso?

La encapsulación es un proceso por el cual la infomracion se paquetiza y se separa en dos partes, un encabezado o header, que contiene datos de la capa emisora que seran utilizados por la capa receptora, y un cuerpo o body donde se alamcena la infomracion como tal que se desea enviar.

El encargado de realziar el proceso inverso al ecpasulamiento es la respectiva capa emisora que se encuntra al mismo nivel de cada capa receptora. Entonces si la capa de red emisora encapsula ciertos datos, la capa de red receptora sera la encargada de realizar el proceso inverso.

## 13 - Describa cuáles son las funciones de cada una de las capas del stack TCP/IP o protocolo de Internet.
## 14 - Compare el modelo OSI con la implementación TCP/IP.

Similitudes:
- Ambos se dividen en capas.
- Ambos tienen capas de aplicación, aunque incluyen servicios distintos.
- Ambos tienen capas de transporte similares.
- Ambos tienen capa de red similar pero con distinto nombre.
- Se supone que la tecnologı́a es de conmutación de paquetes (no de conmutación de circuitos).
- Es importante conocer ambos modelos.

Diferencias:
- TCP/IP combina las funciones de la capa de presentación y de sesión en la capa de aplicación.
- TCP/IP combina la capas de enlace de datos y la capa fı́sica del modelo OSI en una sola capa.
- TCP/IP más simple porque tiene menos capas.
- Los protocolos TCP/IP son los estándares en torno a los cuales se desarrolló Internet, de modo que la credibilidad del modelo TCP/IP se debe en gran parte a sus protocolos.
- El modelo OSI es un modelo “más” de referencia, teórico, aunque hay implementaciones.
