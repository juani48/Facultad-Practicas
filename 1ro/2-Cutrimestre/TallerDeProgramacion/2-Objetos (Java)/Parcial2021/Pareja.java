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
public class Pareja {
    private Participante[] pareja = new Participante[1];

    public Participante[] getPareja() {
        return pareja;
    }

    public void setPareja(Participante[] pareja) {
        this.pareja = pareja;
    }
    
    public Pareja (Participante p1, Participante p2){
        Participante[] aux = this.getPareja();
        aux[0] = p1;
        aux[1] = p2;
    }
    
    public int diferencia(){
        Participante[] aux = this.getPareja();
        int max = aux[0].getEdad();
        int min = aux[1].getEdad();
        int num;
        if(min > max){
            num = min;
            min = max;
            max = num;
        }
        return max - min;
    }
    public String toString(){
        Participante[] aux1 = this.getPareja();
        String aux = aux1[0].getNombre() + " y " + aux1[1].getNombre();
        return aux;
    }
}
