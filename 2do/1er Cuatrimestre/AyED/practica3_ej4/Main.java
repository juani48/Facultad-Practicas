package practica3_ej4;

import JavaClases.GeneralTree;

public class Main {

	public static void main(String[] args) {
		AnalizadorArbol x = new AnalizadorArbol();
		
		GeneralTree<AreaEmpresa> tree = new GeneralTree<AreaEmpresa>( new AreaEmpresa(14));
		for(int i = 0; i < 3; i++) {
			tree.addChild(new GeneralTree<AreaEmpresa>(new AreaEmpresa(i)));
		}
		System.out.println(x.devolverMaximoPromedio(tree));
	}

}
