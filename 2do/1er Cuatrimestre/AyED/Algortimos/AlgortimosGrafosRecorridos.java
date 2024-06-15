import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Ej2.Queue;
import Grafos.Edge;
import Grafos.Grafo;
import Grafos.Vertex;

public class AlgortimosExamen {

    public static void dfs(Grafo<Integer> grafo){
        if(!grafo.isEmpty()){
            boolean[] verticesVistos = new boolean[grafo.getSize()];
            System.out.println("INICIO DFS");
            for(int i = 0; i < grafo.getSize(); i++){
                if(!verticesVistos[i]){
                    dfs(grafo, verticesVistos, grafo.getVertex(i));
                }
            }
        }
        
        //return
    }

    private static void dfs(Grafo<Integer> grafo, boolean[] verticesVistos, Vertex<Integer> vertice){
        verticesVistos[vertice.getPosition()] = true;
        //calcualr
        System.out.println(vertice.getData());

        List<Edge<Integer>> adyacentes = grafo.getEdges(vertice);
        for(Edge<Integer> arista : adyacentes){
            if(!verticesVistos[arista.getTarget().getPosition()]){
                dfs(grafo, verticesVistos, arista.getTarget());
            }
        }
    }

    public static void bfs(Grafo<Integer> grafo){
        if(!grafo.isEmpty()){
            Queue<Vertex<Integer>> queueVertices = new Queue<Vertex<Integer>>();
            boolean[] verticesVistos = new boolean[grafo.getSize()];
            System.out.println("INICIO BFS");

            for(int i = 0; i < grafo.getSize(); i++){
                if(!verticesVistos[i]){
                    queueVertices.enqueue(grafo.getVertex(i));

                    while(!queueVertices.isEmpty()){
                        Vertex<Integer> aux = queueVertices.dequeue();
                        if(!verticesVistos[aux.getPosition()]){
                            verticesVistos[aux.getPosition()] = true;
                            //calcular
                            System.out.println(aux.getData());
                            List<Edge<Integer>> adyacentes = grafo.getEdges(aux);
                            for(Edge<Integer> arista : adyacentes){
                                queueVertices.enqueue(arista.getTarget());
                            }
                        }
                    }
                }
            }
            //return
        }
        
    }
    //return list
    public List<Integer> CaminoMinimo(Grafo<Integer> grafo, int inicio, int fin){
        if(!grafo.isEmpty()){
            Vertex<Integer> origen = grafo.getVertex(inicio);
            Vertex<Integer> destino = grafo.getVertex(fin);

            if(origen != null && destino != null){
                //delcaro lista 
                //declaro caminoACT
                List<Integer> list = new ArrayList<Integer>();
                List<Integer> camino = new ArrayList<Integer>();
                boolean[] visitados = new boolean[grafo.getSize()];
                dijkstra(grafo, origen, destino, visitados, list, camino, 0, 999);

                return list;
                
            }
        }
        return null;
    }

    private void dijkstra(Grafo<Integer> grafo, Vertex<Integer> origen, Vertex<Integer> destino, boolean[] visitados, List<Integer> list, List<Integer> camino, int total, int min){
        visitados[origen.getPosition()] = true;
        camino.add(origen.getData());

        //agragar condiciones extras
        if(origen == destino && total < min){
            list.removeAll(list);
            list.addAll(camino);
            min = total;
        }
        for(Edge<Integer> edge : grafo.getEdges(origen)){
            total += edge.getWeight();
            if(!visitados[edge.getTarget().getPosition()] && total < min){
                dijkstra(grafo, edge.getTarget(), destino, visitados, list, camino, total, min);
            }
        }
        //volver a visitar en caso de que haya un camino mas corto
        camino.remove(camino.size() - 1);
        visitados[origen.getPosition()] = false;
       
    }
}
