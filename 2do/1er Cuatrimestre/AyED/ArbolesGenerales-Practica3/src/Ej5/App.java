package Ej5;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {

        Ej5 ej5 = new Ej5();

        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        System.out.println(ej5.esAncestro(a, b));
        s.close();
    }

}
