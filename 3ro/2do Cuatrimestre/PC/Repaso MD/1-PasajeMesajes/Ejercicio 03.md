## Resolver el siguiente problema  con PMA. 
### En  un  negocio de cobros digitales hay P personas que deben  pasar  por  la  única  caja  de  cobros  para  realizar  el  pago  de  sus  boletas.  Las  personas  son atendidas de acuerdo con el orden de llegada, teniendo prioridad aquellos que deben pagar menos de 5 boletas de los que pagan más. Adicionalmente, las personas embarazadas tienen prioridad sobre los dos casos anteriores. Las personas entregan sus boletas al cajero y el dinero de pago; el cajero les devuelve el vuelto y los recibos de pago.

```c
process Persona[i := 0 to P-1] {
    boletas: int; embarazada: bool;
    vuelto: float; recibos: str;

    Buffer!(boletas, embarazada, i); // se encola
    Caja?(); // espera a ser atendido

    Caja!(boletas); // entrega las boletas
    Caja?(vuelto, recibos);
}
process Buffer {
    boletas: int; embarazada: bool; id: int;
    cant: int := 0;
    embarazadas, menos_boletas, cola : cola;
    do
    [] Persona[*]?(boletas, embarazada, id) ->
        cant++;
        if (emabarazada) {
            embarazadas.push(id);
        } else if (boletas < 5) {
            menos_boletas.push(id);
        } else {
            cola.push(id);
        }
        
    [] cant > 0; Caja?() ->
        cant--;
        if (!embarazadas.empty()) {
            Caja!(embarazadas.pop());
        } else if (!menos_boletas.empty()) {
            Caja!(menos_boletas.pop());
        } else {
            Caja!(cola.pop());
        }
    od
}
process Caja {
    id: int;
    boletas: int;
    vuelto: float; recibos: str;
    while(true){
        Caja!();
        Caja?(id);
        Persona[id]();
        Persona[id](boletas);
        // procesa el pago 
        Persona[id](vuelto, recibos);
    }
}
```