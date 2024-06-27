package JavaClases.Trees;

import JavaClases.Lists.Queue;
import JavaClases.Trees.BinaryTree;

public class BinaryTree <T> {
	
	private T data = null;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.getData() == null && this.isLeaf());
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public int countLeaf(BinaryTree<T> elem) {		 
		if(!elem.isLeaf()) {
			int x = 0;
			if(elem.hasLeftChild())
				x += countLeaf(elem.getLeftChild());
			if(elem.hasRightChild()) 
				x += countLeaf(elem.getRightChild());
			return x;
		}
		else
			return 1;
	}	
    
	public BinaryTree<T> mirror() {
		BinaryTree<T> arb = new BinaryTree<T>(this.getData());
		if(!this.isEmpty()) {
			if(this.hasLeftChild()) {
				arb.addRightChild(this.getLeftChild().mirror());
			}
			if(this.hasRightChild()) {
				arb.addLeftChild(this.getRightChild().mirror());
			}
		}
		return arb;
	}

	// 0<=n<=m
	public void betweenLevels(int n, int m){
		Queue<BinaryTree<T>> x = new Queue<BinaryTree<T>>();
		Queue<Integer> levels = new Queue<Integer>();
		x.enqueue(this);
		levels.enqueue(0);
		while(!x.isEmpty()) {
			BinaryTree<T> tree = x.dequeue();
			int lvls = levels.dequeue();
			if((lvls >= n) && (lvls <= m)){
				System.out.println("Nivel "+lvls+": "+tree.toString());
			}
			if((tree.hasLeftChild())&&(lvls + 1 <=m)) {
				levels.enqueue(lvls+1);
				x.enqueue(tree.getLeftChild());
			}
			if((tree.hasRightChild())&&(lvls + 1 <=m)) {
				levels.enqueue(lvls+1);
				x.enqueue(tree.getRightChild());
			}
		}
	}
	
	public void byLevels() {
		Queue<BinaryTree<T>> x = new Queue<BinaryTree<T>>();
		Queue<Integer> levels = new Queue<Integer>();
		x.enqueue(this);
		levels.enqueue(0);
		
		while(!x.isEmpty()) {
			BinaryTree<T> tree = x.dequeue();
			int lvls = levels.dequeue();
			System.out.println("Nivel "+lvls+": "+tree.toString());
			
			if(tree.hasLeftChild()) {
				levels.enqueue(lvls+1);
				x.enqueue(tree.getLeftChild());
			}
			
			if(tree.hasRightChild()) {
				levels.enqueue(lvls+1);
				x.enqueue(tree.getRightChild());
			}
		}
	}
	
	public void add (T data) {
		if(this.getData() == null) {
			this.setData(data);
		}
		else {
			Queue<BinaryTree<T>> x = new Queue<BinaryTree<T>>();
			x.enqueue(this);
			while(!x.isEmpty()) {
				BinaryTree<T> tree = x.dequeue();
				if(tree.hasLeftChild()) {
					x.enqueue(tree.getLeftChild());
				}
				else {
					tree.addLeftChild(new BinaryTree<T>(data));
					break;
				}
				if(tree.hasRightChild()) {
					x.enqueue(tree.getRightChild());
				}
				else {
					tree.addRightChild(new BinaryTree<T>(data));
					break;
				}
			}
		}
	}
}

