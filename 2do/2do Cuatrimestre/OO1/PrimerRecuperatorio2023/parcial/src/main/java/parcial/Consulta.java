package PrimerRecuperatorio2023.parcial.src.main.java.parcial;

public class Consulta extends Atencion{

    public Consulta(boolean descartables, Medico medico){
        super(descartables, medico);
    }

    @Override
    public double montoTotal(){
        double aux = this.getMedico().precioMedico() + this.diaDomingo();
        if(this.getDescartables()){
            aux += 300;
        }
        
        return aux;
    }
}
