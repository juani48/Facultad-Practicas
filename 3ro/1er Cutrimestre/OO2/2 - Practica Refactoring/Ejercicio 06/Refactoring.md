## Clase ArbolBinario
### Replace conditional with polymorphism
```java
public String recorrerPreorden() {
        String resultado = valor + " - ";
        if (this.getHijoIzquierdo() != null) {
        	resultado += this.getHijoIzquierdo().recorrerPreorden();
	}
        if (this.getHijoDerecho() != null) {
        	resultado += this.getHijoDerecho().recorrerPreorden();
        }
        return resultado;
    }

   public String recorrerInorden() {
        String resultado = "";
        if (this.getHijoIzquierdo() != null) {
        	resultado += this.getHijoIzquierdo().recorrerInorden();
	}
        resultado += valor + " - ";
        if (this.getHijoDerecho() != null) {
        	resultado += this.getHijoDerecho().recorrerInorden();
        }
        return resultado;
    }

   public String recorrerPostorden() {
        String resultado = "";
        if (this.getHijoIzquierdo() != null) {
        	resultado += this.getHijoIzquierdo().recorrerPostorden();
	}
        if (this.getHijoDerecho() != null) {
        	resultado += this.getHijoDerecho().recorrerPostorden();
        }
        resultado += valor + " - ";
        return resultado;
    }
```
Crear una interface `Nodo` con las etiquetas `public String recorrerPreorden();`, `public String recorrerInorden();`, `public String recorrerPostorden();`.

Crear una clase NullObject `NodoVacio` que implemente la interface `Nodo`.

Implementar lo metodos de la interface dentro de `NodoVacio` para que retornen `""`:
```java
public class NodoVacio implements Nodo{
	public String recorrerPreorden() { return ""; }
	public String recorrerInorden() { return ""; }
	public String recorrerPostorden() { return ""; }
}
```
Reemplazar los tipos de las variables `hijoIzquierdo` y `hijoDerecho` de `ArbolBinario` a `Nodo`.

Reemplazar el tipo de retorno de los getters y el tipo de parametro de los setters en `ArbolBinario`.

Hacer que `ArbolBinario` implemente la interface `Nodo`.

Eliminar los condicionales de los metodos `public String recorrerPreorden();`, `public String recorrerInorden();`, `public String recorrerPostorden();` en `ArbolBinario`:
```java
public String recorrerPreorden() {
        String resultado = valor + " - ";
        resultado += this.getHijoIzquierdo().recorrerPreorden();
        resultado += this.getHijoDerecho().recorrerPreorden();
        return resultado;
    }

   public String recorrerInorden() {
        String resultado = "";
        resultado += this.getHijoIzquierdo().recorrerInorden();
        resultado += valor + " - ";
        resultado += this.getHijoDerecho().recorrerInorden();
        return resultado;
    }

   public String recorrerPostorden() {
        String resultado = "";
        resultado += this.getHijoIzquierdo().recorrerPostorden();
        iresultado += this.getHijoDerecho().recorrerPostorden();
        resultado += valor + " - ";
        return resultado;
    }
```
### Variables innecesarias
```java
    public String recorrerPreorden() {
        String resultado = valor + " - ";
        resultado += this.getHijoIzquierdo().recorrerPreorden();
        resultado += this.getHijoDerecho().recorrerPreorden();
        return resultado;
    }

    public String recorrerInorden() {
        String resultado = "";
        resultado += this.getHijoIzquierdo().recorrerInorden();
        resultado += valor + " - ";
        resultado += this.getHijoDerecho().recorrerInorden();
        return resultado;
    }

    public String recorrerPostorden() {
        String resultado = "";
        resultado += this.getHijoIzquierdo().recorrerPostorden();
        iresultado += this.getHijoDerecho().recorrerPostorden();
        resultado += valor + " - ";
        return resultado;
    }
```
Replace temp with query:
```java
    public String recorrerPreorden() { 
	   return  valor + " - " + this.getHijoIzquierdo().recorrerPreorden() + this.getHijoDerecho().recorrerPreorden(); 
    }

    public String recorrerInorden() {
        return   this.getHijoIzquierdo().recorrerInorden() + valor + " - " + this.getHijoDerecho().recorrerInorden();
    }

    public String recorrerPostorden() {
        return this.getHijoIzquierdo().recorrerPostorden() + this.getHijoDerecho().recorrerPostorden() + valor + " - ";
    }
```

