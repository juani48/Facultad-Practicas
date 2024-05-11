/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2;

/**
 *
 * @author Guada
 */
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class Parcial2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estante estante = new Estante(5,3);
        Libro libro;
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 3; j++){
                libro = new Libro(Lector.leerString()
                      ,GeneradorAleatorio.generarString(5)
                      ,GeneradorAleatorio.generarDouble(5));
                estante.agregarLibro(libro, i, j);
            }
        }
        System.out.println(estante.sacarLibro(Lector.leerString()));
        System.out.println(estante.calcular());
    }
    
}
