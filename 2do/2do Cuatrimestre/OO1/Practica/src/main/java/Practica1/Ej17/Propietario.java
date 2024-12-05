package Practica1.Ej17;

import java.util.ArrayList;
import java.util.List;

import Practica1.Ej14a.IDateLapse;

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

    public double calcularRetribucion(IDateLapse perido){
        return this.getPropiedades().stream().filter(x -> x.diponibilidad(perido) != false).mapToDouble(x -> x.getMontoTotal(perido) * 0.75).sum();
    }


}
