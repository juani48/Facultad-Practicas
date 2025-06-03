package Ej2;

import java.util.LinkedList;
import java.util.List;

import Clases.Queue;
import Interface.Graph;
import Interface.Vertex;

public class Recorridos {

    public static List<String> DFS (Graph<String> graph){
        List<String> list = new LinkedList<String>();
        if(!graph.isEmpty()){
            boolean[] visitados = new boolean[graph.getSize()];
            for(int i = 0; i < graph.getSize(); i++){
                if(!visitados[i]){
                    DFS(graph, visitados, graph.getVertex(i), list);
                }
            }
        }
        return list;
    } 

    public static void DFS(Graph<String> graph, boolean[] visitado, Vertex<String> vertex, List<String> list){
        
        visitado[vertex.getPosition()] = true;
        list.add(vertex.getData());
        
        for(var edge : graph.getEdges(vertex)){
            if(!visitado[edge.getTarget().getPosition()]){
                DFS(graph, visitado, edge.getTarget(), list);
            }
        }
    }

    //-------------------------------------------------------------------

    public static List<String> BFS (Graph<String> graph){
        List<String> list = new LinkedList<>();
        if(!graph.isEmpty()){
            Queue<Vertex<String>> queue = new Queue<>();
            boolean[] visitado = new boolean[graph.getSize()];

            for(int i = 0; i < graph.getSize(); i++){

                if(!visitado[i]){

                    queue.enqueue(graph.getVertex(i));
                    queue.enqueue(null);
                    while(!queue.isEmpty()){
                        
                        Vertex<String> vertex = queue.dequeue();
                        if(vertex != null){
                            visitado[vertex.getPosition()] = true;
                            list.add(vertex.getData()); 

                            for(var edge : graph.getEdges(vertex)){
                                if(!visitado[edge.getTarget().getPosition()]){
                                    queue.enqueue(edge.getTarget());
                                }  
                            }
                        }
                        else{
                            if(!queue.isEmpty()){
                                queue.enqueue(null);
                            }
                        }
                                
                    }
                }                
            }
        }
        return list;
    }
}
