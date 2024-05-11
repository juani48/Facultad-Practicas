package ej7;

import JavaClases.BinaryTree;

public class ParcialArboles {
	
	private BinaryTree<Integer> tree = new BinaryTree<Integer>();
	
	public ParcialArboles(BinaryTree<Integer> tree) {
		this.tree = tree;
	}
	
	public void imprimir() {
		this.tree.byLevels();
	}
	
	public boolean isLeftTree(int num) {
		if(this.tree.isEmpty()) {
			return false;
		}
		else {
			return isLeftTree(this.tree, num);
		}
	}
	
	private boolean isLeftTree(BinaryTree<Integer> tree, int num) {
		boolean ok = false;
		if(tree.getData() == num) {
			int HI = 0;
			int HD = 0;
			if(tree.hasLeftChild()) {
				HI = isLeftTree(tree.getLeftChild()) + 1;
			}
			if(tree.hasRightChild()) {
				HD = isLeftTree(tree.getRightChild()) - 1;
			}
			ok = HI > HD;
		}
		else {
			if((!ok)&&(tree.hasLeftChild())) {
				ok = isLeftTree(tree.getLeftChild(),num);
			}
			if((!ok)&&(tree.hasRightChild())) {
				ok = isLeftTree(tree.getRightChild(),num);
			}
			
		}
		return ok;
	}
	
	private int isLeftTree(BinaryTree<Integer> tree) {
		if(tree.isLeaf()) {
			return 0;
		}
		else {
			int HI = 0;
			int HD = 0;
			if(tree.hasLeftChild()) {
				HI = isLeftTree(tree.getLeftChild()) + 1;
			}
			if(tree.hasRightChild()) {
				HD = isLeftTree(tree.getRightChild()) - 1;
			}
			return HI + HD;
		}
	}
}
