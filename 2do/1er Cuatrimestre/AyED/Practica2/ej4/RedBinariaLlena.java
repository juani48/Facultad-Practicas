package Practica2.ej4;

import JavaClases.BinaryTree;
import JavaClases.Queue;

public class RedBinariaLlena {
	
	BinaryTree<Integer> tree = new BinaryTree<Integer>();
	
	public RedBinariaLlena(BinaryTree<Integer> tree) {
		this.tree = tree;
	}
	
	public BinaryTree<Integer> getData() {
		return this.tree;
	}
	
	public void imprimir() {
		tree.byLevels();
	}
	
	public boolean ok (BinaryTree<Integer> tree, int max) {
		return tree.getData() >= max;
	}
	
	public int retardoEnvio() {
		Queue<BinaryTree<Integer>> queueTrees = new Queue<BinaryTree<Integer>>();
		Queue<Integer> levels = new Queue<Integer>();
		
		queueTrees.enqueue(this.getData());
		levels.enqueue(0);
		
		int max = -1;
		int act = 0; int total = 0;
		
		while(!queueTrees.isEmpty()) {
			BinaryTree<Integer> aux = queueTrees.dequeue();
			int lvl = levels.dequeue();
			if(lvl != act) {
				act = lvl;
				total += max;
				System.out.println("Se guardo: " + max);
				max = -1;
			}

			if(this.ok(aux,max)) {
					max = aux.getData();
			}
			if(aux.isLeaf()) {
				levels.enqueue(lvl+1);
				queueTrees.enqueue(aux.getLeftChild());
				levels.enqueue(lvl+1);
				queueTrees.enqueue(aux.getRightChild());
			}
		}
		return total;
	}
}
