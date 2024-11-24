## Sean los procesos A, B y C tales que necesitan para su ejecución las siguientes páginas: 

### - A: 1, 2, 1, 7, 2, 7, 3, 2 
### - B: 1, 2, 5, 2, 1, 4, 5 
### - C: 1, 3, 5, 1, 4, 2, 3

## Si la secuencia de ejecución es tal que los procesos se ejecutan en la siguiente manera:

### 1. *C* demanda 1 página 
### 2. *A* demanda 2 páginas 
### 3. *C* demanda 1 página 
### 4. *B* demanda 1 página 
### 5. *A* demanda 1 página 
### 6. *C* modifica la página 1 
### 7. *B* demanda 2 páginas 
### 8. *A* demanda 1 página 
### 9. *C* demanda 1 página 
### 10. *B* modifica la página 2 
### 11. *A* modifica la página 2 
### 12. *B* demanda 2 páginas 
### 13. *A* demanda 1 página 
### 14. *B* demanda 2 páginas
### 15. *C* demanda 2 páginas 
### 16. *C* demanda 1 página 
### 17. *A* demanda 1 página 
### 18. *B*  termina 
### 19. *A* demanda 2 páginas 
### 20. *C* demanda 1 página 
### 21. *A* termina 
### 22. *C* termina

### A -Considerando una política de Asignación Dinámica y Reemplazo Global y disponiéndose de 7 marcos, debiéndose guardar 1 marco para la gestión de descarga asincrónica de paginas modificadas ¿Cuántos fallos de página se producirán si se utiliza la técnica de selección de victima: 

- SC: 17 
- FIFO: 18
- LRU: 20
