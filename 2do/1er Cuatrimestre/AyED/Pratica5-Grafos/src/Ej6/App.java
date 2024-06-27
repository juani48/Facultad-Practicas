package Ej6;

import java.util.List;

import Clases.AdjListGraph;
import Interface.Graph;
import Interface.Vertex;

public class App {
    public static void main(String[] args) throws Exception {
        Graph<String> graph = new AdjListGraph<>();
        Vertex<String> casaCaperusita = graph.createVertex("Casa Caperucita");
        Vertex<String> casaAbuela = graph.createVertex("Casa Abuelita");
        Vertex<String> claro1 = graph.createVertex("Claro 1");
        Vertex<String> claro2 = graph.createVertex("Claro 2");
        Vertex<String> claro3 = graph.createVertex("Claro 3");
        Vertex<String> claro4 = graph.createVertex("Claro 4");
        Vertex<String> claro5 = graph.createVertex("Claro 5");

        graph.connect(casaCaperusita, claro3, 4);
        graph.connect(claro3, casaCaperusita, 4);

        graph.connect(claro3, claro5, 15);
        graph.connect(claro5, claro3, 15);

        graph.connect(casaCaperusita, claro1, 3);
        graph.connect(claro1, casaCaperusita, 3);

        graph.connect(claro1, claro5, 3);
        graph.connect(claro5, claro1, 3);

        graph.connect(claro5, casaAbuela, 4);
        graph.connect(casaAbuela, claro5, 4);

        graph.connect(casaCaperusita, claro2, 4);
        graph.connect(claro2, casaCaperusita, 4);

        graph.connect(claro1, claro2, 4);
        graph.connect(claro2, claro1, 4);

        graph.connect(claro2, claro5, 11);
        graph.connect(claro5, claro2, 11);

        graph.connect(claro2, claro4, 10);
        graph.connect(claro4, claro2, 10);

        graph.connect(claro4, casaAbuela, 9);
        graph.connect(casaAbuela, claro4, 9);

        BuscadorDeCaminos ej6 = new BuscadorDeCaminos(graph);

        List<List<String>> list = ej6.recorridosMasSeguro();
        for(var l : list){
            System.out.println(l);
        }
    }   
}
