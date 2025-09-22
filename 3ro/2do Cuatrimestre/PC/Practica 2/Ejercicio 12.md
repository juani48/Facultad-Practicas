## Simular la atención en una Terminal de Micros que posee 3 puestos para hisopar a 150 pasajeros. En cada puesto hay una Enfermera que atiende a los pasajeros de acuerdo con el orden de llegada al mismo. Cuando llega un pasajero se dirige al Recepcionista, quien le indica qué puesto es el que tiene menos gente esperando. Luego se dirige al puesto y espera a que la enfermera correspondiente lo llame para hisoparlo. Finalmente, se retira.
> Suponga que existe una función Hisopar() que simula la atención del pasajero por parte de la enfermera correspondiente.

### A - Implemente una solución considerando los procesos Pasajeros, Enfermera y Recepcionista
```c
int P := 150, E := 3;
cola fila[E]; sem f_mutex[E] := (E 1); // Fials por enfermera
sem priv[P] := (P 0); int puesto[P] := (P 0); // Personas
cola C; sem c_mutex := 1, r_mutex := 0;// Fila recepcion

process Pasajero[i = 0 to P-1]{
    P(c_mutex); push(C, i); V(c_mutex);
    
    V(r_mutex); // Avisa al recepcionista
    P(priv[i]); // Espera a que le indiquen la fila

    int aux := puesto[i]; 
    P(f_mutex[aux]); push(fila[aux], i); V(f_mutex[aux]); // Se encola en la fila

    P(priv[i]); // Espera a ser atendido
}
process Enfermera[i = 0 to E-1]{
    while(true){
        P(f_mutex[i]);
        if (not empty(fila[i])){
            int id := pop(fila[i]);
            V(f_mutex[i]);
            Hisopar();
            V(priv[id]);
        }
        else {
            V(f_mutex[i])
        }
    }
}
process Recepcionista{
    int cant[E] := (E 0)
    while(true){
        P(r_mutex)
        P(c_mutex); int id := pop(C); V(c_mutex);

        int min := E, pos := 0;
        for (int i := 0; i < E; i++){
            if (cant[i] > min){ min := cant[i]; pos := i;}
        }
        puesto[id] := pos;
        V(priv[id]);
    }
}
```

### B - Modifique la solución anterior para que sólo haya procesos Pasajeros y Enfermera, siendo los pasajeros quienes determinan por su cuenta qué puesto tiene menos personas esperando.
```c
int P := 150, E := 3;
cola fila[E]; sem f_mutex[E] := (E 1); // Fials por enfermera
sem priv[P] := (P 0); // Personas
cola C; sem c_mutex := 1;// Fila recepcion
int cant[E] := (E 0) // Cantida por fila
bool calculando := false; sem mutex := 1;

process Pasajero[i = 0 to P-1]{
    P(mutex);
    if (calculando){
        P(c_mutex); push(C, i); V(c_mutex);
        V(mutex);
        P(priv[i]);
    }
    calculando := true;
    V(mutex);
    
    // calcualr pos enfermera
    int min := E, pos := 0;
    for (int i := 0; i < E; i++){
        if (cant[i] > min){ min := cant[i]; pos := i;}
    }
    P(f_mutex[pos]); push(fila[pos], i); V(f_mutex[pos]); // Se encola en la fila
    
    P(c_mutex); P(mutex);
    if (not empty(C)){
        int id := pop(C);
        V(c_mutex);
        V(priv[id]);
    }
    else{
        calculando := false;
        V(mutex); V(c_mutex);
    }

    P(priv[i]); // Espera a ser atendido    
}
process Enfermera[i = 0 to E-1]{
    while(true){
        P(f_mutex[i]);
        if (not empty(fila[i])){
            int id := pop(fila[i]);
            V(f_mutex[i]);
            Hisopar();
            V(priv[id]);
        }
        else{
            V(f_mutex[i]);
        }
    }
}
```