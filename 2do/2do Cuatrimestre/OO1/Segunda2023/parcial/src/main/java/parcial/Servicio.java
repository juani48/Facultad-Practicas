package Segunda2023.parcial.src.main.java.parcial;

import java.time.LocalDate;

public abstract class Servicio {

    private LocalDate fecha;

    public Servicio(){
        this.fecha = LocalDate.now();
    }

    public LocalDate getFecha(){ return this.fecha; }

    public boolean dia(LocalDate fecha){
        return this.getFecha().isEqual(fecha);
    }

    public abstract double montoTotal();

}
