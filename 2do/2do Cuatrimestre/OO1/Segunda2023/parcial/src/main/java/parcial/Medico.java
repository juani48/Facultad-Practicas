package Segunda2023.parcial.src.main.java.parcial;

import java.time.LocalDate;
import java.time.Period;

public class Medico {

    private String nombre;
    private LocalDate ingreso;
    private double honorarios;

    public Medico(String nombre, LocalDate ingreso, double honorarios){
        this.honorarios = honorarios;
        this.nombre = nombre;
        this.ingreso = ingreso;
    }

    public double getHonorarios(){ return this.honorarios; }
    public LocalDate getIngreso(){ return this.ingreso; }

    private double antiguedad(){
        return (Period.between(LocalDate.now(), this.getIngreso()).getYears()) * 100;
    }

    public double precioMedico(){
        return this.antiguedad() + this.getHonorarios();
    }
}
