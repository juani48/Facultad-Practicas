package Ej2;

import Clases.GeneralTree;
import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        GeneralTree<Integer> tree = GeneralTree.randomTree(12);
		List<Integer> list = new LinkedList<Integer>();

        tree.byLevels();

        list = RecorridosAG.PreOrden(tree, 10);

        for(var x : list){
            System.out.println(x);
        }
    }
}
