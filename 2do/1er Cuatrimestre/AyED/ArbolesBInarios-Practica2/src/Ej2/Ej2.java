package Ej2;

import Clases.Queue;

import Clases.BinaryTree;

public class Ej2 {

    public BinaryTree<Integer> tree = new BinaryTree<Integer>();

    public Ej2(){
        for(int i = 0;i < 10; i++){
            tree.add(i);
        }
    }

    public int EsHoja(){
        if(!tree.isEmpty()){
            return EsHoja(tree);
        }
        else{
            return 0;
        }
    } 

    private int EsHoja(BinaryTree<Integer> tree){
        if(tree.isLeaf()){
            return 1;
        }
        else{
            int HI = 0;
            int HD = 0;
            if(tree.hasLeftChild()){
                HI = EsHoja(tree.getLeftChild());
            }
            if(tree.hasRightChild()){
                HD = EsHoja(tree.getRightChild());
            }
            return HI + HD;
        }
    }

    public void Espejo(){
        if(!tree.isEmpty()){
            tree = Espejo(tree);
        }
        else{
            return;
        }
    }

    private BinaryTree<Integer> Espejo(BinaryTree<Integer> tree){
        BinaryTree<Integer> newTree = new BinaryTree<Integer>(tree.getData());
        if(!tree.isLeaf()){
            if(tree.hasLeftChild()){
                newTree.addRightChild(Espejo(tree.getLeftChild()));
            }
            if(tree.hasRightChild()){
                newTree.addLeftChild(Espejo(tree.getRightChild()));
            }
        }
        return newTree;
    }

    public void entreNiveles(int inicio, int fin){
        if(!tree.isEmpty()){
            if(inicio > fin){
                int aux = fin;
                fin = inicio;
                inicio = aux;
            }
            Queue<BinaryTree<Integer>> queue = new Queue<BinaryTree<Integer>>();
            queue.enqueue(tree);
            queue.enqueue(null);
            int lvl = 0;
            while(!queue.isEmpty() && lvl <= fin){
                BinaryTree<Integer> aux = queue.dequeue();
                if(aux == null){
                    if(!queue.isEmpty()){
                        queue.enqueue(aux);
                    }
                    lvl++;
                    System.out.println("");
                }
                else{
                    if(inicio <= lvl && lvl <= fin){
                        System.out.print(aux.toString()+"-----");
                    }

                    if(aux.hasLeftChild() && lvl <= fin){
                        queue.enqueue(aux.getLeftChild());
                    }
                    if(aux.hasRightChild() && lvl <= fin){
                        queue.enqueue(aux.getRightChild());
                    }
                }
            }
        }
    }

}
