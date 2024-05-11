/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialr2021;

/**
 *
 * @author Guada
 */
import PaqueteLectura.GeneradorAleatorio;
public class Parcialr2021 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Concurso c = new Concurso(2);
        
        Participante p,r;
        for(int i = 0; i < 1; i++){
            p = new Participante("N",GeneradorAleatorio.generarInt(7),GeneradorAleatorio.generarInt(7));
            r = new Participante("p",GeneradorAleatorio.generarInt(7),GeneradorAleatorio.generarInt(7));
            Pareja q = new Pareja(p,r);
            c.agregar(q);
        }
        System.out.println(c);
    }
    
}
