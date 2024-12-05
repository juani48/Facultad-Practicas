package PrimeraFecha.Parcial.src.main.java.Parcial;

public class Sede {

    private String nombre;
    private double precioEstadia;
    private int diasEstadia;

    public Sede(String nombre, double precioEstadia, int diasEstadia){
        this.nombre = nombre;
        this.precioEstadia = precioEstadia;
        this.diasEstadia = diasEstadia;
    }

    public double getPrecioEstadia(){ return this.precioEstadia; }
    public int getDiasEstadia(){ return this.diasEstadia; }

    public double montoTotal(){
        return this.getPrecioEstadia() * this.getDiasEstadia();
    }
}
