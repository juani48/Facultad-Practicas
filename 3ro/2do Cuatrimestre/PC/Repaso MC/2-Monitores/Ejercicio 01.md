## Resolver el siguiente problema. 
### En una elección estudiantil, se utiliza una máquina para voto electrónico. Existen N Personas que votan y una Autoridad de Mesa que les da acceso a la máquina de acuerdo con el orden de llegada, aunque ancianos y embarazadas tienen prioridad sobre el resto. La máquina de voto sólo puede ser usada por una persona a la vez. 
> Nota: la función Votar() permite usar la máquina.

```c
monitor AutoridadMesa {
    cond privados[N];
    cola cola_normal, cola_prioridad;
    int esperando := 0;
    bool libre := true;

    procedure Votar(int id, bool prioridad){
        if (!libre){
            esperando++;
            if (prioridad){
                cola_prioridad.push(id);
            }
            else {
                cola_normal.push(id)
            }
            wait(privados[id]);
        }
        else {
            libre := false;
        }
    }

    procedure Liberar(){
        if (esperando > 0){
            esperando--;
            int sig := 0;
            if (!cola_prioridad.empty()){
                sig := cola_prioridad.pop();
            }
            else {
                sig := cola_normal.pop();
            }
            signal(privados[sig]);
        }
        else {
            libre := true;
        }
    }
}

process Personas[i := 0 to N-1]{
    bool prioridad; // El procesos conoce si es anciono o embarazada
    AutoridadMesa.Votar(i, prioridad);
    Votar(); // Permite usar la maquina
    AutoridadMesa.LIberar();
}
```

### Correccion
- Cambie las colas por variables condicion y elimine las variables condicion privadas
```c
monitor AutoridadMesa {
    cond cola_normal, cola_prioridad;
    int esperando_normal := 0, esperando_prioridad := 0;
    bool libre := true;

    procedure Votar(bool prioridad){
        if (!libre){
            if (prioridad){
                esperando_prioridad++;
                wait(cola_prioridad);
            }
            else {
                esperando_normal++;
                wait(cola_normal);
            }
        }
        else {
            libre := false;
        }
    }

    procedure Liberar(){
        if (esperando_prioridad > 0){
            esperando_prioridad--;
            signal(cola_prioridad);
        }
        else if (esperando_normal > 0){
            signal(cola_normal);
        }
        else {
            libre := true;
        }
    }
}

process Personas[i := 0 to N-1]{
    bool prioridad; // El procesos conoce si es anciono o embarazada
    AutoridadMesa.Votar(prioridad);
    Votar(); // Permite usar la maquina
    AutoridadMesa.LIberar();
}
```