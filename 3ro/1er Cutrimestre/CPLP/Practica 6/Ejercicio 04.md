## Sea el siguiente programa escrito en Pascal-like
```pascal
Procedure Main;
    var j, m, i: integer;
    Procedure Recibe (x:integer; y:integer);
    begin
        m:= m + 1 + y;
        x:=i + x + j;
        y:=m - 1;
        write (x, y, i, j, m);
    end;
    Procedure Dos;
    var m:integer;
    begin
        m:= 5;
        Recibe(i, j);
        write (i, j, m);
    end;
begin
    m:= 2;
    i:=1; j:=3;
    Dos;
    write (i, j, m);
end.
```

### A - Arme el árbol de anidamiento sintáctico y el registro de activación de cada una de las unidades.
### B - Decir qué imprime el programa suponiendo que para todas las variables que se pasan el pasaje de parámetros es por: (Deberá hacer la pila estática y dinámica para cada caso).
1. Referencia.
2. Valor.
3. Valor Resultado.
4. Nombre.
5. Resultado.

#### 1 - Estatia
| ID | R.A. |
|----|------|
|1| **MAIN** |
|| j = 3, (m-1), 1 |
|| m = 2, (m+1+y)=6 |
|| i = 1, (i+x+j)=5 |
|| Recibe |
|| Dos |
|| VR |
|2| **Dos** |
|| PR |
|| LE = 1 |
|| LD = 1 |
|| m = 5 |
|| VR |
|3| **Recibe** |
|| PR |
|| LE = 1 |
|| LD = 2 |
|| x\i |
|| y\j |
|| VR |

Recibe -> write(5, 1, 5, 1, 6)

Dos -> write(5, 1, 5)

MAIN -> write(5, 1, 6)

#### 1 - Dinamica
| ID | R.A. |
|----|------|
|1| **MAIN** |
|| j = 3, ([m]9,-1)=8 |
|| m = 2 |
|| i = 1, (i+x+j)=5 |
|| Recibe |
|| Dos |
|| VR |
|2| **Dos** |
|| PR |
|| LE = 1 |
|| LD = 1 |
|| m = 5, (m+1+y)=9 |
|| VR |
|3| **Recibe** |
|| PR |
|| LE = 1 |
|| LD = 2 |
|| x\i |
|| y\j |
|| VR |

Recibe -> write(5, 8, 5, 8, 9)

Dos -> write(5, 8, 9)

MAIN -> write(5, 8, 2)

#### 2 - Estatica
| ID | R.A. |
|----|------|
|1| **MAIN** |
|| j = 3, |
|| m = 2 |
|| i = 1, |
|| Recibe |
|| Dos |
|| VR |
|2| **Dos** |
|| PR |
|| LE = 1 |
|| LD = 1 |
|| m = 5, (m+1+y)=9 |
|| VR |
|3| **Recibe** |
|| PR |
|| LE = 1 |
|| LD = 2 |
|| x = 1, (i+x+j)=5 |
|| y = 3, (m-1)=1 |
|| VR |

Recibe -> write(5, 1, 1, 3, 2)

Dos -> write(1, 3, 5)

MAIN -> write(1, 3, 2)

#### 2 - Dinamica
| ID | R.A. |
|----|------|
|1| **MAIN** |
|| j = 3, |
|| m = 2 |
|| i = 1, |
|| Recibe |
|| Dos |
|| VR |
|2| **Dos** |
|| PR |
|| LE = 1 |
|| LD = 1 |
|| m = 5,(m+1+y)=9 |
|| VR |
|| PR |
|| LE = 1 |
|| LD = 2 |
|| x = 1, (i+x+j)=5 |
|| y = 3, (m-1)=8 |
|| VR |

Recibe -> write(5, 8, 1, 3, 9)

Dos -> write(1, 3, 9)

MAIN -> write(1, 3, 2)