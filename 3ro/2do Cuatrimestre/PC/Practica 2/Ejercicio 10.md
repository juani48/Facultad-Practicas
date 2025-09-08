## Una cerealera van T camiones a descargarse trigo y M camiones a descargar maíz. Sólo hay lugar para que 7 camiones a la vez descarguen, pero no pueden ser más de 5 del mismo tipo de cereal.

### A - Implemente una solución que use un proceso extra que actúe como coordinador entre los camiones. El coordinador debe atender a los camiones según el orden de llegada. Además, debe retirarse cuando todos los camiones han descargado.
```c
cola C; sem c_mutex := 1;
sem l_mutex := 1; cola lugares := (7 {0, ... 7}); // 7 push con los lugares 
sem lugar := 7, m_total := 5, t_total := 5;
int total := T + M;
sem priv[total] := (total 0);
process Coordinador{    
    for (int i := 0; i < total; i++){
        P(lugar);

        P(c_mutex); id := pop(C) V(c_mutex);

        if (id < T){
            // Es de trigo
            P(t_total);
            V(priv[id]);
        }
        else{
            // Es de maiz
            P(m_total);
            V(priv[id]);
        }
    }
}
process Trigo[i = 0 to T-1]{
    P(c_mutex); push(C, i); V(c_mutex);

    P(priv[i]);
    P(l_mutex); int _lugar := pop(lugares); V(l_mutex);
    // Descarga
    P(l_mutex); push(lugares, _lugar); V(l_mutex);

    V(t_total);
    V(lugar);

}
process Maiz[i = T to total]{
    P(c_mutex); push(C, i); V(c_mutex);

    P(priv[i]);
    P(l_mutex); int _lugar := pop(lugares); V(l_mutex);
    // Descarga
    P(l_mutex); push(lugares, _lugar); V(l_mutex);

    V(m_total);
    V(lugar);
}
```

### B - Implemente una solución que no use procesos adicionales (sólo camiones). No importa el orden de llegada para descargar. Nota: maximice la concurrencia.
```c
cola C := (7 {0, ... , 7}) // 7 push con los lugares
sem trigo := 5, maiz := 5; lugar := 7;
sem c_mutex := 1;

process Trigo[i = 1 to T]{
    int _lugar := 0;
    P(lugar);
    P(trigo);

    P(c_mutex); _lugar := pop(C); V(c_mutex);
    // Descarga en el lugar
    P(c_mutex); push(C, _lugar); V(c_mutex);

    V(trigo);
    V(lugar);
}
process Maiz[i = 1 to M]{
    int _lugar := 0;
    P(lugar);
    P(maiz);

    P(c_mutex); _lugar := pop(C); V(c_mutex);
    // Descarga en el lugar
    P(c_mutex); push(C, _lugar); V(c_mutex);

    V(maiz);
    V(lugar);
}
```