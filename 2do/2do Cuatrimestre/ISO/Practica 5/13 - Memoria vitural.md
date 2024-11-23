## A - Describa que beneficios introduce este esquema de administración de la memoria.  

Permite tener cargado en memoria solo lo que le proceso utiliza y tene procesos que virtuialemnte ocupen mas que la memoria fisica del sistema.

## B - ¿En que se debe apoyar el SO para su implementación? 

El SO se debe apóyar de un area de intercambio (SWAP) que es una espacion en memoria secundaria, que permite guardar las paginas no utlizadas. 

## C - Al implementar está técnica utilizando paginación por demanda, las tablas de paginas de un proceso deben contar con información adicional además del marco donde se encuentra la página. ¿Cuál es está información? ¿Porque es necesaria?

Se necesita almacenar si la página se encuentra cargada o no en RAM, para saber cuándo un proceso realiza un acceso indebido a memoria porque realmente es un programa malicioso o porque dicha página todavía no fue cargada. Además se debe almacenar si una página fue modificada o utilizada, para saber que página victima seleccionar a la hora de resolver un situación de hiperpaginacion.
