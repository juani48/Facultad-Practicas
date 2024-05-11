/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectojuan.Practica3_1;
import PaqueteLectura.Lector;
public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("ingrese un lado del triangulo");
        double lado1 = Lector.leerDouble();
        System.out.println("ingrese el segundo lado");
        double lado2 = Lector.leerDouble();
        System.out.println("ingrese el tercer lado");
        double lado3 = Lector.leerDouble();
        
        System.out.println("ingrese un color de relleno");
        String relleno = Lector.leerString();
        System.out.println("ingrese un color de linea");
        String linea = Lector.leerString();
        
        Triangulo tri = new Triangulo(lado1,lado2,lado3,relleno,linea);
        
        System.out.println("El perimetro del triangulo es: " + tri.calcularPerimetro()
                           + " y el area es: " + tri.calcularArea());
    }
}
