package PrimerRecuperatorio2023.parcial.src.main.java.parcial;

public class Guarderia extends Servicio {

    private int dias;
    private Mascota mascota;

    public Guarderia(int dias, Mascota mascota){
        super();
        this.dias = dias;
        this.mascota = mascota;
    }

    public Mascota getMascota(){ return this.mascota; }
    public int getDias(){ return this.dias; }

    @Override
    public double montoTotal() {
        return (this.getDias() * 500) * this.getMascota().desceunto();
    }

}
