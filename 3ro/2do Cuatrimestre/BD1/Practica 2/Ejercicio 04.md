## Dependencias funcionales
### Dado el siguiente esquema:
*TIENDA (#aplicacion, nombre_aplicacion, descripcion, #categoria, #etiqueta, #desarrollador, nombre_apellido_desarrollador, #actualizacion, descripcion_cambios)*
### Donde:
- #aplicacion, #categoria, #etiqueta y #desarrollador son únicos en el sistema.
- Una aplicación tiene un nombre y una descripción, y puede actualizarse muchas veces
- Para cada actualización de una aplicación se registra un texto con los cambios realizados. El #actualización es secuencial, cada aplicación define los suyos y puede repetirse entre distintas aplicaciones.
- Cada aplicación tiene una única categoría y muchas etiquetas. Las etiquetas pueden ir cambiando con cada actualización de la aplicación (en cada actualización puede haber un conjunto diferente de etiquetas). La categoría nunca cambia, es decir que se mantiene igual sin importar las actualizaciones.
- Una aplicación es realizada por varios desarrolladores de los cuales se conoce su nombre y apellido.

### Seleccione las DFs válidas / mínimas: Para las que no se seleccionen, indicar el motivo.
- [ ] #aplicacion, #actualizacion -> nombre_aplicacion, descripcion
- [X] #aplicacion, #actualizacion -> descripcion_cambios
- [ ] nombre_apellido_desarrollador -> #desarrollador
- [ ] #desarrollador -> nombre_apellido_desarrollador
- [X] #aplicación -> #categoria

### Encontró alguna dependencia funcional más, que no se menciona entre las opciones?
- #aplicacion -> nombre_aplicacion, descripcion. #categoria