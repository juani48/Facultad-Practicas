package PrimerRecuperatorio2023.parcial.src.main.java.parcial;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Mascota {

    private String nombre;
    private String especie;
    private LocalDate nacimiento;
    private List<Servicio> servicios;

    public Mascota(String nombre, String especie, LocalDate nacimiento){
        this.nombre = nombre;
        this.especie = especie;
        this.nacimiento = nacimiento;
        this.servicios = new ArrayList<>();
    }

    public List<Servicio> getServicios(){ return this.servicios; }
    public LocalDate getNacimiento(){ return this.nacimiento; }

    public void agregarServicio(Servicio servicio){
        this.getServicios().add(servicio);
    }

    public double montoRecaudado(LocalDate fecha){
        return this.getServicios().stream()
            .filter(x -> x.dia(fecha))
            .mapToDouble(x -> x.montoTotal())
            .sum();
    }

    public boolean edad(int edad){
        return Period.between(LocalDate.now(), this.getNacimiento()).getYears() == edad;
    }

    public double desceunto(){
        if(this.getServicios().size() < 5){
            return 1.1;
        }
        return 1;
    }

}
