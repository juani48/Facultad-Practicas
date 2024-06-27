package Ej9;

import Clases.GeneralTree;

public class App {
    public static void main(String[] args) throws Exception {
    
        int intentos = 100000000;
		GeneralTree<Integer> miArbolito = null;
		boolean found = false;
		while ((intentos>0) && (found==false)) {
			miArbolito = GeneralTree.randomTree(10);
			found = ParcialArboles.esDeSeleccion(miArbolito);
			intentos--;
		}
		miArbolito.byLevels();
		if (found) {
			System.out.println("Mi arbolito es de seleccion");
		} else {
			System.out.println("No se pudo encontrar un arbol de seleccion");
		}

    }
}
