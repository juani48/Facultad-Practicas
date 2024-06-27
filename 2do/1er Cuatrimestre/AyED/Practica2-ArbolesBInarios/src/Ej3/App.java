package Ej3;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        ContadorArbol ej3 = new ContadorArbol();

        List<Integer> list = ej3.numeroPares_Post();
        
        for(var num : list){
            System.out.println(num);
        }

        System.out.println("---------------");

        list = ej3.numeroPares_In();
        
        for(var num : list){
            System.out.println(num);
        }
    }
}
