## A - Tome una de las variables de la línea 3 del siguiente código e indique y defina cuales son sus atributos:
```pascal
01.​ Procedure Practica4();
02.​ var
03.​ a,i:integer
04.​ p:puntero
05.​ Begin
06.​ a:=0;
07.​ new(p);
08.​ p:= ^i
09.​ for i:=1 to 9 do
10.​ a:=a+i;
11.​ end;
12.​ ...
13.​ p:= ^a;
14.​ ...
15.​ dispose(p);
16.​ end;
```

Variable 'a' (los atributos de una variable son un 5-tupla = {nombre, alcance, tipo, l-value, r-value}) :
- **Nombre:** 'a'
- **Alcance:** Local
- **Tipo:** Tipo predefinido, integer. Ligadura estatica y explicita.
- **L-value:** Locacion de memoria estatica.
- **R-value:** Valor numerico.

## B - Compare los atributos de la variable del punto A con los atributos de la variable de la línea 4. Que dato contiene esta variable?

La varaible 'p' contiene en su R-value el L-value de la variable 'a'