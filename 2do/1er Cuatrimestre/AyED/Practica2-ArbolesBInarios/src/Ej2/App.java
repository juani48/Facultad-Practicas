package Ej2;

public class App {
    public static void main(String[] args) throws Exception {
        Ej2 ej1 = new Ej2();

        ej1.tree.byLevels();
        System.out.println(ej1.EsHoja());
        ej1.Espejo();
        ej1.tree.byLevels();
        System.out.println("------------------");
        ej1.entreNiveles(1, 2);
    }
}
