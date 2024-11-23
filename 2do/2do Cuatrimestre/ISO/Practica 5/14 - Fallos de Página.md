## A - ¿Cuándo se producen?

Cuando un proceso quiere acceder a una página que no se encuentra cargada en memoria (acceso indebido a memoria).

## B - ¿Quién es responsable de detectar un fallo de página?

Cuando un proceso intenta acceder a una dirección de memoria que está mapeada lógicamente, pero no está cargada en la memoria física, La MMU detecta que la página no está en la memoria física, la MMU genera una interrupción de tipo acceso indebido a memoria, lo que indica que la página no está presente.

## C - Describa las acciones que emprende el SO cuando se produce un fallo de página.

1. El S.O. busca un marco libre en la memoria; si fuese necesario selecciona un pagina victima
2. Genera una operación de E/S al disco para copiar en dicho Frame la página del proceso que se necesita utilizar. El SO puede asignarle la CPU a otro proceso mientras se completa la E/S. 
3. Un vez finalizada la operacion de E/S, el SO actualiza la tabla de páginas del proceso. 
4. El proceso que generó el Fallo de Página vuelve a estado de Ready (listo). 
5. Cuando el proceso se ejecute, se volverá a ejecutar la instrucción que antes generó el fallo de 
página. 
