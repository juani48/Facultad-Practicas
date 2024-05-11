package Practica2.ej3;

import java.util.LinkedList;


import JavaClases.BinaryTree;

public class ContadorArbol {

	private BinaryTree<Integer> tree = new BinaryTree<Integer>();
	
	public ContadorArbol (BinaryTree<Integer> tree) {
		this.tree = tree;
	}
	
	public LinkedList<Integer> numerosPares(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		numerosPares(list, this.tree);
		return list;
	}
	
	private void numerosPares(LinkedList<Integer> list, BinaryTree<Integer> tree){
		if(!tree.isEmpty()) {
			if(tree.hasLeftChild()) {
				numerosPares(list,tree.getLeftChild());
			}
			if(tree.getData() % 2 == 0) {
				list.add(tree.getData());
			}
			if(tree.hasRightChild()) {
				numerosPares(list, tree.getRightChild());
			}
		}
	}
}
