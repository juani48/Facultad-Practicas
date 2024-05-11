package practica3_ej6;

import JavaClases.GeneralTree;

public class RedDeAguaPotable {
	private GeneralTree<Character> tree = new GeneralTree<Character>();
	
	public double minimoCuadal(double caudal) {
		return minimoCaudal(this.tree, caudal);
	}
	
	private double minimoCaudal(GeneralTree<Character> tree, double caudal) {
		if(!tree.isLeaf()) {
			caudal = caudal / tree.getChildren().size();;
			double caudalMin = -1;
			for(GeneralTree<Character> child : tree.getChildren()) {
				double x = minimoCaudal(child,caudal);
				if(x < caudalMin) {
					caudalMin = x;
				}
			}
			return caudalMin;
		}
		else {
			return caudal;
		}
	}
}
