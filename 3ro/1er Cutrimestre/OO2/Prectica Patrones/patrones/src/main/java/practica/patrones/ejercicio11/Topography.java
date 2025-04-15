
//package practica.patrones.ejercicio11;

import main.java.practica.patrones.ejercicio11.Portion;

public class Topography {
    private Portion portion;

    public Topography(Portion portion){
        this.portion = portion;
    }

    public Portion getPortion(){ return this.portion; }

    public double calculatePortion(){
        return this.getPortion().calculatePortion();
    }
}
