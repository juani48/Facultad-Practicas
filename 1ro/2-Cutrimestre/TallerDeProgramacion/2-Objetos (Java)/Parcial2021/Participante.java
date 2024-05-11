/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialr2021;

/**
 *
 * @author Guada
 */
public class Participante {
    private String nombre;
    private int dni;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    private void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    private void setEdad(int edad) {
        this.edad = edad;
    }
    
    public Participante(String nombre, int dni, int edad){
        this.setNombre(nombre);
        this.setEdad(edad);
        this.setDni(dni);
    }
}
