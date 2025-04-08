package practica.patrones.ejercicio04;

import java.time.Duration;
import java.time.LocalTime;

public class Pending extends Stage {

	@Override
	public void start(ToDoItem item) { item.setStartTime(LocalTime.now()); item.setStage(new InProgress()); }
	
	@Override
	public void togglePause(ToDoItem time) { throw new RuntimeException("No se puedo cambar al estado 'pausa'/'en progreso'."); }

	@Override
	public Duration workedTime(ToDoItem time) { throw new RuntimeException("No se inicio el item."); }

}
