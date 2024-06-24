package Ej7;

import Clases.BinaryTree;

public class ParcialArbol {
    private BinaryTree<Integer> tree = new BinaryTree<Integer>(2);

    public ParcialArbol(){
        //Construyo el arbol del ejemplo
		BinaryTree<Integer> a = new BinaryTree<Integer>(6);
		BinaryTree<Integer> b = new BinaryTree<Integer>(55);
		BinaryTree<Integer> c = new BinaryTree<Integer>(11);
		a.addLeftChild(b);
		a.addRightChild(c);
		c = new BinaryTree<Integer>(-3);
		b = new BinaryTree<Integer>(23);
		b.addLeftChild(c);
		c = new BinaryTree<Integer>(7);
		c.addLeftChild(b);
		c.addRightChild(a);
		this.tree.addLeftChild(c);
		a = new BinaryTree<Integer>(19);
		b = new BinaryTree<Integer>(4);
		c = new BinaryTree<Integer>(18);
		b.addLeftChild(c);
		a.addRightChild(b);
		c = new BinaryTree<Integer>(-5);
		c.addLeftChild(a);
		this.tree.addRightChild(c);
        
        tree.byLevels();
    }


    public boolean isLeftTree(int num){
        if(!this.tree.isEmpty()){
            BinaryTree<Integer> aux = isLeftTree(tree, num);
            if(aux != null){
                System.out.println(aux.getData());
                int HD = -1;
                int HI = -1;
                if(aux.hasLeftChild()){
                    HI = isLeftTree(aux.getLeftChild());
                }
                if(aux.hasRightChild()){
                    HD = isLeftTree(aux.getRightChild());
                }
                return HD < HI;
            }
        }
        return false;
    }

    private BinaryTree<Integer> isLeftTree(BinaryTree<Integer> tree, int num){
        if(tree.getData() == num){
            return tree;
        }
        else{
            BinaryTree<Integer> aux = null;
            if(tree.hasLeftChild()){
                aux = isLeftTree(tree.getLeftChild(), num);
            }
            if(tree.hasRightChild() && aux == null ){
                aux = isLeftTree(tree.getRightChild(), num);
            }
            return aux;
        }
    }

    private int isLeftTree(BinaryTree<Integer> tree){
        int total = 0;
        if(tree.hasLeftChild() && tree.hasRightChild()){
            return total;
        }
        else{
            if(!tree.isLeaf()){
                if(tree.hasLeftChild()){
                    total += isLeftTree(tree.getLeftChild()) + 1;
                }
                else{
                    total += isLeftTree(tree.getRightChild()) + 1;
                }
            }
            return total;
        }
    }
}
