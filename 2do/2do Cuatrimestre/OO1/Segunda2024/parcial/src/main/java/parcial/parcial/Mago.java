package Segunda2024.parcial.src.main.java.parcial.parcial;

public class Mago implements IRol {

    @Override
    public int valorBase(Personaje personaje) {
        return Math.abs( (personaje.getInteligencia() + personaje.getNivel()) * 2 );
    }

    @Override
    public void incremento(Personaje personaje) {
        personaje.setInteligencia( Math.abs( 3/2 * personaje.getNivel()));
    }
}
