## Resolver el funcionamiento en una fábrica de ventanas con 7 empleados (4 carpinteros, 1 vidriero y 2 armadores) que trabajan de la siguiente manera:
- Los carpinteros continuamente hacen marcos (cada marco es armando por un único carpintero) y los deja en un depósito con capacidad de almacenar 30 marcos.
- El vidriero continuamente hace vidrios y los deja en otro depósito con capacidad para 50 vidrios.
- Los armadores continuamente toman un marco y un vidrio (en ese orden) de los depósitos correspondientes y arman la ventana (cada ventana es armada por un único armador).

```c
int dep_marco[30], dep_vidrio[50];
sem m_mutex:= 1, v_mutex := 1;
sem v_disp := 50, v_ocup := 0;
sem m_disp := 30, m_cup := 0;

process Carpintero[i := 1 to 4]{
    while(true){
        // Crear un marco

        P(m_disp); // Si hay espacio libre
        P(m_mutex); push(M, marco); V(m_mutex); // Guarda un marco
        V(m_cup); // Avisa que hay un marco para usar
    }
}
process Vidriero{
    while(true){
        // Crear vidrio
        
        P(v_disp);
        P(v_mutex); push(V, marco); V(v_mutex); // Guarda un vidrio
        V(v_ocup); // Avisa que hay un vidrio para usar
    }
}
process Armadores[i = 1 to 2]{
    while(true){
        // Toma marco
        P(m_ocup);
        P(m_mutex); marco := pop(M); V(m_mutex);
        V(m_disp);

        // Toma vidrio
        P(v_ocup);
        P(v_mutex); vidrio := pop(V); V(v_mutex);
        V(v_disp);

        // Arma una ventana
    }
}
```