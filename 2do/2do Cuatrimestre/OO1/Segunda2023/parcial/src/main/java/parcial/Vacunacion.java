package Segunda2023.parcial.src.main.java.parcial;

public class Vacunacion extends Atencion{

    private String vacuna;
    private double costo;

    public Vacunacion(String vacuna, double costo, boolean descartables, Medico medico){
        super(descartables, medico);
        this.vacuna = vacuna;
        this.costo = costo;
    }

    public double getCosto(){ return this.costo; }

    @Override
    public double montoTotal() {
        double aux = this.getMedico().precioMedico() + this.diaDomingo() + this.getCosto();
        if(this.getDescartables()){
            aux += 500;
        }
        return aux;
    } 

}
