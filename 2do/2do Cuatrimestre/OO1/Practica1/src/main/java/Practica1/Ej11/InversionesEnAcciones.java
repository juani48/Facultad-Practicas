package Practica1.Ej11;

public class InversionesEnAcciones implements Inversiones{

    private String nombre;
    private int cantidad;
    private double valorUnitario;

    public InversionesEnAcciones(String nombre, int cantidad, double valorUnitario){
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
    }

    public double getCantidad(){
        return this.cantidad;
    }

    public double getValorUnitario(){
        return this.valorUnitario;
    }

    @Override
    public double valorActual() {
        return this.getCantidad() * this.getValorUnitario();
    }
    
}
