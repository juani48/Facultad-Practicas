package practica3_ej4;

import JavaClases.GeneralTree;
import JavaClases.Queue;

public class AnalizadorArbol {
		
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa> tree) {
		Queue<GeneralTree<AreaEmpresa>> queue = new Queue<GeneralTree<AreaEmpresa>>();
		queue.enqueue(tree);
		queue.enqueue(null);
		int totalLVL = 0;
		int totalNODOS = 0;
		double promMAX = -1;
		while(!queue.isEmpty()) {
			GeneralTree<AreaEmpresa> aux = queue.dequeue();
			if(aux != null) {
				System.out.println("La cola no tiene null");
				
				totalLVL += aux.getData().getDelay();	
				System.out.println(totalLVL);
				
				totalNODOS++;
				System.out.println(totalNODOS);
				
				if(aux.hasChildren()) {
					System.out.println("Tiene hijos");
					for(GeneralTree<AreaEmpresa> child: aux.getChildren()) {
						queue.enqueue(child);
					}
				}
			}
			else {
				System.out.println("La cola tiene null");
				if(!queue.isEmpty()) {
					System.out.println("La cola no esta vacia");
					double prom = totalLVL / totalNODOS;
					if(prom > promMAX) {
						promMAX = prom;
						System.out.println("Se actualizo el promedio");
					}
					totalLVL = 0;
					totalNODOS = 0;
					queue.enqueue(null);
				}
			}
		}
		return promMAX;
	}
 
}
