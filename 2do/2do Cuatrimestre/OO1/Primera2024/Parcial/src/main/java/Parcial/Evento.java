package Primera2024.Parcial.src.main.java.Parcial;

import java.time.LocalDate;
import java.time.Period;

public abstract class Evento {

    private String nombre;
    private String tema;
    private LocalDate fecha;
    private double precioRemera;
    private double precioInscripcion;

    public Evento(String nombre, String tema, LocalDate fecha, double precioRemera, double precioInscripcion){
        this.nombre = nombre;
        this.tema = tema;
        this.fecha = fecha;
        this.precioInscripcion = precioInscripcion;
        this.precioRemera = precioRemera;
    }

    public double getRemera(){ return this.precioRemera; }
    public double getInscripcion(){ return this.precioInscripcion; }
    public LocalDate getFecha(){ return this.fecha; }


    protected double recargo(LocalDate fecha){
        if(this.getFecha().isEqual(fecha)){
            return 1.20;
        }
        return 1;
    }

    public double precioAsistencia(LocalDate fecha){
        return (this.getInscripcion() + this.getRemera()) * this.recargo(fecha);
    }

    public int dias(LocalDate fecha){
        return Period.between(fecha, this.getFecha()).getDays();
    }
}
