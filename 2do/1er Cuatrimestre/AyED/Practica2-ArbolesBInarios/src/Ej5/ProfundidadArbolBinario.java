package Ej5;

import Clases.BinaryTree;
import Clases.Queue;

public class ProfundidadArbolBinario {

    private BinaryTree<Integer> tree = new BinaryTree<Integer>();

    public ProfundidadArbolBinario(){
        for(int i = 0; i < 15; i++){
            tree.add(i);
        }
        tree.byLevels();
    }

    public int sumarElementosProfundidad(int profundidad){
        Queue<BinaryTree<Integer>> queue = new Queue<BinaryTree<Integer>>();
        queue.enqueue(tree);
        queue.enqueue(null);
        int lvl = 0; int total = 0;
        while(!queue.isEmpty() && lvl <= profundidad){
            BinaryTree<Integer> aux = queue.dequeue();
            if(aux == null){
                if(!queue.isEmpty()){
                    queue.enqueue(aux);
                }
                lvl++;
            }
            else{
                if(lvl == profundidad){
                    total += aux.getData();
                }
                if(aux.hasLeftChild()){
                    queue.enqueue(aux.getLeftChild());
                }
                if(aux.hasRightChild()){
                    queue.enqueue(aux.getRightChild());
                }
            }
        }
        return total;
    }
}
