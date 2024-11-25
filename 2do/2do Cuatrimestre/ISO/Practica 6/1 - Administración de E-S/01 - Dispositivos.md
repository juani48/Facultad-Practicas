## A - Los dispositivos, según la forma de transferir los datos, se pueden clasificar en 2 tipos: Orientados a bloques, orientados a flujos. Describa las diferencias entre ambos tipos.

- **Dispositivos orientados a bloques:** Son dispositivos que almacenan y transfieren datos en bloques de tamaño fijo. Cada bloque representa una unidad mínima de datos que se puede leer o escribir. Permiten el acceso aleatorio, es decir, se puede leer o escribir cualquier bloque directamente sin necesidad de procesar los bloques anteriores. Son ideales para sistemas de archivos y almacenamiento masivo, donde el acceso estructurado y organizado a los datos es crucial.

- **Dispositivos orientados a flujos:** Son dispositivos que transfieren datos de manera secuencial, es decir, como un flujo continuo de bytes. No existen bloques predefinidos, y los datos deben procesarse en orden. Son ideales para la entrada/salida (E/S) en tiempo real y la transmisión continua de datos. Se utilizan en aplicaciones donde los datos se procesan en tiempo real o donde no es necesario un acceso aleatorio, como en transmisiones de datos o streaming.

## B - Cite ejemplos de dispositivos de ambos tipos.

- **Dispositivos orientados a bloques:** Discos duros (HDD), discos de estado sólido (SSD), y dispositivos USB.
- **Dispositivos orientados a flujos:** Interfaces de red, dispositivos de comunicación serie, y cintas magnéticas.

## C - Enuncie las diferencias que existen entre los dispositivos de E/S y que el SO debe considerar.

Las diferencias que el SO debe considerar son: Heterogeneidad de dispositivos, características de los dispositivos, velocidad, unidades de transferencia, formas de acceso, tipos de acceso y tipos de acceso.