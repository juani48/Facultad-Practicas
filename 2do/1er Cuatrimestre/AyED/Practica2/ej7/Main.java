package ej7;

import JavaClases.BinaryTree;

public class Main {

	public static void main(String[] args) {
		BinaryTree<Integer> raiz = new BinaryTree<Integer>(2);
		BinaryTree<Integer> l1hI = new BinaryTree<Integer>(7);
		BinaryTree<Integer> l1hD = new BinaryTree<Integer>(-5);
		BinaryTree<Integer> l2hIi = new BinaryTree<Integer>(23);
		BinaryTree<Integer> l2hId = new BinaryTree<Integer>(6);
		BinaryTree<Integer> l2hD = new BinaryTree<Integer>(19);
		
		l2hIi.addLeftChild(new BinaryTree<Integer>(-3));
		l2hId.addLeftChild(new BinaryTree<Integer>(55));
		l2hId.addRightChild(new BinaryTree<Integer>(11));
		
		BinaryTree<Integer> l3hD = new BinaryTree<Integer>(4);
		l2hD.addLeftChild(l3hD);
		l3hD.addLeftChild(new BinaryTree<Integer>(18));
		
		l1hI.addLeftChild(l2hIi);
		l1hI.addRightChild(l2hId);
		
		l1hD.addLeftChild(l2hD);
		
		raiz.addLeftChild(l1hI);
		raiz.addRightChild(l1hD);
		
		ParcialArboles x = new ParcialArboles(raiz);
		x.imprimir();
		System.out.println(x.isLeftTree(7));
	}

}
