package practica.patrones.ejercicio11;

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
