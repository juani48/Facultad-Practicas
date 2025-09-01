## Si dos procesos deben comunicarse

### A - ¿Cómo podrían hacerlo si están en diferentes máquinas?
Para que dos procesos se comuniquen estando es diferentes maquinas, el proceso emisor debe concer la direccion IP donde se ejecuta el proceso receptor y el identificador del proceso receptor dentro de la maquina receptora (numero de puerto)
### B - Y si están en la misma máquina, ¿qué alternativas existen?
Si los procesos se encuntrar en la misma maquina, estos se pueden comunicar de varias formas:
- Espacios de memoria compartida.
- Tuberías o pipes: Un mecanismo de comunicación unidireccional, donde los datos escritos en un extremo son leídos por el otro. 
- Sockets de Dominio Unix: Son similares a los sockets de red (TCP/IP), pero toda la comunicación ocurre dentro del kernel del sistema operativo, sin overhead de red. Pueden ser tanto orientados a conexión (como TCP) como no orientados a conexión (como UDP).
- Colas de Mensajes: Son una evolución de las tuberías, permitiendo el envío de mensajes en "paquetes" discretos, cada uno con un tipo o prioridad.