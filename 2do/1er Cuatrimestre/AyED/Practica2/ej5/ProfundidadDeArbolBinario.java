package Practica2.ej5;

import JavaClases.BinaryTree;
import JavaClases.Queue;

public class ProfundidadDeArbolBinario {
	
	BinaryTree<Integer> tree = new BinaryTree<Integer>();
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> tree) {
		this.tree = tree;
	}
	
	public BinaryTree<Integer> getData(){
		return this.tree;
	}
	
	public void imprimir() {
		this.tree.byLevels();
	}
	
	public int sumaElementosProfundidad(int n) {
		Queue<BinaryTree<Integer>> queue = new Queue<BinaryTree<Integer>>();
		Queue<Integer> levels = new Queue<Integer>();
		
		queue.enqueue(this.getData());
		levels.enqueue(0);
		int total = 0;
		while(!queue.isEmpty()) {
			BinaryTree<Integer> aux = queue.dequeue();
			int lvl = levels.dequeue();
			if(lvl == n) {
				total += aux.getData();
			}
			if(aux.hasLeftChild()) {
				levels.enqueue(lvl+1);
				queue.enqueue(aux.getLeftChild());
			}
			if(aux.hasRightChild()) {
				levels.enqueue(lvl+1);
				queue.enqueue(aux.getRightChild());
			}
		}
		return total;
	}
}
