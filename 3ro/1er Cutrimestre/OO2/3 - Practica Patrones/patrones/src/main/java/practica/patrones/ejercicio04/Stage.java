package practica.patrones.ejercicio04;

import java.time.Duration;

public abstract class Stage {
	
	public void start(ToDoItem item) {}
	public abstract void togglePause(ToDoItem item);
	public void finish(ToDoItem item) {}
	public abstract Duration workedTime(ToDoItem item);
	public void addComment(ToDoItem item, String comment) { item.setComment(comment); }
	
}
