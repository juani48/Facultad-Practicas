package Ej4;

import Clases.GeneralTree;
import Clases.Queue;

public class AnalizadorArbol {

    private GeneralTree<Integer> tree = new GeneralTree<Integer>();
    
    public AnalizadorArbol(){
        tree = GeneralTree.randomTree(12);
        tree.byLevels();
    }

    public double devolverMaximoPromedio (){
        if(!tree.isEmpty()){
            Queue<GeneralTree<Integer>> queue = new Queue<>();
            queue.enqueue(this.tree);
            queue.enqueue(null);
            double maxProm = -1;
            int numPorNivel = 0;
            int totalPorNivel = 0;
            while(!queue.isEmpty()){
                GeneralTree<Integer> aux = queue.dequeue();
                if(aux == null){
                    if(!queue.isEmpty()){
                        queue.enqueue(aux);
                    }
                    if(maxProm < (double)(totalPorNivel/numPorNivel)){
                        maxProm = (double)(totalPorNivel/numPorNivel);
                    }
                    totalPorNivel = 0;
                    numPorNivel = 0;
                }
                else{
                    numPorNivel++;
                    totalPorNivel += aux.getData();
                    if(aux.hasChildren()){
                        for(var child : aux.getChildren()){
                            queue.enqueue(child);
                        }
                    }
                }
            }
            return maxProm;
        }
        else{
            return 0;
        }
    }
}
