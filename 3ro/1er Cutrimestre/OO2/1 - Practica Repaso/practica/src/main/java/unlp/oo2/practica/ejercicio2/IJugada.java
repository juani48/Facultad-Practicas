package unlp.oo2.practica.ejercicio2;

public interface IJugada {
    public Resultado jugar(IJugada jugada);
    public Resultado contraPapel();
    public Resultado contraPiedra();
    public Resultado contraTijera();
}
