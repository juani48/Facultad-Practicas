package Practica1.Ej10;

public class LifoScheduler extends JobScheduler {

    @Override
    protected JobDescription selectNext(){
        return this.jobs.get(jobs.size()-1);
    }
}
