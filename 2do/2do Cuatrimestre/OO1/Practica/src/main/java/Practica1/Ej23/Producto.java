package Practica1.Ej23;

public class Producto {

    @SuppressWarnings("unused")
    private String nombre;
    private String categoria;
    private double precio;
    private int unidades;

    public Producto(String nombre, String categoria, double precio, int unidades){
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.unidades = unidades;
    }

    public boolean siHayStock(int cantidad){
        if(this.getUnidades() >= cantidad){
            this.setUnidades(this.getUnidades() - cantidad);
            return true;
        }
        return false;
    }

    public int getUnidades(){
        return this.unidades;
    }

    private void setUnidades(int unidades){
        this.unidades = unidades;
    }

    public String getCategoria(){
        return this.categoria;
    }

    public double getPrecio(){
        return this.precio;
    }

    public double montoTotal(int cantidad){
        return this.getPrecio() * cantidad;
    }

}
