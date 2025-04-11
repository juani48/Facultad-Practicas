package practica.patrones.ejercicio06;

import java.time.LocalDate;

public class Excursion {
	
	private String name;
	private LocalDate start;
	private LocalDate end;
	private String meetingPoint;
	private double cost;
	private int minQuota;
	private int maxQuota;
	
	private State state;
	
	public Excursion(String name, LocalDate start, LocalDate end, String meetingPoint, double cost, int minQuota, int maxQuota, State state) {
		this.name = name; 
		this.start = start; this.end = end;
		this.meetingPoint = meetingPoint; 
		this.cost = cost; 
		this.minQuota = minQuota; this.maxQuota = maxQuota;
		this.state = state;
	}
	
	public State getState() { return this.state; }
	public void setState(State state) { this.state = state; }
	
	public int getMinQuota() { return this.minQuota; }
	public int getMaxQuota() { return this.maxQuota; } 
	
	public void signOn(User user) {
		this.getState().signOn(this, user);
	}
	
}
