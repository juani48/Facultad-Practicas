package JavaClases;

import java.util.List;

public class DoubleEndedQueue<T> extends Queue<T> {
	private List<T> _data;
	
	public DoubleEndedQueue() {}
	
	public void enqueueFirst(T data) {
		this._data.add(0, data);
	}
	
	public T dequeueLast() {
		return this._data.remove(size()-1);
	}
}
