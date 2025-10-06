## Implemente una solución para el siguiente problema. 
### Un sistema debe validar un conjunto de 10000 transacciones que se encuentran disponibles en una estructura de datos. Para ello, el sistema dispone de 7 workers, los cuales trabajan colaborativamente validando de a 1 transacción por vez cada uno. Cada  validación  puede  tomar  un  tiempo  diferente  y  para  realizarla  los  workers  disponen  de  la función  Validar(t),  la  cual  retorna  como  resultado  un  número  entero  entre  0  al  9.  Al  finalizar  el procesamiento, el último worker en terminar debe informar la cantidad de transacciones por cada resultado de la función de validación. 
> Nota: maximizar la concurrencia. 

```c
int res[10] := (10 0);
sem mutex[10]:= (10 1);
int transacciones[10_000]; // Estructura de datos con las 10.000 transacciones

int terminar := 0;
sem terminar_mutex := 1;

process Worker[i := 0 to W-1] {
    for (int j := (i*(10_000 / W)) to ((i+1) * (10_000 / W)) - 1){
        int val := Validar(transacciones[j]);
        P(mutex[val]);
        res[val]++;
        V(mutex[val]);
    }
    P(terminar_mutex);
    terminar++;
    if (terminar == W){
        for (int j := 0 to 9){
            print(res[j]);
        }
    }
    V(terminar_mutex);
}
```

### Correccion 
- Cambio la estrucutrua de datos, poroque puede pasar que un worker sea mas lento, por loque tardaria en completar toas sus posiciones del arreglo, con una cola, los workers mas rapidos podran acelerar el calculo de transacciones.
- Cambio el for por un while por la misma razon anterior, ademas que la division por 7 no es precisa.
```c
int res[10] := (10 0);
sem mutex[10]:= (10 1);
cola transacciones; // Estructura de datos con las 10.000 transacciones
sem cola_mutex := 1;

int terminar := 0;
sem terminar_mutex := 1;

process Worker[i := 0 to W-1] {
    while(true){
        P(cola_mutex);
        if(!transacciones.empty()){
            int val :=  transacciones.pop();
            V(cola_mutex);

            P(mutex[val]);
            res[val]++;
            V(mutex[val]);

        }
        else {
            V(cola_mutex);
            break;
        } 
    }

    P(terminar_mutex);
    terminar++;
    if (terminar == W){
        for (int j := 0 to 9){
            print(res[j]);
        }
    }
    V(terminar_mutex);
}
```