## Sean los procesos A, B y C tales que necesitan para su ejecución las siguientes páginas: 

### - A: 1, 3, 1, 2, 4, 1, 5, 1, 4, 7, 9, 4
### - B: 2, 4, 6, 2, 4, 1, 8, 3, 1, 8 
### - C: 1, 2, 4, 8, 6, 1, 4, 1 

## Si la secuencia de ejecución es tal que los procesos se ejecutan en la siguiente secuencia:

### 1. *B* demanda 2 páginas 
### 2. *A* demanda 3 páginas 
### 3. *C* demanda 2 páginas 
### 4. *B* demanda 3 páginas 
### 5. *A* demanda 3 páginas 
### 6. *C* demanda 2 páginas 
### 7. *B* demanda 2 páginas 
### 8. *C* demanda 4 páginas 
### 9. *A* demanda 3 páginas 
### 10. *B* demanda 3 páginas 
### 11. *C* termina 
### 12. *A* demanda 3 páginas 
### 13. *B* termina 
### 14. *A* termina

### A - Considerando una política de Asignación Dinámica y Reemplazo Global y  disponiéndose de 7 marcos. ¿Cuántos fallos de página se producirán si se utiliza la técnica de selección de victimas: LRU y Segunda Chance.

- LRU: 24 PF
- SC: 23 PF

### B - Considerando una política de Asignación Fija con reparto equitativo y Reemplazo Local y disponiéndose de 9 marcos. ¿Cuántos fallos de página se producirán si se utiliza la técnica de selección de victimas: LRU y Segunda Chance.

- LRU: 20 PF
- SC: 22 PF
