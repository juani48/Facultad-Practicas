package Primera2024.Parcial.src.main.java.Parcial;

import java.time.LocalDate;

public class Virtual extends Evento {

    private double envio;

    public Virtual(double envio ,String nombre, String tema, LocalDate fecha, double precioRemera, double precioInscripcion){
        super(nombre, tema, fecha, precioRemera, precioInscripcion);
        this.envio = envio;
    }

    public double getEnvio(){ return this.envio; }

    public double precioAsistencia(LocalDate fecha){
        return (this.getEnvio() * this.recargo(fecha)) + super.precioAsistencia(fecha);
    }
}
