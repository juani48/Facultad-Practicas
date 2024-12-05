package Practica1.Ej23;

public abstract class Persona {
    private String nombre;
    private String direccion;

    public Persona(String nombre, String direccion){
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getDireccion(){
        return this.direccion;
    }
    public String getNombre(){
        return this.nombre;
    }
}
