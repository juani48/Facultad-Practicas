package Ej4;

import java.util.ArrayList;
import java.util.List;

import Interface.Edge;
import Interface.Graph;
import Interface.Vertex;

public class VisitaOslo {

    public static List<String> paseoEnBici(Graph<String> lugares, String inicio, String destino, int maxTiempo, List<String> lugaresRestringidos){
        List<String> list = new ArrayList<>();
        if(!lugares.isEmpty()){
            Vertex<String> vertex = lugares.search(inicio);
            if(vertex != null){
                List<String> camino = new ArrayList<>();
                boolean[] visitado = new boolean[lugares.getSize()];
                paseoEnBici(lugares, vertex, visitado, destino, list, camino, maxTiempo, 0, lugaresRestringidos);
            }
        }
        return list;
    }

    private static void paseoEnBici(Graph<String> lugares, Vertex<String> vertex, boolean[] visitado,
    String objetivo, List<String> list, List<String> camino, int maxTiempo, int tiempoTotal, List<String> lugaresRestringidos){

        visitado[vertex.getPosition()] = true;
        camino.add(vertex.getData());
        if(vertex.getData() == objetivo && tiempoTotal < maxTiempo){
            list.addAll(camino);
            return;
        }
        for(Edge<String> edge : lugares.getEdges(vertex)){
            
            if(!visitado[edge.getTarget().getPosition()] && !lugaresRestringidos.contains(edge.getTarget().getData()) && (tiempoTotal + edge.getWeight()) <= maxTiempo){
                paseoEnBici(lugares, edge.getTarget(), visitado, objetivo, list, camino, maxTiempo, (tiempoTotal + edge.getWeight()), lugaresRestringidos);
            }
        }
        camino.remove(camino.size() - 1);
        visitado[vertex.getPosition()] = false;
    }
}
