
package practica4;
import PaqueteLectura.GeneradorAleatorio;
public class Practica4 {

    public static void main(String[] args) {
        Estacion e = new Estacion("Nombre", 12, 9.7, 2000, 4);
        
        int c, f;
        double t = 0;
        for(c = 0; c < 2000; c++){
            for(f = 0; f < 12; f++){
                t = GeneradorAleatorio.generarDouble(31);
                e.setTemperatura(c +2000, f + 1, t);
            }
        }
        
        System.out.println(e.toString());
    }
    
}
