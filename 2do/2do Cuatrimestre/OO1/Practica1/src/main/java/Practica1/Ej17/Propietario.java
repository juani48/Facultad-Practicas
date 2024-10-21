package Practica1.Ej17;

import java.util.ArrayList;
import java.util.List;

public class Propietario extends Persona {

    private List<Propiedad> propiedades;

    public Propietario(String nombre, int dni) {
        super(nombre, dni);
        this.propiedades = new ArrayList<>();
    }

    public List<Propiedad> getPropiedades(){
        return this.propiedades;
    }

    public void agreagrPropiedad(Propiedad propiedad){
        this.getPropiedades().add(propiedad);
    }

    public double calcularRetribucion(){
        return this.getPropiedades().stream().mapToDouble(x -> x.getMontoTotal() * 0.75).sum();
    }


}
