/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica3_5;

import PaqueteLectura.Lector;
public class Main {
    public static void main(String[] args){
        System.out.println("ingrese el radio del criculo");
        double radio = Lector.leerDouble();
        System.out.println("ingrese el color de relleno");
        String relleno = Lector.leerString();
        System.out.println("ingrese el color de linea");
        String linea = Lector.leerString();
        
        Circulo circulo = new Circulo(radio,relleno,linea);
        
        System.out.println("El area del circulo es: " + circulo.calcularArea());
        System.out.println("El perimetro del circulo es: " + circulo.calcularPerimetro());
    }
}
