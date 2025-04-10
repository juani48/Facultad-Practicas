## Sea el siguiente ejercicio escrito en Pascal
```pascal
01. Program Uno;
02. type tpuntero= ^integer;
03. var mipuntero: tpuntero;
04. var i:integer;
05. var h:integer;
06. Begin
07. i:=3;
08. mipuntero:=nil;
09. new(mipuntero);
10. mipunterno^:=i;
11.​ h:= mipuntero^+i;
12. dispose(mipuntero);
13. write(h);
14. i:= h- mipuntero;
15. End.
```
## A - Indique el rango de instrucciones que representa el tiempo de vida de las variables i, h y mipuntero.

- i: 1...15
- h: 1...15
- mipntero: 1...15

## B - Indique el rango de instrucciones que representa el alcance de las variables i, h y mipuntero.

- i: 4...15
- h: 5...15
- mipntero: 3...15

## C - Indique si el programa anterior presenta un error al intentar escribir el valor de h. Justifique.

No, dado que se la funcion 'write()' permite la impesion de variables de tipo numerico.

## D - Indique si el programa anterior presenta un error al intentar asignar a i la resta de h con mipuntero. Justifique.

Si, ya que la resta entre 'h' y 'mipuntero' es incorrecta, dado que 'mipuntero' almacena una direccion en memoria y esta es una cadena hexadecimal y no es posibles realizar una resta estre una variable de tipo entera (h) y un hexadecimal.

## E - Determine si existe otra entidad que necesite ligar los atributos de alcance y tiempo de vida para justificar las respuestas anteriores. En ese caso indique cuál es la entidad y especifique su tiempo de vida y alcance.

No es necesario.

## F - Especifique el tipo de variable de acuerdo a la ligadura con el l-valor de las variables que encontró en el ejercicio.

'h', 'i' y 'mipunero' son de tipo automaticas, 'mipuntero^' es dinamica.