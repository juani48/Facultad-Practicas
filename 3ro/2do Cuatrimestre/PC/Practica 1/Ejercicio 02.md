## Realice una solución concurrente de grano grueso (utilizando <> y/o <await B; S>) para el  siguiente problema. Dado un número N verifique cuántas veces aparece ese número en un arreglo de longitud M. Escriba las pre-condiciones que considere necesarias

Pre-condicones:
- Un solo proceso puede acceder a la vez a la variable `array` y a la variable `total`.
- Habra tantos procesos como posiciones en el arraglo
- El valor `N` debe ser valido (un numero entero)
- El arreglo debe estar definido o no ser nulo
- El valor `M` debe ser mayot a `0`
```c
int total := 0; 
int array[M];
int value := N
process Calulador[i=0 to M-1]{
    bool ok := false;
    <ok := array[i] == value>
    if ok then 
        <total:= total + 1>
}
```