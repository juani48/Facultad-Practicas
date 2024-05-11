package Practica2.ej4;

import JavaClases.BinaryTree;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.add(10);
		tree.add(2);
		tree.add(3);
		tree.add(5);
		tree.add(4);
		tree.add(9);
		tree.add(8);
		tree.add(7);
		tree.add(8);
		tree.add(5);
		tree.add(6);
		tree.add(12);
		tree.add(8);
		tree.add(2);
		tree.add(1);
		
		RedBinariaLlena a = new RedBinariaLlena(tree);
		a.imprimir();
		System.out.println(a.retardoEnvio());
	}

}
