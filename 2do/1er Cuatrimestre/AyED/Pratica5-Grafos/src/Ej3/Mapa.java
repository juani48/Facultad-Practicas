package Ej3;

import java.util.ArrayList;
import java.util.List;

import Clases.AdjListGraph;
import Clases.Queue;
import Interface.Graph;
import Interface.Vertex;

public class Mapa {
 
    private Graph<String> graph = new AdjListGraph<String>();

    public Mapa(Graph<String> graph){
        this.graph = graph;
    }

    public List<String> devolverCamino (String ciudad1, String ciudad2){ //DFS
        List<String> list = new ArrayList<String>();
        if(!graph.isEmpty()){
            boolean[] visitado = new boolean[graph.getSize()];
            Vertex<String> inicio = graph.search(ciudad1);
            if(inicio != null){
                devolverCamino(inicio, ciudad2, list, visitado);
            }
        }
        return list;
    }

    private boolean devolverCamino(Vertex<String> vertex, String objetivo, List<String> list, boolean[] visitado){
        list.add(vertex.getData());
        visitado[vertex.getPosition()] = true;
        if(vertex.getData() == objetivo){
            return true;
        }
        for(var edge : graph.getEdges(vertex)){
            if(!visitado[edge.getTarget().getPosition()]){
                if(devolverCamino(edge.getTarget(), objetivo, list, visitado)){
                    return true;
                }
            }
        }
        list.remove(list.size() -1);
        return false;
    }

    //---------------------------------------------------------------

    public List<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades){
        List<String> list = new ArrayList<>();
        if(!graph.isEmpty()){
            Vertex<String> inicio = graph.search(ciudad1);
            if(inicio != null && !ciudades.contains(inicio.getData())){
                boolean[] visitado = new boolean[graph.getSize()];
                devolverCaminoExceptuando(inicio, ciudad2, ciudades, visitado, list);
            }
        }
        return list;
    }

    private boolean devolverCaminoExceptuando(Vertex<String> vertex, String objetivo, List<String> ciudades, boolean[] visitado, List<String> list){
        visitado[vertex.getPosition()] = true;
        if(!ciudades.contains(vertex.getData())){
            list.add(vertex.getData());
            if(vertex.getData() == objetivo){
                return true;
            }
            for(var edge : graph.getEdges(vertex)){
                if(!visitado[edge.getTarget().getPosition()]){
                    if(devolverCaminoExceptuando(edge.getTarget(), objetivo, ciudades, visitado, list)){
                        return true;
                    }
                    
                }
            }
            list.remove(list.size() - 1);
        }
        return false;
    }

    //----------------------------------------------------------------------

    public List<String> caminoMasCorto(String ciudad1, String ciudad2){
        List<String> list = new ArrayList<>();
        if(!graph.isEmpty()){
            Vertex<String> inicio = graph.search(ciudad1);
            if(inicio != null){
                boolean[] visitado = new boolean[graph.getSize()];
                List<String> minimo = new ArrayList<>();
                caminoMasCorto(inicio, ciudad2, visitado, list, minimo, 0, 999);
            }
        }
        return list;
    }

    private void caminoMasCorto(Vertex<String> vertex, String objetivo, boolean[] visitado, List<String> list, List<String> minimo, int total, int min){
        visitado[vertex.getPosition()] = true;
        minimo.add(vertex.getData());

        if(vertex.getData() == objetivo && total < min){
            list.removeAll(list);
            list.addAll(minimo);
            min = total;
        }
        for(var edge : graph.getEdges(vertex)){
            total += edge.getWeight();
            if(!visitado[edge.getTarget().getPosition()] && total < min){
                caminoMasCorto(edge.getTarget(), objetivo, visitado, list, minimo, total, min);
            }
        }
        minimo.remove(minimo.size() - 1);
        visitado[vertex.getPosition()] = false;
    }

    //----------------------------------------------------------------------------------

    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
        List<String> list = new ArrayList<>();
        if(!graph.isEmpty()){
            Vertex<String> inicio = graph.search(ciudad1);
            if(inicio != null){
                List<String> camino = new ArrayList<>();
                boolean[] visitado = new boolean[graph.getSize()];
                caminoSinCargarCombustible(inicio, ciudad2, visitado,list, camino, 999, 0, tanqueAuto);
            }
        }
        return list;
    }

    private void caminoSinCargarCombustible(Vertex<String> vertex, String objetivo, boolean[] visitado, List<String> list, List<String> camino, int tanqueMinimo, int tanqueUsado, int tanqueTotal){
        visitado[vertex.getPosition()] = true;
        camino.add(vertex.getData());
        if(vertex.getData() == objetivo && tanqueUsado < tanqueMinimo){
            list.removeAll(list);
            list.addAll(camino);
            tanqueMinimo = tanqueUsado;
        }
        for(var edge : graph.getEdges(vertex)){
            int peso = tanqueUsado + edge.getWeight();
            if(!visitado[edge.getTarget().getPosition()] && tanqueUsado <= tanqueTotal){
                caminoSinCargarCombustible(edge.getTarget(), objetivo, visitado, list, camino, tanqueMinimo, peso, tanqueTotal);
            } 
        }
        camino.remove(camino.size() - 1);
        visitado[vertex.getPosition()] = false;
    }

    //------------------------------------------------------------------

    private Vertex<String> caminoConMenorCargaDeCombustible(String objetivo){
        Queue<Vertex<String>> queue = new Queue<>();
        boolean[] visitado = new boolean[graph.getSize()];
        for(int i = 0; i < graph.getSize(); i++){

            if(!visitado[i]){
                queue.enqueue(graph.getVertex(i));
                while(!queue.isEmpty()){
                    Vertex<String> aux = queue.dequeue();
                    if(aux.getData() == objetivo){
                        return aux;
                    }
                    for(var edge : graph.getEdges(aux)){
                        queue.enqueue(edge.getTarget());
                    }
                }
            }
        }
        return null;
    }

    public List<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto){
        List<String> list = new ArrayList<>();
        if(!graph.isEmpty()){
            Vertex<String> inicio = caminoConMenorCargaDeCombustible(ciudad1);
            if(inicio != null){
                List<String> camino = new ArrayList<>();
                boolean[] visitado = new boolean[graph.getSize()];
                caminoConMenorCargaDeCombustible(inicio, ciudad2, visitado, list, camino, tanqueAuto, 999, 0);
            }
        }
        return list;
    }

    private void caminoConMenorCargaDeCombustible(Vertex<String> vertex, String objtivo, boolean[] visitado, 
    List<String> list, List<String> camino, int tanqueAuto, int cargasMinimas, int cargasActuales){
        cargasActuales++;
        visitado[vertex.getPosition()] = true;
        camino.add(vertex.getData());
        if(vertex.getData() == objtivo && cargasActuales < cargasMinimas){
            list.removeAll(list);
            list.addAll(camino);
            cargasMinimas = cargasActuales;
        }
        for(var edge : graph.getEdges(vertex)){
            if(!visitado[edge.getTarget().getPosition()] && edge.getWeight() <= tanqueAuto){
                caminoConMenorCargaDeCombustible(edge.getTarget(), objtivo, visitado, list, camino, tanqueAuto, cargasMinimas, cargasActuales);
            }
        }
        camino.remove(camino.size() - 1);
        visitado[vertex.getPosition()] = false;
        cargasActuales--;
    }
}
