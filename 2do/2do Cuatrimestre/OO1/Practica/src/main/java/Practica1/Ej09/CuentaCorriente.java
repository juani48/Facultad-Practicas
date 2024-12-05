package Practica1.Ej09;

public class CuentaCorriente extends Cuenta {

    private double limiteDescubierto;

    public CuentaCorriente(){
        super();
        this.limiteDescubierto = 0;
    }

    public double getLimiteDescubierto(){
        return this.limiteDescubierto;
    }

    public void setLimiteDescubierto(double limiteDescubierto){
        this.limiteDescubierto = limiteDescubierto;
    }

    @Override
    protected boolean puedeExtraer(double monto) {
        return this.getSaldo() - monto >= this.getLimiteDescubierto();
    }
    
}
