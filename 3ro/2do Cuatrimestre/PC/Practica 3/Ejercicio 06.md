## Existe una comisión de 50 alumnos que deben realizar tareas de a pares, las cuales son corregidas por un JTP. Cuando los alumnos llegan, forman una fila. Una vez que están todos en fila, el JTP les asigna un número de grupo a cada uno. Para ello, suponga que existe una función `AsignarNroGrupo()` que retorna un número “aleatorio” del 1 al 25. Cuando un alumno ha recibido su número de grupo, comienza a realizar su tarea. Al terminarla, el alumno le avisa al JTP y espera por su nota. Cuando los dos alumnos del grupo completaron la tarea, el JTP les asigna un puntaje (el primer grupo en terminar tendrá como nota 25, el segundo 24, y así sucesivamente hasta el último que tendrá nota 1). 
>Nota: el JTP no guarda el número de grupo que le asigna a cada alumno.

```c
int A := 50;
int grupos[A];
process Alumno[i:= 0 to A-1]{
    JTP.asignarGrupo(i);
    // Realizar trabajo
    JTP.entregarTrabajo(grupos[i]);
}

monitor JTP{
    cond cola;
    int nota := A / 2;
    int esperando := 0;
    cond privados[(A / 2) + 1]; 
    int trabajo[(A / 2) + 1] = ((A / 2) + 1 0)

    procedure asignarGrupo(id: int){
        esperando++;
        if (esperando < A){
            wait(cola);
        }
        else {
            signal_all(cola);
        }
        grupos[id] := AsignarNroGrupo();
    }

    procedure entregarTrabajo(num_grupo: int){
        if (trabajo[num_grupo] == 0){
            trabajo[num_grupo] := 1;
            wait(privados[num_grupo]);
        }
        else{
            trabajo[num_grupo] := nota;
            nota--;
            signal(privados[num_grupo]);
        }
    }
}    
```