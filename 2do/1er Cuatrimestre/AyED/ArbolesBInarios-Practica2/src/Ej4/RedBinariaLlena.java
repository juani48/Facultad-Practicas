package Ej4;

import Clases.BinaryTree;

public class RedBinariaLlena {

    private BinaryTree<Integer> tree = new BinaryTree<Integer>();

    public RedBinariaLlena(){
        for(int i = 0; i < 15; i++){
            tree.add(i);
        }
        this.tree.byLevels();
    }



    public int retardReenvio(){
        if(!tree.isEmpty()){
            return retardReenvio(this.tree);
        }
        else{
            return 0;
        }
    }

    private int retardReenvio(BinaryTree<Integer> tree){
        if(!tree.isLeaf()){
            int HD = 0;
            int HI = 0;
            if(tree.hasLeftChild()){
                HI = retardReenvio(tree.getLeftChild());
            }
            if(tree.hasRightChild()){
                HD = retardReenvio(tree.getRightChild());
            }
            if(HD < HI){
                return HI + tree.getData();
            }
            else{
                return HD + tree.getData();
            }
        }
        else{
            return tree.getData();
        }
    }
}
