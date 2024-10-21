package Practica1.Ej17;

public abstract class Persona {

    private int dni;
    private String nombre;

    public int getDni(){
        return this.dni;
    }
    public String getNombre(){
        return this.nombre;
    }

    public Persona(String nombre, int dni){
        this.dni = dni;
        this.nombre = nombre;
    }

}
