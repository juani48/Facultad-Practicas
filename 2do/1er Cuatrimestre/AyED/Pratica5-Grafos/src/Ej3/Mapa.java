package Ej3;

import java.util.ArrayList;
import java.util.LinkedList;
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

    //A
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

    //---------------------b------------------------------------------

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

    //-------------------------c---------------------------------------------

    public List<String> caminoMasCorto(String ciudad1, String ciudad2){
        List<String> list = new ArrayList<>();
        if(!graph.isEmpty()){
            Vertex<String> inicio = graph.search(ciudad1);
            if(inicio != null && graph.search(ciudad2) != null){
                boolean[] visitado = new boolean[graph.getSize()];
                Camino min = new Camino(999, list);
                Camino actual = new Camino(0, new LinkedList<>());
                caminoMasCorto(inicio, ciudad2, visitado, min, actual);
                System.out.println(min.peso);
                list = min.lugares;
            }
        }
        return list;
    }

    private void caminoMasCorto(Vertex<String> vertex, String objetivo, boolean[] visitado, Camino min, Camino actual){
        visitado[vertex.getPosition()] = true;
        actual.lugares.add(vertex.getData());

        if(vertex.getData() == objetivo && actual.peso <= min.peso){
            min.lugares = new LinkedList<>(actual.lugares);
            min.peso = actual.peso;
        }
        int peso = actual.peso;
        List<String> lugaresL = new LinkedList<>(actual.lugares);
        for(var edge : graph.getEdges(vertex)){
            actual.peso += edge.getWeight();
            if(!visitado[edge.getTarget().getPosition()]    ){
                caminoMasCorto(edge.getTarget(), objetivo, visitado, min, actual);
            }
            actual.peso = peso;
            actual.lugares = new LinkedList<>(lugaresL);
        }
        visitado[vertex.getPosition()] = false;
    }

    //-------------------------D---------------------------------------------------------

    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
        List<String> list = new ArrayList<>();
        if(!graph.isEmpty()){
            Vertex<String> inicio = graph.search(ciudad1);
            if(inicio != null){
                boolean[] visitado = new boolean[graph.getSize()];
                Camino min = new Camino(999, new LinkedList<>());
                Camino actual = new Camino(0, new LinkedList<>());
                caminoSinCargarCombustible(inicio, ciudad2, visitado,min, actual, tanqueAuto);
                list = min.lugares;
            }
        }
        return list;
    }

    private void caminoSinCargarCombustible(Vertex<String> vertex, String objetivo, boolean[] visitado, Camino min, Camino actual, int tanqueTotal){
        visitado[vertex.getPosition()] = true;
        actual.lugares.add(vertex.getData());
        if(vertex.getData() == objetivo && actual.peso < min.peso){
            min.lugares = new LinkedList<>(actual.lugares);
            min.peso = actual.peso;
        }
        int peso = actual.peso;
        List<String> lugares = new LinkedList<>(actual.lugares);
        for(var edge : graph.getEdges(vertex)){
            actual.peso += edge.getWeight();
            if(!visitado[edge.getTarget().getPosition()] && actual.peso <= tanqueTotal){
                caminoSinCargarCombustible(edge.getTarget(), objetivo, visitado, min, actual, tanqueTotal);
            } 
            actual.lugares = new LinkedList<>(lugares);
            actual.peso = peso;
        }

        visitado[vertex.getPosition()] = false;
    }

    //-----------------------E-------------------------------------------

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
