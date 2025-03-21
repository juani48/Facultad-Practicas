package unlp.oo2.practica.ejercicio2;

public class Jugador {

    private IJugada jugada;

    public Jugador(IJugada jugada){
        this.jugada = jugada;
    }

    public IJugada getJugada(){ return this.jugada;}

    public Resultado partido(Jugador jugador){
        Resultado resultado = jugador.partido(this.getJugada());
        if(resultado == Resultado.Gano) {
        	return Resultado.Pierdo;
        }
        else if (resultado == Resultado.Pierdo) {
        	return Resultado.Gano;
        }
        else {
        	return resultado;
        }
    }

    private Resultado partido(IJugada jugada){
        return jugada.jugar(this.getJugada());
    }
}
