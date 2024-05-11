/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica3_3;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class Hotel {
    private Habitacion[] habitaciones;
    private int cantidadHabitaciones;
    
    public void setHabitaciones(int cantidadHabitaciones){
        this.habitaciones = new Habitacion[cantidadHabitaciones];
    }
    public Habitacion[] getHabitaciones(){
        return habitaciones;
    }
    public void setCantidadHabitaciones(int cantidad){
        this.cantidadHabitaciones = cantidad;
    }
    public int getCantidadHabitaciones(){
        return cantidadHabitaciones;
    }

    //cosntructor Hotel
    public Hotel (int cantidadHabitaciones){
        this.setHabitaciones(cantidadHabitaciones);
        this.setCantidadHabitaciones(cantidadHabitaciones);
        
        double costoNoche;
        boolean ocupado = false;
        Habitacion[] aux = this.getHabitaciones();
        for(int i = 0; i < cantidadHabitaciones; i++){
            costoNoche = GeneradorAleatorio.generarDouble(8001);
            aux[i] = new Habitacion(costoNoche , ocupado);
        }
    }
    public void agregarCliente (int numeroHabitacion , Cliente cliente){
        Habitacion[] aux = this.getHabitaciones();
        aux[numeroHabitacion - 1].agregar(cliente);
    }
    
    public void aumentarMontoTotal (double monto){
        Habitacion[] aux = this.getHabitaciones();
        int dl = this.getCantidadHabitaciones();
        double act =0;
        for(int i = 0; i < dl; i++){
            act = aux[i].getCostoNoche();
            act += monto;
            aux[i].setCostoNoche(act);
        }
    }
    @Override
    public String toString (){
        String aux = "";
        Habitacion[] aux1 = this.getHabitaciones();
        int dl = this.getCantidadHabitaciones();
        for(int i = 0; i < dl; i++){
            aux += "--[Habitacion " + (i+1) +": " + aux1[i].toString() +"]";
        }
        return aux;
    }
}
