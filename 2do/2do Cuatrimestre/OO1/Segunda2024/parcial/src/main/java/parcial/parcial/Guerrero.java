package Segunda2024.parcial.src.main.java.parcial.parcial;

public class Guerrero implements IRol {

    @Override
    public int valorBase(Personaje personaje) {
        return Math.abs( (personaje.getFuerza() * 2) + personaje.getNivel() + personaje.getInteligencia());
    }

    @Override
    public void incremento(Personaje personaje) {
        personaje.setInteligencia( Math.abs( personaje.getNivel() / 6));
    }

}
