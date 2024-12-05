package PrimerRecuperatorio2023.parcial.src.main.java.parcial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

    private List<Mascota> mascotas;

    public Sistema(){
        this.mascotas = new ArrayList<>();
    }

    public List<Mascota> getMascotas(){ return this.mascotas; }

    public Medico registrarMedico(String nombre, LocalDate ingreso, double honorarios){
        return new Medico(nombre, ingreso, honorarios);
    }

    public Mascota registrarMascota(String nombre, String especie, LocalDate nacimiento){
        Mascota mascota = new Mascota(nombre, especie, nacimiento);
        this.getMascotas().add(mascota);
        return mascota;
    }

    public Servicio registrarConsulta(Medico medico, Mascota mascota, boolean descartables){
        Servicio servicio = new Consulta(descartables, medico);
        mascota.agregarServicio(servicio);
        return servicio;
    }

    public Servicio registrarVacunacio(Medico medico, Mascota mascota, String vacuna, double costo, boolean descartables){
        Servicio servicio = new Vacunacion(vacuna, costo, descartables, medico);
        mascota.agregarServicio(servicio); 
        return servicio;
    }

    public Servicio registrarGuarderia(Mascota mascota, int dias){
        Servicio servicio = new Guarderia(dias, mascota);
        mascota.agregarServicio(servicio);
        return servicio;
    }

    public double recaudacion(LocalDate fecha){
        return this.getMascotas().stream()
            .filter(x -> x.edad(2))
            .mapToDouble(x -> x.montoRecaudado(fecha))
            .sum();
    }

}
