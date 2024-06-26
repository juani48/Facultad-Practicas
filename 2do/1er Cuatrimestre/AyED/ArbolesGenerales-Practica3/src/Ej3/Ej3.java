package Ej3;

import Clases.GeneralTree;
import Clases.Queue;

public class Ej3 {

    private GeneralTree<Integer> tree = new GeneralTree<Integer>();

    public Ej3(){
        tree = GeneralTree.randomTree(12);
        tree.byLevels();
    }

    public int altura(){
        if(!this.tree.isEmpty()){
            Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
            queue.enqueue(this.tree);
            queue.enqueue(null);
            int lvl = 0;
            while(!queue.isEmpty()){
                GeneralTree<Integer> aux = queue.dequeue();
                if(aux == null){
                    if(!queue.isEmpty()){
                        queue.enqueue(aux);
                    }
                    lvl++;
                }
                else{
                    if(aux.hasChildren()){
                        for(var child : aux.getChildren()){
                            queue.enqueue(child);
                        }
                    }
                }
            }
            return lvl;
        }
        return 0;
    }

    public int nivel(int dato){ //podria resolverse con recorrido por niveles, parecido al meotod "altura"
        if(!tree.isEmpty()){
            return nivel(tree, dato) -1;
        }
        else{
            return 0;
        }
    }

    private int nivel(GeneralTree<Integer> tree, int num){
        if(tree.getData() == num){
            return 1;
        }
        else{
            if(tree.hasChildren()){
                int total = 0;
                for(var child : tree.getChildren()){
                    total = nivel(child,num);
                    if(total > 0){
                        return total + 1;
                    }
                }
            }
        }
        return 0;
    }

    public int ancho(){
        if(!tree.isEmpty()){
            Queue<GeneralTree<Integer>> queue = new Queue<>();
            queue.enqueue(tree);
            queue.enqueue(null);
            int maxNodos = -1;
            int nivelNodos = 0;
            while(!queue.isEmpty()){
                GeneralTree<Integer> aux = queue.dequeue();
                if(aux == null){
                    if(!queue.isEmpty()){
                        queue.enqueue(aux);
                        if(maxNodos < nivelNodos){
                            maxNodos = nivelNodos;
                        }
                        nivelNodos = 0;
                    }   
                }
                else{
                    nivelNodos++;
                    if(aux.hasChildren()){
                        for(var child : aux.getChildren()){
                            queue.enqueue(child);
                        }
                    }
                }
            }
            return maxNodos;
        }
        else{
            return 0;
        }
    }
}
