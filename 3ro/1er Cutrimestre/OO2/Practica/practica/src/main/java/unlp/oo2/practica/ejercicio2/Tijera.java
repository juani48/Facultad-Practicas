package unlp.oo2.practica.ejercicio2;

public class Tijera implements IJugada {

    public Resultado jugar(IJugada jugada){
        return jugada.contraTijera();
    }

    public Resultado contraPapel(){
        return Resultado.Gano;
    }

    public Resultado contraPiedra(){
        return Resultado.Pierdo;
    }


    public Resultado contraTijera(){
        return Resultado.Empato;
    }

}
