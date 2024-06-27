package Ej6;

import Clases.BinaryTree;

public class Transformacion {

    private BinaryTree<Integer> tree = new BinaryTree<Integer>();

    public Transformacion(){
        for(int i = 0; i < 15; i++){
            tree.add(i);
        }
        tree.byLevels();
    }

    public BinaryTree<Integer> suma(){
        if(!this.tree.isEmpty()){
            suma(this.tree);
            return tree;
        }
        else{
            return null;
        }
    }

    private int suma(BinaryTree<Integer> tree){
        if(!tree.isLeaf()){
            int HD = 0;
            int HI = 0;
            if(tree.hasLeftChild()){
                HD = suma(tree.getLeftChild());
            }
            if(tree.hasRightChild()){
                HI = suma(tree.getRightChild());
            }
            int aux = tree.getData();
            tree.setData(HD + HI);
            return tree.getData() + aux;
        }
        else{
            int aux = tree.getData();
            tree.setData(0);
            return aux;
        }
    }
}
