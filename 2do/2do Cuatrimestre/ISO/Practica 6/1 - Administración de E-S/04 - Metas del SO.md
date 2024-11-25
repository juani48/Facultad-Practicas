## A - Enuncie las metas que debe perseguir un SO para la administración de la entrada salida.

- **Generalidad:** Es deseable manejar todos los dispositivos de I/O de una manera uniforme, estandarizada. 
- **Interfaz Uniforme:** Ocultar la mayoría de los detalles del dispositivo en las rutinas de niveles más “bajos” para que los procesos vean a los dispositivos, en términos de operaciones comunes.
- **Eficiencia:** Los dispositivos de I/O pueden resultar extremadamente lentos respecto a la memoria y la CPU. El uso de la multi-programación permite que un procesos espere por la finalización de su I/O mientras que otro proceso se ejecuta. 
- **Planificación:** Organización de los requerimientos a los dispositivos. 
- **Buffering (Almacenamiento de los datos en memoria mientras se transfieren):** Solucionar problemas de velocidad entre los dispositivos Solucionar problemas de tamaño y/o forma de los datos entre los dispositivos. 
- **Caching:** Mantener en memoria copia de los datos de reciente acceso para mejorar performance.
- **Spooling:** Administrar la cola de requerimientos de un dispositivo. Algunos dispositivos de acceso exclusivo, no pueden atender distintos requerimientos al mismo tiempo. Es un mecanismo para coordinar el acceso concurrente al dispositivo. 
- **Reserva de Dispositivos:** Acceso exclusivo. 
- **Manejo de Errores:** El S.O. debe administrar errores ocurridos (lectura de un disco, dispositivo no disponible, errores de escritura).
- **Formas de realizar I/O:**
  - **Bloqueante:** El proceso se suspende hasta que el requerimiento de I/O se completa.
  - **No Bloqueante:** El requerimiento de I/O retorna en cuanto es posible.