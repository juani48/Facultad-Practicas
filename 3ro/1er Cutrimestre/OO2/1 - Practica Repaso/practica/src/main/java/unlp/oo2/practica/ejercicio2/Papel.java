package unlp.oo2.practica.ejercicio2;

public class Papel implements IJugada{

    public Resultado jugar(IJugada jugada){
        return jugada.contraPapel();
    }

    public Resultado contraPapel(){
        return Resultado.Empato;
    }

    public Resultado contraPiedra(){
        return Resultado.Gano;
    }


    public Resultado contraTijera(){
        return Resultado.Pierdo;
    }

}
