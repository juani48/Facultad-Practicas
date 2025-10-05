## En un entrenamiento de fútbol hay 20 jugadores que forman 4 equipos (cada jugador conoce el equipo al cual pertenece llamando a la función DarEquipo()). Cuando un equipo está listo (han llegado los 5 jugadores que lo componen), debe enfrentarse a otro equipo que también esté listo (los dos primeros equipos en juntarse juegan en la cancha 1, y los otros dos equipos juegan en la cancha 2). Una vez que el equipo conoce la cancha en la que juega, sus jugadores se dirigen a ella. Cuando los 10 jugadores del partido llegaron a la cancha comienza el partido, juegan durante 50 minutos, y al terminar todos los jugadores del partido se retiran (no es necesario que se esperen para salir).

```c
int cancha_por_jugador[20] := (20 0);
process Jugadores[i := 0 to 20]{
    int equipo := DarEquipo(); // ASUMO QUE DA UN NUMERO ENTRE 0 Y 3
}

Monitor Entrenamiento {
    cond cola_equipo[4]; 
    int cant_equipo[4] := (4 0); 

    cond cancha[2]; int listo := 0
    int num_cancha[2] := (2 0)
    
    procedure formarEquip(id_equipo: int){
        cant_equipo[id_equipo]++;
        if (cant_equipo[id_equipo] < 5){
            wait(cola_equipo[id_equipo]);
        }
        else{
            signal_all(cola_equipo[id_equipo]);
            listo++;
            if (list <= 2){cant_equipo[id_equipo] := 0;}
            else {cant_equipo[id_equipo] := 1;}
        }
        num_cancha[cant_equipo[id_equipo]]++;
        wait(cancha[cant_equipo[id_equipo]])
    }

}
```



