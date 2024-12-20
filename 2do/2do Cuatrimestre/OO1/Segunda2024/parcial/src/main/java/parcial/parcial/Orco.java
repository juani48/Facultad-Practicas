package Segunda2024.parcial.src.main.java.parcial.parcial;

public class Orco extends Personaje {

    public Orco(String nombre, IRol rol){
        super(nombre, 1, 2, 1, rol);
    }

    @Override
    public void subirNivel() {
        super.subirNivel();
        if(this.getNivel() % 3 == 0){
            this.getRol().incremento(this);
        }
    }

    @Override
    public int poder(int hora) {
        int poder = this.getRol().valorBase(this);
        if(!this.esDia(hora)){
            poder *= 1.6;
        }
        return poder;
    }
}
