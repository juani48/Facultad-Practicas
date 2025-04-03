## Sean los siguientes ejemplos de programas. Analice y diga qué tipo de error se produce (Semántico o Sintáctico) y en qué momento se detectan dichos errores (Compilación o Ejecución).

### Pascal
```pascal
Program P
    var 5: integer;
    var a: char;
Begin
    for i:= 5 to 10 do begin​
        write(a);​
        a=a+1;
    end;
End.
```
- Errores semanticos:
  - La varaibles "i" no fue previamente definida.
  - La varaibles "a" es de tipo char no integer.
- Erroes sintacticos:
  - El nombre de una variable no puede empezar con numero (5).
  - Simbolo incorrecto  de asignacion (a = a + 1).

### Java
```java
public String tabla(int numero, arrayList<Boolean> listado) {
    String result = null;
    for(i = 1; i < 11; i--) {
        result += numero + "x" + i + "=" + (i*numero) + "\n";
        listado.get(listado.size()-1)=(BOOLEAN) numero>i;
    }
    return true;
}
```
- Errores semanticos:
  - La varaible "i" no es declarada.
  - La operacion "result += ..." es invalida, result fue declarado igual a null.
  - El tipo de valor de retorno no es el mismo que el que se retorna.
- Erroes sintacticos:
  - El tipo arrayList<> debe empezar con mayuscula.
  - El casteo (BOOLEAN) debe ser (boolean).
  - El metodo ".get()" no permite asignaciones.
  - La declaracion del tipo que contiene ArrayList debe ser "boolean".
- Errores logicos:
  - El "for" sera un bucle infinito.

### C
```c
# include <stdio.h>
    int suma; /* Esta es una variable global */
    int main(){ 
        int indice;
        encabezado;
        for (indice = 1 ; indice <= 7 ; indice ++)
            cuadrado (indice);
        final(); Llama a la función final */
        return 0;
    }
    cuadrado (numero)
    int numero;
    { 
        int numero_cuadrado;
        numero_cuadrado == numero * numero;
        suma += numero_cuadrado;
        printf("El cuadrado de %d es %d\n",
        numero, numero_cuadrado);
}
```
- Errores semanticos:
  - La funcion final no se ecuentra declarada.
  - La funcion cuadrado no posee cuerpo.
  - El == no asigna, compara.
  - La variable numero_cuadrado no posee valor.
- Erroes sintacticos:
  - La varaible encabezado no tiene definido el tipo.
  - "Llama a la funcion final */" no es un comentario correcto.
  - El tipo de parametro de la funcion cuadrado no esta definido.
  - La sentencia "numero, numero_cuadrado);" debe estar en la misma linea del printf.

### Python
```

```


