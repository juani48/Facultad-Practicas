package practica.patrones.ejercicio04;

import java.time.Duration;
import java.time.LocalTime;

public class InProgress extends Stage {

	@Override
	public void togglePause(ToDoItem item) { item.setStage(new Paused()); }
	
	@Override
	public void finish(ToDoItem item) { item.setStage(new Finished()); }

	@Override
	public Duration workedTime(ToDoItem item) { return Duration.between(item.getStartTime(), LocalTime.now()); }

}
