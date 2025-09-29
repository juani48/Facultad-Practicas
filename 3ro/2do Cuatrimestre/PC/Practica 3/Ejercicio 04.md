## Existen N vehículos que deben pasar por un puente de acuerdo con el orden de llegada. Considere que el puente no soporta más de 50000kg y que cada vehículo cuenta con su propio peso (ningún vehículo supera el peso soportado por el puente).

```c
Monitor Puente{
    double max = 50000;
    double peso = 0;
    cond cola;

    procedure entrar(v_peso: double){
        if (peso + v_peso > max){
            wait(cola);
        }
        peso += v_peso;
    }

    procedure terminar(v_peso: double){
        peso -= v_peso;
        signal(cola);
    }
}
process Vehiculo[i = 0 to N-1]{
    // Cada vehiculo conoce su peso
    Puente.entrar(peso);
    // Pasar por el puente
    Puente.terminar(peso);
}
```
