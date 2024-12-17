package Primera2024.Parcial.src.main.java.Parcial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presencial extends Evento {

    private List<Sede> sedes;

    public Presencial(Sede sede ,String nombre, String tema, LocalDate fecha, double precioRemera, double precioInscripcion){
        super(nombre, tema, fecha, precioRemera, precioInscripcion);
        this.sedes = new ArrayList<>();
        this.sedes.add(sede);
    }

    public Presencial(List<Sede> sedes ,String nombre, String tema, LocalDate fecha, double precioRemera, double precioInscripcion){
        super(nombre, tema, fecha, precioRemera, precioInscripcion);
        this.sedes = new ArrayList<>(sedes);
    }

    public List<Sede> getSedes(){ return this.sedes; }

    public double precioAsistencia(LocalDate fecha){
        return (this.getSedes().stream().mapToDouble(x -> x.montoTotal()).sum() * this.recargo(fecha)) + super.precioAsistencia(fecha);
    }
}
