package PrimeraFecha.Parcial.src.main.java.Parcial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nombre;
    private List<Entrada> entradas;

    public Usuario(String nombre){
        this.nombre = nombre;
        this.entradas = new ArrayList<>();
    }

    private List<Entrada> getEntradas(){
        return this.entradas;
    }

    public Entrada comprarEntrada(Evento evento, boolean seguro){
        Entrada entrada = new Entrada(evento, seguro);
        this.getEntradas().add(entrada);
        return entrada;
    }

    public double entradasEnPeriodo(LocalDate inicio, LocalDate fin){
        return this.getEntradas().stream()
            .filter(x -> x.between(inicio, fin))
            .mapToDouble(x -> x.montoTotal())
            .sum();
    }

    public Entrada ultimaEntrada(){
        return this.getEntradas().stream()
            .min( (x, y) -> 
                Integer.compare(x.dias(LocalDate.now()), y.dias(LocalDate.now()))
            )
            .orElse(null);
    }
}
