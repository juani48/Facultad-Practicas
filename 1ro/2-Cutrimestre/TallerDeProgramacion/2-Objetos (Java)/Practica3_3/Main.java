/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica3_3;
import PaqueteLectura.Lector;
public class Main {
        public static void main(String[] args) {
            System.out.println("ingrese la catidad de habitaciones");
            int cantidad = Lector.leerInt();
            Hotel hotel = new Hotel(cantidad);
            
            //agregar un clientes
            System.out.println("ingrese un numero dehabitacion, maximo hasta en numero: " + cantidad 
                    + ", en caso de no querer ingresar clientes ingrese 0");
            int num = Lector.leerInt();
            String n;
            int edad , dni;
            Cliente cliente;
            while(num != 0){
                System.out.println("Ingrese un nombre de cliente");
                n = Lector.leerString();
                System.out.println("Ingrese el DNI");
                dni = Lector.leerInt();
                System.out.println("Ingresa la edad");
                edad = Lector.leerInt();
                cliente = new Cliente(n,dni,edad);
                hotel.agregarCliente(num, cliente);
                
                System.out.println("ingrese un numero dehabitacion, maximo hasta en numero: " + cantidad 
                        + ", en caso de no querer ingresar clientes ingrese 0");
                num = Lector.leerInt();
            }
            
            System.out.println(hotel.toString());
            
            System.out.println("Ingrese el aumento");
            double aumento = Lector.leerDouble();
            hotel.aumentarMontoTotal(aumento);
            System.out.println(hotel.toString());
        }
}
