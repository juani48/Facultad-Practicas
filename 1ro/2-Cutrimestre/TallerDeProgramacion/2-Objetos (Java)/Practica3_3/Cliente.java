/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica3_3;


public class Cliente {
    private String nombreCliente;
    private int dniCliente;
    private int edadCleinte;

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(int dniCliente) {
        this.dniCliente = dniCliente;
    }

    public int getEdadCliente() {
        return edadCleinte;
    }

    public void setEdadCliente(int edadCleinte) {
        this.edadCleinte = edadCleinte;
    }
    //constructor Cliente
    public Cliente (String nombreCliente , int dniCliente , int edadCliente){
        this.setNombreCliente(nombreCliente);
        this.setDniCliente(dniCliente);
        this.setEdadCliente(edadCliente);
    }
    @Override
    public String toString(){
        String aux;
        aux = "nombre del cliente: " + this.getNombreCliente()
                + ", con DNI: " + this.getDniCliente()
                + "y edad: " + this.getEdadCliente();
        return aux;
    }
}
