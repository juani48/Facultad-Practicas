## Resolver el siguiente problema. 
### En una montaña hay 30 escaladores que en una parte de la subida deben utilizar un único paso de a uno a la vez y de acuerdo con el orden de llegada al mismo. 
> Nota: sólo se pueden utilizar procesos que representen a los escaladores; cada escalador usa sólo una vez el paso.

```c
monitor Paso{
    bool libre := true;
    int esperando := 0;
    cond cola;

    procedure Entrar(){
        if (!libre){
            esperando++;
            wait(cola);
        }
        else {
            libre := false;
        }
    }

    procedure Liberar(){
        if (esperando > 0){
            signal(cola);
        }
        else {
            libre := true;
        }
    }
}
process Escalador[i := 1 to 30]{
    // El escalador escala
    Paso.Entrar();
    // Utiliza el paso
    Paso.Liberar();
    // Sigue escalando
}
```
