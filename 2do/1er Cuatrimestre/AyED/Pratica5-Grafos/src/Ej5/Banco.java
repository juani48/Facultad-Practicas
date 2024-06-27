package Ej5;

import java.util.LinkedList;
import java.util.List;

import Clases.Queue;
import Interface.Graph;
import Interface.Vertex;

public class Banco {

    public static List<Persona> BFS (Graph<Persona> graph, Persona empleado, int distnacia){
        List<Persona> list = new LinkedList<>();
        if(!graph.isEmpty()){
            Vertex<Persona> vertex = graph.search(empleado);
            if(vertex != null){
                Queue<Vertex<Persona>> queue = new Queue<>();
                Queue<Integer> levels = new Queue<>();
                boolean[] visitado = new boolean[graph.getSize()];
                queue.enqueue(vertex);
                levels.enqueue(0);
                while(!queue.isEmpty()){
                    var aux = queue.dequeue();
                    int lvl = levels.dequeue();
                    if(!visitado[aux.getPosition()] && lvl <= distnacia ){
                        visitado[aux.getPosition()] = true;
                        
                        if(aux.getData().isJulibado() && !aux.getData().recivioJubilacion()){
                            list.add(aux.getData());
                        }
                        if(list.size() == 40){
                            return list;
                        }
                        for(var edge : graph.getEdges(aux)){
                            queue.enqueue(edge.getTarget());
                            levels.enqueue(lvl+1);
                        }
                    }

                }
            }
            
        }
        return list;
    }
}
