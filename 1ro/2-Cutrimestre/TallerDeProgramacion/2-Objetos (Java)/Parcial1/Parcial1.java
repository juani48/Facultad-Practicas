/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1;

/**
 *
 * @author Guada
 */
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class Parcial1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semana semana = new Semana();
        Paciente paciente;
        int num = Lector.leerInt();
        while(num != 0){
            paciente = new Paciente(GeneradorAleatorio.generarString(6)
                    ,GeneradorAleatorio.generarBoolean()
                    ,GeneradorAleatorio.generarDouble(7));
            semana.agregarTurno(paciente, Lector.leerInt(), Lector.leerInt());
        }
        semana.liberarTurnos(Lector.leerString());
        semana.tieneTurno(Lector.leerString());
    }
    
}
