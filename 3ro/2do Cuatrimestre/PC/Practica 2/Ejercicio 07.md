## Suponga que se tiene un curso con 50 alumnos. Cada alumno debe realizar una tarea y existen 10 enunciados posibles. Una vez que todos los alumnos eligieron su tarea, comienzan a realizarla. Cada vez que un alumno termina su tarea, le avisa al profesor y se queda esperando el puntaje del grupo (depende de todos aquellos que comparten el mismo enunciado). Cuando un grupo terminó, el profesor les otorga un puntaje que representa el orden en que se terminó esa tarea de las 10 posibles.

> Para elegir la tarea suponga que existe una función elegir que le asigna una tarea a un alumno (esta función asignará 10 tareas diferentes entre 50 alumnos, es decir, que 5 alumnos tendrán la tarea 1, otros 5 la tarea 2 y así sucesivamente para las 10 tareas).

```c
int a := 50
sem alumnos[a] := (a 0), c_mutex := 1; grupo[10] := (10 0);
int tarea[a] := (a 0), nota[10] := (N 0);
cola C;

process Alumno[i := 0 to a-1]{
    P(alumnos[i]); // la funcion elegir() habilita a los alumnos
    realizar(tarea[i]); // realizar() realiza la tarea
    // Termina la tarea

    P(c_mutex); 
    push(C, tarea[i]); // Se encola
    V(c_mutex);

    V(p_mutex); // Avisa
    P(grupo[tarea[i]]); // Espera al grupo
    int _nota := nota[tarea[i]];
}
prcess Profesor{
    int _grupos[10] := (10 0);
    int _nota := 10;
    elegir(); // Pone en uno los semaforos de los alumnos y le otorga su tarea

    for (int i := 0; i < a; i++) {
        P(p_mutex); // Espera a que todos los alumnos le avisen que terminaron
        
        P(c_mutex);
        int _tarea := pop(C); // Desencola el grupo que termino una tarea
        V(c_mutex);

        _grupos[_tarea]++; // Anota que grupo termino una tarea
        
        if (_grupos[_tarea] == 10){
            nota[_tarea] := _nota; // Les pone la nota
            _nota--;
            for (int j := 0; j < 10; j++){
                V(grupos[_tarea]); // Avisa a los alumnos de ese grupo que tienen su nota
            }
        }
    }
}

```
