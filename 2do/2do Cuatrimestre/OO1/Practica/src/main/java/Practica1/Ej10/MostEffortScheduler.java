package Practica1.Ej10;

public class MostEffortScheduler extends JobScheduler{

    @Override
    protected JobDescription selectNext() {
        return this.jobs.stream()
                        .max((j1,j2) -> Double.compare(j1.getEffort(), j2.getEffort()))
                        .orElse(null);
    }
    
}
