## Resolver el siguiente problema con PMS. 
### En la estación de trenes hay una terminal de SUBE que debe ser usada por P personas de acuerdo con el orden de llegada. Cuando la persona accede a la terminal,  la  usa  y  luego  se  retira  para  dejar  al  siguiente.  
> Nota:  cada  Persona  usa  sólo  una  vez  la terminal. 

```c
chan cola(id: int);
chan privado[P]();
chan termine();

process Persona[i := 0 to P-1] {
    send cola(id);
    recive privado[i]();
    // usa la terminal
    send termine();
}
process Terminal {
    id: int;
    while(true){
        recive cola(id);
        send privado[id]();
        recive termine();
    }
}
```