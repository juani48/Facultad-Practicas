package Practica1.Ej10;

public class FifoScheduler extends JobScheduler  {
    
    @Override
    protected JobDescription selectNext(){
        return this.jobs.get(0);
    }

}
