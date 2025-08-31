## Desarrolle una solución de grano fino usando sólo variables compartidas (no se puede usar las sentencias await ni funciones especiales como TS o FA). Resuelva el problema de acceso a sección crítica usando un proceso coordinador. En este caso, cuando un proceso SC[i] quiere entrar a su sección crítica le avisa al coordinador, y espera a que éste le dé permiso. Al terminar de ejecutar su sección crítica, el proceso SC[i] le avisa al coordinador. 

```
bool acceder[N] = ([N] false); bool conceder[N] = ([N] false);

process Proceso[i=0 to N-1]{
    while (true){
        acceder[i] := true;
        while(conceder[i] == false) skip;
        acceder[i] := false;
        // SC
        conceder[i]:= false
    }
}
process Coordinador{
    while (true){
        for [i = 0 to N-1]
            if (acceder[i]) then
                conceder[i] := true;
                while (conceder[i]) skip;
    }
}
```
