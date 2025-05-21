package practica.patrones.ejercicio04;

import java.time.Duration;
import java.time.LocalTime;

public class ToDoItem {

	private String name;
	private String comment;
	private Stage stage;
	private LocalTime startTime;
	
	public ToDoItem(String name) {
		this.name = name;
		this.comment = "";
		this.stage = new Pending();
	}
	
	public void setStage(Stage stage) { this.stage = stage; }
	public LocalTime getStartTime() { return this.startTime; }
	public void setStartTime(LocalTime time) { this.startTime = time; }
	public Stage getStage() { return this.stage; }
	public void setComment(String comment) { this.comment = comment; }
	
	public void start() {
		this.getStage().start(this);
	}
	
	public void togglePause() {
		this.getStage().togglePause(this);
	}
	
	public void finish() {
		this.getStage().finish(this);
	}
	
	public Duration workedTime() {
		return this.getStage().workedTime(this);
	}
	
	public void addComment(String comment) {
		this.getStage().addComment(this, comment);
	}
	
}
