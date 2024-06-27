package Ej9;

import Clases.GeneralTree;

public class ParcialArboles {

    public static boolean esDeSeleccion (GeneralTree<Integer> tree){
        boolean ok = true;
        if(!tree.isEmpty() && tree.hasChildren()){
            int min = 9999;
            for(var child : tree.getChildren()){
                ok = esDeSeleccion(child);
                if(ok){
                    if(child.getData() < min){
                        min = child.getData();
                    }
                }
                else{
                    return false;
                }
            }
            if(ok){
                return tree.getData() == min;
            }
        }
        return ok;
    }

}
