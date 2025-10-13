## En un estadio de fútbol hay una máquina expendedora de gaseosas que debe ser usada por E Espectadores de acuerdo con el orden de llegada. Cuando el espectador accede a la máquina en su turno usa la máquina y luego se retira para dejar al siguiente. 
> Nota: cada Espectador una sólo una vez la máquina.
```c
process Espectador[i := 0 to E-1]{
    Buffer!(i);
    Maquina?();
    // Usa la maquina
    Maquina!();
}
process Buffer{
    cola cola; int id; ok := true;
    do
    [] ok; Espectador[*]?(id) -> cola.psuh(id);
    [] (ok) and (!cola.empty()); Maquina?ready() -> Maquina!send(cola.pop());
    [] ok; Maquina?fin() -> ok := false;
    od
}
process Maquina{
    int id;
    for(0 to E-1){
        Buffer!ready();
        Buffer?send(id);
        Espectador[id]!();
        Espectador[id]?();
    }
    Buffer!fin();
}
```