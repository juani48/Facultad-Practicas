package Ej3;

import java.util.LinkedList;
import java.util.List;

import Clases.BinaryTree;

public class ContadorArbol {

    private BinaryTree<Integer> tree = new BinaryTree<Integer>();

    public ContadorArbol(){
        for(int i = 0; i < 10; i++){
            tree.add(i);
        }
    }

    public List<Integer> numeroPares_Post(){
        if(!tree.isEmpty()){
            List<Integer> list = new LinkedList<Integer>();
            return numeroPares_Post(this.tree, list);
        }
        else{
            return null;
        }
    }

    private List<Integer> numeroPares_Post(BinaryTree<Integer> tree, List<Integer> list){
        if(tree.hasLeftChild()){
            numeroPares_Post(tree.getLeftChild(), list);
        }
        if(tree.hasRightChild()){
            numeroPares_Post(tree.getRightChild(), list);
        }
        if(tree.getData() % 2 == 0){
            list.add(tree.getData());
        }
        return list;
    }

    public List<Integer> numeroPares_In(){
        if(!tree.isEmpty()){
            List<Integer> list = new LinkedList<Integer>();
            return numeroPares_In(this.tree, list);
        }
        else{
            return null;
        }
    }

    private List<Integer> numeroPares_In(BinaryTree<Integer> tree, List<Integer> list){
        if(tree.hasLeftChild()){
            numeroPares_Post(tree.getLeftChild(), list);
        }
        if(tree.getData() % 2 == 0){
            list.add(tree.getData());
        }
        if(tree.hasRightChild()){
            numeroPares_Post(tree.getRightChild(), list);
        }
        return list;
    }
}
