package Ej6;

import Clases.GeneralTree;

public class RedAguaPotable {

    private GeneralTree<Integer> tree = new GeneralTree<>();

    public RedAguaPotable(){
        tree = GeneralTree.randomTree(12);
        tree.byLevels();
    }

    public double minimoCaudal(double caudal){
        if(!tree.isEmpty()){
            return minimoCaudal(tree,caudal);
        }
        else{
            return 0;
        }
    }

    private double minimoCaudal(GeneralTree<Integer> tree, double caudal){
        if(tree.hasChildren()){
            double total = 9999;
            for(var child : tree.getChildren()){
                double aux = minimoCaudal(child, caudal/tree.getChildren().size());
                if(aux < total){
                    total = aux;
                }
            }
            return total;
        }
        return caudal;
    }
}
