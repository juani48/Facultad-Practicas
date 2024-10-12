package Practica1.Ej09;

public class CajaDeAhorro extends Cuenta {

    private double costoAdicional = 1.02d;

    public double getCostoAdicional(){
        return this.costoAdicional;
    }

    @Override
    protected boolean puedeExtraer(double monto) {
        return this.getSaldo() - (monto * this.getCostoAdicional()) >= 0;
    }

    @Override
    protected void extraerSinControlar(double monto){
        super.extraerSinControlar(monto * this.getCostoAdicional());
    }
}
