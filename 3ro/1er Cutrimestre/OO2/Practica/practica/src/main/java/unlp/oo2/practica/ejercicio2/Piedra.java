package unlp.oo2.practica.ejercicio2;

public class Piedra implements IJugada{

    public Resultado jugar(IJugada jugada){
        return jugada.contraPiedra();
    }

    public Resultado contraPapel(){
        return Resultado.Pierdo;
    }

    public Resultado contraPiedra(){
        return Resultado.Empato;
    }

    public Resultado contraTijera(){
        return Resultado.Gano;
    }

}
