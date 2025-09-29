## Existen N personas que deben fotocopiar un documento. La fotocopiadora sólo puede ser usada por una persona a la vez. Analice el problema y defina qué procesos, recursos y monitores serán necesarios/convenientes, además de las posibles sincronizaciones requeridas para resolver el problema. Luego, resuelva considerando las siguientes situaciones:

### A - Implemente una solución suponiendo no importa el orden de uso. Existe una función `Fotocopiar()` que simula el uso de la fotocopiadora.
```c
Monitor Impresora{
    procedure imprimir(){
        Fotocopiar();
    }
}
process Persona[i = 1 to N]{
    Impresora.imprimir();
}
```

### B - Modifique la solución de (a) para el caso en que se deba respetar el orden de llegada.
```c
Monitor Impresora{
    int espera = 0; 
    int sem = 1;
    cond cola;

    procedure imprimir(){
        if (sem = 0){
            espera++;
            wait(cola);
        }
        else {
            sem--;
        }
    }
    procedure liberar(){
        if (espera = 0){
            sem++;
        }
        else {
            espera--;
            signal(cola);
        }
    }
}
process Persona[i = 1 to N]{
    Impresora.imprimir();
    Fotocopiar();
    Impresora.liberar();
}
```

### C - Modifique la solución de (b) para el caso en que se deba dar prioridad de acuerdo con la edad de cada persona (cuando la fotocopiadora está libre la debe usar la persona de mayor edad entre las que estén esperando para usarla).
```c
Monitor Impresora{
    bool libre = true;
    cola cola;
    cond privado[N];

    procedure imprimir(id: int, edad: int){
        while(!libre){
            cola.push_ordenado(id, edad);
            wait(privado[id]);
        }
        libre = false;
    }
    procedure liberar(){
        libre = true;
        if (!cola.empty()){
            int id = pop(cola);
            signal(privado[id]);
        }
    }
}
process Persona[i = 0 to N-1]{
    // El proceso conoce su edad
    Impresora.imprimir(i, edad);
    Fotocopiar();
    Impresora.liberar();
}
```

### D - Modifique la solución de (a) para el caso en que se deba respetar estrictamente el orden dado por el identificador del proceso (la persona X no puede usar la fotocopiadora hasta que no haya terminado de usarla la persona X-1).
```c
Monitor Impresora{
    int act = 0;
    cond privado[N];

    procedure imprimir(id: int){
        if (act <> id){
            wait(privado[id]);
        }
        if (id > N){
            cant++;
            signal(privado[id+1]);
        }
        Fotocopiar();
    }
}
process Persona[i = 0 to N-1]{
    Impresora.imprimir(i);
}
```

### E - Modifique la solución de (b) para el caso en que además haya un Empleado que le indica a cada persona cuando debe usar la fotocopiadora.


### F - Modificar la solución (e) para el caso en que sean 10 fotocopiadoras. El empleado le indica a la persona cuál fotocopiadora usar y cuándo hacerlo.
```c
int usar[N] = (N -1);
Monitor Empleado{
    cond cola;
    cola impresoras = (10 push(pos)) // 10 push de valores: 0..9

    procedure imprimir(id: int){
        while(impresoras.empty()){
            wait(cola);
        }
        usar[id] = impresoras.pop();
    }
    procedure liberar(pos: int){
        impresoras.push(pos);
        signal(cola);
    }
}
process Persona[i = 1 to N]{
    Impresora.imprimir();
    Fotocopiar(usar[i]);
    Impresora.liberar(usar[i]);
}
```