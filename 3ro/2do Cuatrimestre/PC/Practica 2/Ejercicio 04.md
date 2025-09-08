## Suponga que existe una BD que puede ser accedida por 6 usuarios como máximo al mismo tiempo. Además, los usuarios se clasifican como usuarios de prioridad alta y usuarios de prioridad baja. Por último, la BD tiene la siguiente restricción:
- no puede haber más de 4 usuarios con prioridad alta al mismo tiempo usando la BD.
- no puede haber más de 5 usuarios con prioridad baja al mismo tiempo usando la BD.

### Indique si la solución presentada es la más adecuada. Justifique la respuesta.
```c
total: sem := 6;
alta: sem := 4;
baja: sem := 5
Process Usuario-Alta [i := 1 to L]::{ 
    P(total);
    P(alta);
    //usa la BD
    V(total);
    V(alta);
}
Process Usuario-Baja [i := 1 to K]{
    P(total);  
    P(baja);
    //usa la BD
    V(total);
    V(baja);
}
```

