package Ej8;

import Clases.BinaryTree;

public class ParcialArbol {

    public static boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        if(arbol1.getData() == arbol2.getData()){
            boolean ok = true;
                if(arbol1.hasLeftChild() && ok){
                    if(arbol2.hasLeftChild()){
                        ok = esPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild());
                    }
                    else{
                        ok = false;
                    }
                }
                if(arbol1.hasRightChild() && ok){
                    if(arbol2.hasRightChild()){
                        ok = esPrefijo(arbol1.getRightChild(), arbol2.getRightChild());
                    }
                    else{
                        ok = false;
                    }
                }
                return ok;
            }
        return false;
    }

}
