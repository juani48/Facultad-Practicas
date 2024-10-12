package Practica1.Ej11;

import java.util.ArrayList;
import java.util.List;

public class Inversor {

    @SuppressWarnings("unused")
    private String nombre;
    private List<Inversiones> inversiones;

    public Inversor(String nombre){
        this.nombre = nombre;
        this.inversiones = new ArrayList<>();
    }

    public void agregarInversion(Inversiones inversion){
        this.getInversiones().add(inversion);
    }

    public List<Inversiones> getInversiones(){
        return this.inversiones;
    }

    public double valorActual(){
        return this.getInversiones().stream().mapToDouble(x -> x.valorActual()).sum();
    }
}
