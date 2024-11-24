## Suponga que tenemos una memoria virtual paginada, con tabla de paginas de 1 nivel, y donde  la tabla de páginas se encuentra completamente en la memoria. Servir una falla de página tarda 300 nanosegundos si hay disponible un marco vacío o si la página reemplazada no se ha modificado, y 500 nanosegundos si se ha modificado. El tiempo de acceso a memoria es de 20 nanosegundos y el de acceso a la TLB es de 1 nanosegundo.

- $\ TF\ =\ 300\ ~\ 900 $
- $\ TM\ =\ 20 $
- $\ AT\ =\ 1 $


## A - Si suponemos una taza de fallos de página de 0,3 y que siempre contamos con un marco libre para atender el fallo ¿Cual será el TAE  si el 50% de las veces la entrada de la tabla de páginas se encuentra en la TLB (hit)? 

- $\ p\ =\ 0,3 $
- $\ AT\ =\ (0,5\ *\ 1)\ +\ (0,5\ *\ 20)\ =\ 10,5 ns$

$\ 10,5\ +\ (1\ -\ 0,3)\ *\ 20\ +\ 0.3\ *\ (200\ +\ 20)\ = \ 120,5ns $

## B - Si suponemos una taza de fallos de página de 0,3; que el 70% de las ocasiones  la pagina a reemplazar se encuentra modificada. ¿Cual será el TAE  si el 60% de las veces la entrada de la tabla de páginas se encuentra en la TLB (hit)?

- $\ p\ =\ 0,3 $
- $\ TF\ =\ (0,7\ *\ 900)\ +\ (0,3\ *\ 300)\ =\ 720ns $
- $\ AT\ =\ (0,6\ *\ 1)\ +\ (0,4\ *\ 20)\ =\ 8,6 ns$

$\ 8,6\ +\ (1\ -\ 0,3)\ *\ 20\ +\ 0.3\ *\ (720\ +\ 20)\ = \ 244,6ns $

