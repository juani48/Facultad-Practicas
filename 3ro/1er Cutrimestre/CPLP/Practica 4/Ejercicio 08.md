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

## B - Indique el rango de instrucciones que representa el alcance de las variables i, h y mipuntero.

## C - Indique si el programa anterior presenta un error al intentar escribir el valor de h. Justifique.

## D - Indique si el programa anterior presenta un error al intentar asignar a i la resta de h con mipuntero. Justifique.

## E - Determine si existe otra entidad que necesite ligar los atributos de alcance y tiempo de vida para justificar las respuestas anteriores. En ese caso indique cuál es la entidad y especifique su tiempo de vida y alcance.

## F - Especifique el tipo de variable de acuerdo a la ligadura con el l-valor de las variables que encontró en el ejercicio.

