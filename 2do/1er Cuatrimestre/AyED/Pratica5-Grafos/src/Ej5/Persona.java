package Ej5;

public class Persona {

    private String nombre = "";
    private boolean esJubilado = false;
    private boolean jubilacionRecivida = false;
    private String domicilio = "";

    public Persona(String nombreJubildao, boolean jubilacio){
        this.nombre = nombreJubildao;
        this.jubilacionRecivida = jubilacio;
        this.esJubilado = true;
    }
    public Persona(String nombreEmpleado){
        this.nombre = nombreEmpleado;
    }
    public boolean isJulibado(){
        return this.esJubilado;
    }
    public boolean recivioJubilacion(){
        return this.jubilacionRecivida;
    }
    public String getNombre(){
        return this.nombre;
    }

    @Override
    public String toString(){
        return getNombre() + "-Jubilado:" + isJulibado() + "-Jubilacion:" + recivioJubilacion();
    }
}
