/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica3_3;
import PaqueteLectura.Lector;
public class Habitacion {
    private double costoNoche;
    private boolean ocupada;
    private Cliente cliente;

    public double getCostoNoche() {
        return costoNoche;
    }

    public void setCostoNoche(double costoNoche) {
        this.costoNoche = costoNoche;
    }

    public boolean getOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public void setCLiente(Cliente cliente){
        this.cliente = cliente;
}
     //constructor Hotel
    public Habitacion (double costoNoche , boolean ocupada){
        if(costoNoche < 2000)
            costoNoche =+ 2000;
        this.setCostoNoche(costoNoche);
        this.setOcupada(ocupada);
    }
    public void agregar (Cliente cliente){
        if(!this.getOcupada()){
            this.setOcupada(true);
            this.setCLiente(cliente);
            System.out.println("El cliente fue agregado");
        }
        else
            System.out.println("La habitacion ya esta ocupada");
    }
    @Override
    public String toString(){
        String aux;
        String aux1;
        if(this.getOcupada()) {
            Cliente c;
            c = this.getCliente();
            aux1 = "esta ocupada, " + c.toString();
        }
        else
            aux1 = "esta libre";
        aux = "costo por noche: " + this.getCostoNoche()
                + ", la habitacion "+ aux1;
        return aux;
    }
}
