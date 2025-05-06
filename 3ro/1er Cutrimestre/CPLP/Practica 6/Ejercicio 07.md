## Realice la pila de ejecución del siguiente programa: Siguiendo la cadena estática y siguiendo la cadena dinámica
```pascal
Procedure Uno;
    y, z: integer;
    r1:array[1..6] of integer;
    r2:array[1..5] of integer;
    Procedure Dos(nombre x, t:integer; var io:integer; valor-resultado y:integer);
        Procedure Dos(nombre t1:integer);
            Procedure Tres;
            begin
                y:= y + 1;
                z:= z + 1;
            end;
        begin
            t1:= t1 + 1;
            t:= t + 1;
            Tres;
            t1:= t1 + 2;
            t:= t + 2;
        end;
    begin
        x:= x + 1;
        t:= t + 1;
        io:= io + 1;
        x:= x + 2;
        if z=2 then Dos(t);
    end;
begin
    for y:= 1 to 6 do r1(y):= 2;
    for y:= 1 to 5 do r2(y):= 1;
    z:= 2;
    y:= 1;
    Dos(r1(y + r2(y)), r2(z), y, z);
    for y:= 1 to 6 do write (r1(y));
    for y:= 1 to 5 do write (r2(y));
end.
```
### Estatica
|ID|R.A.|
|--|----|
|1| **Uno** |
|| PR |
|| y = 1..6, 1..5, 1, (io+1)=2, 1..6, 1..5 |
|| z = 2, (z+1)=3, (y)3 |
|| r1[1] = 2 |
|| r1[2] = 2 |
|| r1[3] = 2, (x+1)=3 |
|| r1[4] = 2, (x+2)=4 |
|| r1[5] = 2 |
|| r1[6] = 2 |
|| r2[1] = 1 |
|| r2[2] = 1, (t+1)=2, (t1+1)=3, (t+1)=4, (t1+2)=6, (t+2)=8 |
|| r2[3] = 1 |
|| r2[4] = 1 |
|| r2[5] = 1 |
|| Dos() |
|2| **Dos** / |
|| PR |
|| LE = 1 |
|| LD = 1 |
|| x\^ r1[3], (r1[ y+r2[y] ])=r1[4] |
|| t\^ r2[2] |
|| io\y |
|| y\z = 2, (y+1)=3 |
|| Dos() |
|| VR |
|3| **Dos** / |
|| PR |
|| LE = 2 |
|| LD = 2 |
|| t1\^ r2[2] |
|| Tres() | 
|4| **Tres** / |
|| PR |
|| LE = 3 |
|| LD = 3 |
|| VR |
