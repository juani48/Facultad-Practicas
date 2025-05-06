## Identificar a qué clase de tipo de datos pertenecen los siguientes extractos de código. En algunos casos puede corresponder más de una:
### A
```java
class Persona {
    String nombre;
    String apellido;
    int edad;
}
```
Producto cartesiano y Correspondencia Finita.

### B
```C
typedef struct _nodoLista {
    void *dato;
    struct _nodoLista *siguiente
} nodoLista;

typedef struct _lista {
    int cantidad;
    nodoLista *primero
} Lista;
```
Producto cartesiono y Recursivo.

### C
```c
union codigo {
    int numero;
    char id;
};
```
Union.

### D
```ruby
hash = {
    uno: 1,
    dos: 2,
    tres: 3,
    cuatro: 4
}
```
Producto cartesiano y Correspondencia Finita.

### E
```php
function doble($x) {
    return 2 * $x;
}
```
Correspondencia Finita.

### F
```python
tuple = ('physics','chemistry', 1997, 2000)
```
Producto cartesiano y Correspondencia Finita.

### G
```haskell
data ArbolBinarioInt =
    Nil |
    Nodo int
        (ArbolBinarioInt dato)
        (ArbolBinarioInt dato)
```
Union y Recursion.

### H
```haskell
data Color =
    Rojo |
    Verde |
    Azul
```
Union.