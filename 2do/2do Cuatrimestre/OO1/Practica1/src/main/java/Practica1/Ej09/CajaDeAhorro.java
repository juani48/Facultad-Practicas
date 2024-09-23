package Practica1.Ej09;

public class CajaDeAhorro extends Cuenta {

    private double costoAdicional = 0.02d;

    public double getCostoAdicional(){
        return this.costoAdicional;
    }

    @Override
    protected boolean puedeExtraer(double monto) {
        return this.getSaldo() - (monto * this.getCostoAdicional()) >= 0;
    }
}
