package Practica2.ej5;

import JavaClases.BinaryTree;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		for(int i = 0; i < 10; i++) {
			tree.add(i);
		}
		ProfundidadDeArbolBinario a = new ProfundidadDeArbolBinario(tree);
		
		a.imprimir();
		
		System.out.println(a.sumaElementosProfundidad(2));
	}

}
