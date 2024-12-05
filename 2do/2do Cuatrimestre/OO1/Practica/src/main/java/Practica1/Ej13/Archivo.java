package Practica1.Ej13;

public class Archivo {

    private String nombre;

    public Archivo(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int tamaño(){
        return this.getNombre().length();
    }
}
