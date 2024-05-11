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
public class Concurso {
    private Pareja[] parejas;
    private int dl = 0;
    private int df;

    public Pareja[] getParejas() {
        return parejas;
    }

    public void setParejas(Pareja[] parejas) {
        this.parejas = parejas;
    }

    public int getDl() {
        return dl;
    }

    private void setDl(int dl) {
        this.dl = dl;
    }

    public int getDf() {
        return df;
    }

    private void setDf(int df) {
        this.df = df;
    }
    
    public Concurso(int cantidadParejas){
        parejas = new Pareja[cantidadParejas];
        this.setDf(cantidadParejas);
    }
    
    public void agregar(Pareja pareja){
        int dl = this.getDl();
        if(dl +1 <= this.getDf()){
            dl++;
            this.setDl(dl);
            Pareja[] aux = this.getParejas();
            aux[dl] = pareja;
        }
    }
    public int mayorEdad(){
        int dl;
        int maxPos = 0, max = -1;
        Pareja[] aux = this.getParejas();
        for(dl =0; dl < this.getDl(); dl++){
            if(aux[dl].diferencia() > max){
                max = aux[dl].diferencia();
                maxPos = dl;
            }
        }
        return maxPos;
    }
    
    public String toString(){
        Pareja[] aux = this.getParejas();
        String aux1 = aux[mayorEdad()].toString();
        return aux1;
    }
}
