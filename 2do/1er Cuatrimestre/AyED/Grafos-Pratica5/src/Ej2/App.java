package Ej2;

import Clases.AdjListGraph;
import Interface.Graph;
import Interface.Vertex;

public class App {
    public static void main(String[] args) throws Exception {
        Graph<String> grafito = new AdjListGraph<String>();
		Vertex<String> d = grafito.createVertex("D");
		Vertex<String> b = grafito.createVertex("B");
		Vertex<String> c = grafito.createVertex("C");
		Vertex<String> r = grafito.createVertex("R");
		Vertex<String> h = grafito.createVertex("H");
		Vertex<String> a = grafito.createVertex("A");
		Vertex<String> t = grafito.createVertex("T");
		grafito.connect(d, c);
		grafito.connect(d, b);
		grafito.connect(c, r);
		grafito.connect(b, h);
		grafito.connect(r, h);
		grafito.connect(h, d);
		grafito.connect(h, t);
		grafito.connect(h, a);
		//O(V+E)
		System.out.println(Recorridos.DFS(grafito));
		//O(V+E)
		System.out.println(Recorridos.BFS(grafito));
    }
}
