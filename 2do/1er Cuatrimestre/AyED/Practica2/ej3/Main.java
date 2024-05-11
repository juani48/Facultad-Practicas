package Practica2.ej3;

import java.util.LinkedList;

import JavaClases.BinaryTree;

public class Main {

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		for(int i = 0; i < 10; i++) {
			tree.add(i);
		}
		ContadorArbol x = new ContadorArbol(tree);
		LinkedList<Integer> list = new LinkedList<Integer>();
		list = x.numerosPares();
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
