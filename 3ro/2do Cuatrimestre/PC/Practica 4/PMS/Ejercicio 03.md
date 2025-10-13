## En un examen final hay N alumnos y P profesores. Cada alumno resuelve su examen, lo entrega y espera a que alguno de los profesores lo corrija y le indique la nota. Los profesores corrigen los exámenes respetando el orden en que los alumnos van entregando.
> Nota: maximizar la concurrencia; no generar demora innecesaria; todos los procesos deben terminar su ejecución

### A - Considerando que P=1.
```c
process Alumno[i := 0 to N-1]{
    // resuelve el examen
    Buffer!(i, examen);
    int nota;
    Profesor?(nota);
}
process Buffer{
    examen e;
    int id;
    cola cola;
    bool fin := true;
    do
    [] fin; Alumno[*](id, e)? ->
        cola.push(id, e); // Guarda en la cola el id y el examen en la misma posicion
    [] (fin) and (!cola.empty()); Profesor?ready() ->
        Profesor!send(cola.pop()); // Desencola el id y el examen
    [] fin; Profesor?finalizar() ->
        fin := false;
    od
}
process Profesor{
    int id; examen e;
    for (0 to N-1){
        Buffer!ready()
        Buffer?send(id, e);
        // Corrige el examen y obtiene la nota
        Alumno[id]!(nota);
    }
    Buffer!fianlizar();
}
```

### B - Considerando que P>1.
```c
process Alumno[i := 0 to N-1]{
    // resuelve el examen
    Buffer!(i, examen);
    int nota;
    Profesor?(nota);
}
process Buffer{
    examen e;
    int id;
    cola cola;
    int cant := 0;
    do
    [] cant < P; Alumno[*](id, e)? ->
        cola.push(id, e); // Guarda en la cola el id y el examen en la misma posicion
    [] (cant < P) and (!cola.empty()); Profesor[*]?ready(id) ->
        Profesor[id]!send(cola.pop()); // Desencola el id y el examen
    [] cant < P; Profesor[*]?finalizar() ->
        cant++;
    od
}
process Profesor[i := 0 to P-1]{
    int id; examen e; int cant:= 0;
    while(cant < N){
        Buffer!ready()
        if
        [] Buffer?send(id, e) ->
            // Corrige el examen y obtiene la nota
            Alumno[id]!(nota);
            for(j := 0 to P){
                if (j == P){ continue; }
                else { Profesor[j]!corregi(); }
            }
        [] Profesor[*]?corregi() ->
            cant++;
        fi  
    }
    Buffer!fianlizar();
}
```

### C - Ídem B pero considerando que los alumnos no comienzan a realizar su examen hasta que todos hayan llegado al aula.
```c
process Aula{
    for(0 to N-1){
        Alumno?();
    }
    for(j := 0 to N-1){
        Alumno!();
    }
}
process Alumno[i := 0 to N-1]{
    Aula!();
    Aula?();
    // resuelve el examen
    Buffer!(i, examen);
    int nota;
    Profesor?(nota);
}
process Buffer{
    examen e;
    int id;
    cola cola;
    int cant := 0;
    do
    [] cant < P; Alumno[*](id, e)? ->
        cola.push(id, e); // Guarda en la cola el id y el examen en la misma posicion
    [] (cant < P) and (!cola.empty()); Profesor[*]?ready(id) ->
        Profesor[id]!send(cola.pop()); // Desencola el id y el examen
    [] cant < P; Profesor[*]?finalizar() ->
        cant++;
    od
}
process Profesor[i := 0 to P-1]{
    int id; examen e; int cant:= 0;
    while(cant < N){
        Buffer!ready()
        if
        [] Buffer?send(id, e) ->
            // Corrige el examen y obtiene la nota
            Alumno[id]!(nota);
            for(j := 0 to P){
                if (j == P){ continue; }
                else { Profesor[j]!corregi(); }
            }
        [] Profesor[*]?corregi() ->
            cant++;
        fi  
    }
    Buffer!fianlizar();
}
```