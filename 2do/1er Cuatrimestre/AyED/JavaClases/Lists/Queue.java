package JavaClases.Lists;

import java.util.LinkedList;
import java.util.List;

public class Queue<T>{
	protected List<T> _dato;
	
	public Queue(){
		_dato = new LinkedList<T>();
	}
	
	public void enqueue(T elem) {
		_dato.add(elem);
	}
	public T dequeue() {
		return _dato.remove(0);	
	}
	public T head() {
		return _dato.get(0);
	}
	public boolean isEmpty() {
		return _dato.isEmpty();
	}
	public int size() {
		return _dato.size();
	}
	public String toString() {
		return _dato.toString();
	}
}
