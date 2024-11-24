## Al momento de tener que seleccionar una pagina victima, el SO puede optar por 2 políticas a utilizar: Reemplazo local, reemplazo global.

### A - Describa como trabajan estas 2 políticas. 

- *Reemplazo global:* El fallo de página de un proceso puede reemplazar la página de cualquier proceso. 
- *Reemplazo local:* El fallo de página de un proceso solo puede reemplazar sus propias paginas. 

### B - ¿Es posible utilizar la política de “Asignación Fija” de marcos junto con la política de “Reemplazo Global? Justifique.  

No es posible, debido a que la asignación fija define que a cada proceso se le da una cantidad fija de marcos para trabajar, la cual no puede ser aumentada ni disminuida. En cambio la política de reemplazo global define que cuando se debe elegir una página victima para cargar una nueva página (debido a un fallo de página) se selecciona una marco o página víctima de entre todas las del sistema, esto haría que a un procesos de le reduzca su cantidad de marcos y a otro se le aumente; con lo que se iría en contra la asignación fija. 
