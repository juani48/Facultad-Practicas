package Segunda2023.parcial.src.main.java.parcial;

import java.time.DayOfWeek;

public abstract class Atencion extends Servicio {

    private boolean descartables;
    private Medico medico;

    public Atencion(boolean descartables, Medico medico){
        super();
        this.descartables = descartables;
        this.medico = medico;
    }

    public boolean getDescartables(){ return this.descartables; }
    public Medico getMedico(){ return this.medico; }

    protected double diaDomingo(){
        if(this.getFecha().getDayOfWeek() == DayOfWeek.SUNDAY){
           return 200;
        }
        return 0;
    }

}
