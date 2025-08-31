## En cada ítem debe realizar una solución concurrente de grano grueso (utilizando <> y/o <await B; S>) para el siguiente problema, teniendo en cuenta las condiciones indicadas en el item. Existen N personas que deben imprimir un trabajo cada una.

### A - Implemente una solución suponiendo que existe una única impresora compartida por todas las personas, y las mismas la deben usar de a una persona a la vez, sin importar el orden. Existe una función Imprimir(documento) llamada por la persona que simula el uso de la impresora. Sólo se deben usar los procesos que representan a las Personas.

```
bool ocupada := false; 
process Persona[i=1 to N]{
    string documento;
    <await (!ocupada) ocupada := true>
    Imprimir(documento);
    ocupado := false
}
```

### B - Modifique la solución de (a) para el caso en que se deba respetar el orden de llegada.
```
int numero = 1; int turno := 1
process Persona[i=1 to N]{
    string documento; int mi_turno;
    <mi_turno := numero; numero++;>
    <await (turno == mi_turno)>
    Imprimir(documento);
    <turno++;>
}
```

### C - Modifique la solución de (a) para el caso en que se deba respetar el orden dado por el identificador del proceso (cuando está libre la impresora, de los procesos que han solicitado su uso la debe usar el que tenga menor identificador).
```
int turno := 1
process Persona[i=1 to N]{
    string documento;
    <await (turno == i)>
    Imprimir(documento);
    <turno++;>
}
```

### D - Modifique la solución de (b) para el caso en que además hay un proceso Coordinador que le indica a cada persona que es su turno de usar la impresora.
```
bool personas[N];
process Persona[i=0 to N-1]{
    string documento; int mi_turno;
    <await (personas[i])>
    Imprimir(documento);
    <personas[i] := false>
}

process Cordinador{
    int actual := 0;
    while (actual < N){
        <personas[actual] := true>
        <await !(personas[actual])>
        actual++;
    }
}
```