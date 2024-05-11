/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2;

/**
 *
 * @author Guada
 */
public class Libro {
    private String nombre;
    private String primerAutor;
    private double peso;

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerAutor() {
        return primerAutor;
    }

    private void setPrimerAutor(String primerAutor) {
        this.primerAutor = primerAutor;
    }

    public double getPeso() {
        return peso;
    }

    private void setPeso(double peso) {
        this.peso = peso;
    }
    
    public Libro(String nombre, String nombreAutor, double peso){
        this.setNombre(nombre);
        this.setPrimerAutor(nombreAutor);
        this.setPeso(peso);
    }
    public String toString(){
        String aux = this.getNombre() + ", " + this.getPrimerAutor() + ", " + this.getPeso();
        return aux;
    }
}
