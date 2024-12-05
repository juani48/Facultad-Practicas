package Practica1.Ej10;

public class HighestPriorityScheduler extends JobScheduler {
    @Override
    protected JobDescription selectNext(){
        return this.jobs.stream()
                        .max((j1,j2) -> Double.compare(j1.getPriority(), j2.getPriority()))
                        .orElse(null);
    }
}
