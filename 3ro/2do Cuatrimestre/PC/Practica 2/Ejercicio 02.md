## Un sistema de control cuenta con 4 procesos que realizan chequeos en forma colaborativa. Para ello, reciben el historial de fallos del día anterior (por simplicidad, de tamaño N). De cada fallo, se conoce su número de identificación (ID) y su nivel de gravedad (0=bajo, 1=intermedio, 2=alto, 3=crítico). Resuelva considerando las siguientes situaciones:

### A - Se debe imprimir en pantalla los ID de todos los errores críticos (no importa el orden).
```c
int fallo[N];

process Proceso[int i=0 to 3]{
    int pos := i;
    while(pos <= N){
        if (fallo[pos] == 3){ print(pos) }
        pos += 4
    }
}
```

### B - Se debe calcular la cantidad de fallos por nivel de gravedad, debiendo quedar los resultados en un vector global.
```c
int fallo[N];
int libre[4] = (4 sem s := 1); 
int resultado[4] = (N 0);

process Proceso[int i=0 to 3]{
    int pos := i;
    int local[4] = (N 0);
    while(pos <= N){
        local[fallo[pos]] += 1
        pos += 4
    }
    for int j = 0; j < 3; j++{
        P(libre[j]);
        resultado[j] += local[j];
        V(libre[j])
    }
}
```

### C - Cada proceso debe ocuparse de contar los fallos de un nivel de gravedad determinado.
```c
int fallo[N];
int libre[N] = (N sem s := 1); 
int resultado[4] = (N 0);

process Proceso[int i=0 to 3]{
    for int j = 0; j < 3; j++{
        P(libre[j]);
        if (fallo[j] == i) { resultado[i] += 1; }
        V(libre[j]);
    }
}
```