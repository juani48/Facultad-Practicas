## Marque al menos 2 similitudes y 2 diferencias entre los pasajes de mensajes sincrónicos y asincrónicos. Indicar cual es la principal ventaja de pasaje de mensajes sincrónicos respecto a pasaje de mensajes asincrónicos.

Similitudes:
- Utiles para resolver problemas concurrentes en programas distribuidos.
- Los proceso solo comparten canales de comunicacion y todos los datos son locales al proceso
- La sincronizacion se da mediante el intercambio de mensajes

Diferencias:
- En PMA la sentencia de envio de mensajes no demora al proceso que la ejecuta, en cambio en PMS esta sentecia demora al proceso hasta que este se sincronice con otro proceso que se encuentre ejecutando la sentencia de recepticon de mensajes  
- En PMA el canal de comunicacion posee un cola interna con el orden de envio de los mesajes, mientras en PMS esta cola se limita a un mensaje.