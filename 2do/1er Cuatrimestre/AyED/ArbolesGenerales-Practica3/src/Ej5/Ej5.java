package Ej5;

import Clases.GeneralTree;
import Clases.Queue;

public class Ej5 {

    private GeneralTree<Integer> tree = new GeneralTree<>();

    public Ej5(){
        tree = GeneralTree.randomTree(12);
        tree.byLevels();
    }

    public boolean esAncestro(int ancestro, int descendiente){
        if(!tree.isEmpty()){
            GeneralTree<Integer> aux = esAncestro(ancestro);
            if(aux != null){
                return esAncestro(aux, descendiente);
            }
        }
        return false;
    }

    private GeneralTree<Integer> esAncestro(int dato){
        Queue<GeneralTree<Integer>> queue = new Queue<>();
        queue.enqueue(tree);
        queue.enqueue(null);

        while(!queue.isEmpty()){
            GeneralTree<Integer> aux = queue.dequeue();
            if(aux == null){
                if(!queue.isEmpty()){
                    queue.enqueue(aux);
                }  
            }
            else{
                if(aux.getData() == dato){
                    return aux;
                }
                if(aux.hasChildren()){
                    for(var child : aux.getChildren()){
                        queue.enqueue(child);
                    }
                }

            }
        }
        return null;
    }

    private boolean esAncestro(GeneralTree<Integer> tree, int dato){
        boolean ok = false;
        if(tree.getData() == dato){
            ok = true;
        }
        if(tree.hasChildren()){
            for(var child : tree.getChildren()){
                if(!ok){
                    ok = esAncestro(child, dato);
                }
            }
        }
        return ok;
    }

}
