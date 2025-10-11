## En un laboratorio de genética veterinaria hay 3 empleados. El primero de ellos continuamente prepara las muestras de ADN; cada vez que termina, se la envía al segundo empleado y vuelve a su trabajo. El segundo empleado toma cada muestra de ADN preparada, arma el set de análisis que se deben realizar con ella y espera el resultado para archivarlo. Por último, el tercer empleado se encarga de realizar el análisis y devolverle el resultado al segundo empleado.

```c
process Primero{
    while(true){
        // prepara muestra
        Segundo!(muestra);
    }
}
process Segundo{
    cola cola; muestra; resul;
    do
    [] Segundo?(muestra) ->
        // arma el set
        Tercero!send(muestra);
    [] (Tercero?res(resul)) ->
        // archiva el resultado
    od
}
process Tercero{
    muestra;
    while(true){
        Segundo?send(muestra);
        // arma el resultado
        Segundo!res(resul);
    }
}
```