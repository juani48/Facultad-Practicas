package Ej2;

import Clases.GeneralTree;
import Clases.Queue;

import java.util.LinkedList;
import java.util.List;

public class RecorridosAG {

    public static List<Integer> PreOrden(GeneralTree <Integer> tree ,int num){
        if(!tree.isEmpty()){
            List<Integer> list = new LinkedList<Integer>();
            PreOrden(tree, num, list);
            return list;
        }
        else{
            return null;
        }
    }

    private static void PreOrden(GeneralTree<Integer> tree, int num, List<Integer> list){
        if(tree.getData() % 2 != 0 && tree.getData() > num){
            list.add(tree.getData());
        }
        if(tree.hasChildren()){
            for(var child : tree.getChildren()){
                PreOrden(child, num, list);
            }
        }
    }

    //------------------------------------------------------------------

    public static List<Integer> InOrden (GeneralTree <Integer> tree, int num){
        if(!tree.isEmpty()){
            List<Integer> list = new LinkedList<Integer>();
            InOrden(tree, num, list);
            return list;
        }
        else{
            return null;
        }
    }

    private static void InOrden(GeneralTree <Integer> tree, int num, List<Integer> list){
        
        if(tree.hasChildren()){
            boolean ok = false;
            for(var child : tree.getChildren()){
                InOrden(child, num, list);
                if(!ok && tree.getData() % 2 != 0 && tree.getData() > num){
                    list.add(tree.getData());
                    
                }
                ok = true;
            }
        }
        else if(tree.getData() % 2 != 0 && tree.getData() > num){
            list.add(tree.getData());
        }
        
    }

    //-------------------------------------------------

    public static List<Integer> PostOrden (GeneralTree <Integer> tree, int num){
        if(!tree.isEmpty()){
            List<Integer> list = new LinkedList<Integer>();
            PostOrden(tree, num, list);
            return list;
        }
        else{
            return null;
        }
    }

    private static void PostOrden(GeneralTree <Integer> tree, int num, List<Integer> list){
        if(tree.hasChildren()){
            for(var child : tree.getChildren()){
                PostOrden(child, num, list);
            }
        }
        if(tree.getData() % 2 != 0 && tree.getData() > num){
            list.add(tree.getData());
        }
    }

    //--------------------------------------------

    public static List<Integer> PorNiveles(GeneralTree <Integer> tree, int num){
        if(!tree.isEmpty()){
            Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
            List<Integer> list = new LinkedList<Integer>();
            queue.enqueue(tree);
            while(!queue.isEmpty()){
                GeneralTree<Integer> aux = queue.dequeue();
                if(aux.getData() % 2 != 0 && aux.getData() > num){
                    list.add(aux.getData());
                }
                if(aux.hasChildren()){
                    for(var child : aux.getChildren()){
                        queue.enqueue(child);
                    }
                }
            }
            return list;
        }
        else{
            return null;
        }
    }
}
