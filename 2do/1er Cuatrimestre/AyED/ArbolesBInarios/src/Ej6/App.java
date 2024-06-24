package Ej6;

import Clases.BinaryTree;

public class App {
    public static void main(String[] args) throws Exception {

        Transformacion ej6 = new Transformacion();
        BinaryTree <Integer> tree = ej6.suma();
        tree.byLevels();
    }

}
