## Se debe simular una maratón con C corredores donde en la llegada hay UNA máquina expendedoras de agua con capacidad para 20 botellas. Además, existe un repositor encargado de reponer las botellas de la máquina. Cuando los C corredores han llegado al inicio comienza la carrera. Cuando un corredor termina la carrera se dirigen a la máquina expendedora, espera su turno (respetando el orden de llegada), saca una botella y se retira. Si encuentra la máquina sin botellas, le avisa al repositor para que cargue nuevamente la máquina con 20 botellas; spera a que se haga la recarga; saca una botella y se retira. 

>Nota: mientras se reponen las botellas se debe permitir que otros corredores se encolen.

```c
process Corredor[i := 0 to C]{
    Carrera.iniciarCarrera();
    // Corren
    Dispenser.hacerFila();
    Dispense.extraer();
}
process Repositor{
    while(true){
        Dispense.reponer(); 
    }
}
monitor Carrera{
    cond cola;
    int espera := 0;

    procedure iniciarCarrera(){
        espera++;
        if (espera < C){
            wait(cola);
        }
        else{
            signal_all(cola);
        }
    }
} 
monitor Dispenser{
    int botellas := 20; bool libre := false;
    cond cola; int esperando := 0;
    cond corredor;
    cond respositor;

    procedure reponer(){
        if (botellas == 0){
            botellas := 20;
            sigal(corredor);
        }
        wait(repositor);
    }

    procedure hacerFila(){
        if (!libre){
            esperando++;
            wait(cola);
        }
        else{
            libre := false;
        }
    }
    procedure extraer(){
        if (botellas == 0){
            signal(repositor);
            wait(corredor);
        }
        botellas--;
        if (esperando > 0){
            signal(cola);
        }
        else {
            libre := true;
        }
    }
}
```


