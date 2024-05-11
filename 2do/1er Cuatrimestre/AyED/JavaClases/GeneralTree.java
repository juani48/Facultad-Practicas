package JavaClases;

import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int high() {
		if(this.isEmpty()) {
			return 0;
		}
		else {
			return high(this);
		}
	}
	
	private int high(GeneralTree<T> tree) {
		int max = 0;
		if(!tree.isLeaf()) {
			int aux;
			for(GeneralTree<T> child: tree.getChildren()) {
				aux = high(child) + 1;
				if(aux >= max) {
					max = aux;
				}
			}
		}
		return max;
		
	}
	
	public int level(T data){
		if(this.isEmpty()) {
			return 0;
		}
		else {
			return level(this, data);
		}
	  }
	
	private int level (GeneralTree<T> tree, T data) {
		int level = 0;
		if(!tree.isLeaf()) {
			for(GeneralTree<T> child: tree.getChildren()) {
				level = level(child,data);
			}
		}
		if(tree.getData() == data) {
			return level + 1;
		}
		else {
			return level;
		}
	}

	public int broad(){
		if(!this.isEmpty()) {
			Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
			queue.enqueue(this);
			queue.enqueue(null);
			int nodos = 0; int nodosMAX = 0; int lvl = 1; int lvlMAX = 0;
			
			while(!queue.isEmpty()) {
				GeneralTree<T> aux = queue.dequeue();
				
				if(aux.getData() != null) {
					if(aux.hasChildren()) {
						nodos += aux.getChildren().size();
						for(GeneralTree<T> child: aux.getChildren()) {
							queue.enqueue(child);
						}
					}
				}
				else {
					if(!queue.isEmpty()) {
						queue.enqueue(null);
						if(nodos > nodosMAX) {
							nodosMAX = nodos;
							lvlMAX = lvl;
						}
						lvl++;
						nodos = 0;
					}
				}
			}
			return lvlMAX;
		}
		else {
			return -1;
		}
	}
	
	public boolean isAncestor(T nodeAncestor, T nodeOffspring) {
		if(!this.isEmpty()) {
			Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
			queue.enqueue(this);
			boolean found = false;
			while((!queue.isEmpty())&&(!found)) {
				GeneralTree<T> aux = queue.dequeue();
				if(!aux.isEmpty()) {
					if(aux.getData() == nodeAncestor) {
						found = true;
					}
					if(aux.hasChildren()) {
						for(GeneralTree<T> child: aux.getChildren()) {
							queue.enqueue(child);
						}
					}
				}
			}
			if(found) {
				return isAncestor(nodeOffspring);
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	private boolean isAncestor(T nodeOffspring) {
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
		queue.enqueue(this);
		boolean found = false;
		GeneralTree<T> aux;
		while((!queue.isEmpty())&&(!found)) {
			aux = queue.dequeue();
			if(!aux.isEmpty()) {
				if(aux.getData() == nodeOffspring) {
					found = true;
				}
				if(aux.hasChildren()) {
					for(GeneralTree<T> child: aux.getChildren()) {
						queue.enqueue(child);
					}
				}
			}
		}
		if(found) {
			return true;
		}
		else {
			return false;
		}
	}
}