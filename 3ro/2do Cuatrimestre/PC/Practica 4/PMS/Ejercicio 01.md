## Suponga que existe un antivirus distribuido que se compone de R procesos robots Examinadores y 1 proceso Analizador. Los procesos Examinadores están buscando continuamente posibles sitios web infectados; cada vez que encuentran uno avisan la dirección y luego continúan buscando. El proceso Analizador se encarga de hacer todas las pruebas necesarias con cada uno de los sitios encontrados por los robots para determinar si están o no infectados.

### A - Analice el problema y defina qué procesos, recursos y comunicaciones serán necesarios/convenientes para resolverlo.

### B - Implemente una solución con PMS sin tener en cuenta el orden de los pedidos.
```c
process Examinador[i := 0 to R]{
    while(true){
        // busca sitios infectados
        Analizador!(sitio);
    }
}
process Analizador{
    str sitio;
    while(true){
        Examinador?(sitio);
        // analiza si el sitio esta infectado
    }
}
```

### C - Modifique el inciso (B) para que el Analizador resuelva los pedidos en el orden en que se hicieron.
```c
process Examinador[i := 0 to R]{
    while(true){
        // busca sitios infectados
        Buffer!(sitio);
    }
}
process Buffer{
    cola cola;
    str sitio;
    do
    [] Examinador?(sitio) ->
        cola.push(sitio);
    [] (Analizador?ready()) and (!cola.empty()) ->
        Analizador!send(cola.pop());
    od
}
process Analizador{
    str sitio;
    while(true){
        Buffer!ready();
        Buffer?send(sitio)
        // analiza si el sitio esta infectado
    }
}
```