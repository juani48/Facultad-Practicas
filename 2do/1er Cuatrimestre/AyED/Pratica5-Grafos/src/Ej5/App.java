package Ej5;

import Clases.AdjListGraph;
import Interface.Graph;
import Interface.Vertex;

public class App {
    public static void main(String[] args) throws Exception {
        Graph<Persona> graph = new AdjListGraph<Persona>();
        Vertex<Persona> abuelo1 = graph.createVertex(new Persona("Abuelo1", false));
        Vertex<Persona> abuelo2 = graph.createVertex(new Persona("Abuelo2", false));
        Vertex<Persona> abuelo3 = graph.createVertex(new Persona("Abuelo3", true));
        Vertex<Persona> abuelo4 = graph.createVertex(new Persona("Abuelo4", false));
        Vertex<Persona> abuelo5 = graph.createVertex(new Persona("Abuelo5", false));
        Vertex<Persona> abuelo6 = graph.createVertex(new Persona("Abuelo6", false));
        Vertex<Persona> abuelo7 = graph.createVertex(new Persona("Abuelo7", false));
        Vertex<Persona> abuelo8 = graph.createVertex(new Persona("Abuelo8", true));
        Vertex<Persona> empleado1 = graph.createVertex(new Persona("Empleado1"));
        Vertex<Persona> empleado2 = graph.createVertex(new Persona("Empleado2"));

        graph.connect(empleado1, abuelo1);
        graph.connect(abuelo1, empleado1);

        graph.connect(empleado1, abuelo7);
        graph.connect(abuelo7, empleado1);

        graph.connect(abuelo1, abuelo4);
        graph.connect(abuelo4, abuelo1);

        graph.connect(abuelo4, abuelo2);
        graph.connect(abuelo2, abuelo4);

        graph.connect(abuelo2, empleado2);
        graph.connect(empleado2, abuelo2);

        graph.connect(empleado2, abuelo6);
        graph.connect(abuelo6, empleado2);

        graph.connect(empleado2, abuelo8);
        graph.connect(abuelo8, empleado2);

        graph.connect(abuelo8, abuelo7);
        graph.connect(abuelo7, abuelo8);

        graph.connect(abuelo8, abuelo5);
        graph.connect(abuelo5, abuelo8);

        graph.connect(abuelo5, abuelo3);
        graph.connect(abuelo3, abuelo5);

        graph.connect(abuelo3, abuelo6);
        graph.connect(abuelo6, abuelo3);

        System.out.println("\nDistancia 1:");
        System.out.println(Banco.BFS(graph,empleado1.getData(), 1));
        System.out.println(Banco.BFS(graph,empleado2.getData(), 1));

        System.out.println("\nDistancia 2:");
        System.out.println(Banco.BFS(graph,empleado1.getData(), 2));
        System.out.println(Banco.BFS(graph,empleado2.getData(), 2));

        System.out.println("\nDistancia 4:");
        System.out.println(Banco.BFS(graph,empleado1.getData(), 4));
        System.out.println(Banco.BFS(graph,empleado2.getData(), 4));
    }
}
