/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1;

/**
 *
 * @author Guada
 */
public class Paciente {
    private String nombre;
    private boolean tieneObraSocial;
    private double costo;

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isTieneObraSocial() {
        return tieneObraSocial;
    }

    private void setTieneObraSocial(boolean tieneObraSocial) {
        this.tieneObraSocial = tieneObraSocial;
    }

    public double getCosto() {
        return costo;
    }

    private void setCosto(double costo) {
        this.costo = costo;
    }
    
    public Paciente(String nombre, boolean tieneObraSocial, double costo){
        this.setNombre(nombre);
        this.setTieneObraSocial(tieneObraSocial);
        this.setCosto(costo);
    }
}
