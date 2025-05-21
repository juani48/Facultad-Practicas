package practica.patrones.ejercicio04;

import java.time.Duration;
import java.time.LocalTime;

public class Finished extends Stage {
	
	private LocalTime finishedTime;
	
	public Finished() {
		this.finishedTime = LocalTime.now();
	}

	@Override
	public void togglePause(ToDoItem item) { throw new RuntimeException("No se puedo cambar al estado 'pausa'/'en progreso'."); }

	@Override
	public Duration workedTime(ToDoItem item) { return Duration.between(item.getStartTime(), this.finishedTime); }
	
	@Override
	public void addComment(ToDoItem item, String comment) {}

}
