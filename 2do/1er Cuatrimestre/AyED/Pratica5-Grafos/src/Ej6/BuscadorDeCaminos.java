package Ej6;

import java.util.LinkedList;
import java.util.List;

import Clases.AdjListGraph;
import Clases.Queue;
import Interface.Graph;
import Interface.Vertex;

public class BuscadorDeCaminos {

    private Graph<String> bosque = new AdjListGraph<String>();

    public BuscadorDeCaminos(Graph<String> graph){
        bosque = graph;
    }

    public List <List<String>> recorridosMasSeguro(){
        List<List<String>> list = new LinkedList<>();
        if(!bosque.isEmpty()){
            var inicio = bosque.search("Casa Caperucita");
            if(inicio != null){
                System.out.println("Encontre la casa de caperusita");
                List<String> camino = new LinkedList<>();
                boolean[] visitado = new boolean[bosque.getSize()];
                recorridosMasSeguro(inicio, "Casa Abuelita", visitado, list, camino);
            }
        }
        return list;
    }

    private void recorridosMasSeguro(Vertex<String> vertex, String objetivo, boolean[] visitado,
    List<List<String>> list, List<String> camino){
        visitado[vertex.getPosition()] = true;
        camino.add(vertex.getData());
        if(vertex.getData() == objetivo){
            list.add(new LinkedList<>(camino));
        }
        for(var edge : bosque.getEdges(vertex)){
            if(!visitado[edge.getTarget().getPosition()] && edge.getWeight() < 5){
                recorridosMasSeguro(edge.getTarget(), objetivo, visitado, list, camino);
            }
        }
        visitado[vertex.getPosition()] = false;
        camino.remove(camino.size() - 1);
    }
}
