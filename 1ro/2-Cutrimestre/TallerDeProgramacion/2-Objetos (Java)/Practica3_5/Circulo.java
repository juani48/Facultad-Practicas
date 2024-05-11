/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica3_5;

/**
 *
 * @author JUANI
 */
public class Circulo {
    private double radio;
    private String colorRelleno;
    private String colorLinea;

    public double getRadio() {
        return radio;
    }
    public void setRadio(double radio) {
        this.radio = radio;
    }
    public String getColorRelleno() {
        return colorRelleno;
    }
    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }
    public String getColorLinea() {
        return colorLinea;
    }
    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
    }
    
    public Circulo(double radio , String colorRelleno , String colorLinea){
        this.setRadio(radio);
        this.setColorRelleno(colorRelleno);
        this.setColorLinea(colorLinea);
    }
    
    public double calcularPerimetro(){
        double pi = Math.PI;
        double r = this.getRadio();
        r = r*2;
        return r*pi;
        
    }
    
    public double calcularArea(){
        double pi = Math.PI;
        double r = this.getRadio();
        double a = pi * (r*r);
        return a;
    }
    
   
}
