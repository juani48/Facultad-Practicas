```pascal
Program Main
    var 
        a: array[1..10] of integer;
        x,y,z:integer
    Procedure A ()
        var 
            y,t: integer;
        begin
            a(1):= a(1)+1;z:=z+1;
            t:=1; y:=2;
            B(); a(y):=a(y)+3; y:=y+1;
            if z=11 then 
            begin
                a(z-1):=a(z-2)+3;
                z:=z-4;
                a(z-y):=a(z) – a(y) + 5;
            end;
        end;
    Function t():integer
    begin
        y:=y+1; z:=z-6;
        return(y+x);
    end;
    Procedure B()
    var 
        d:integer;
        Procedure I ()
            begin
                x:=0; x:=x+6;
            end;
    begin
        x:=x+t; d:=0;
        while x>d do begin
            I(); x:=x-1;
            d:=d + 2;
        end;
    end;
begin
    for x:=1 To 10 do a(x):=x;
    x:=5; y:=1; z:=10;
    A();
    for x:=1 To 10 do write(a(x),x);
end.
```


