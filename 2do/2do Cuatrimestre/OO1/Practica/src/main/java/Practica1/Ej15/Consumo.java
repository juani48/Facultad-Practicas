package Practica1.Ej15;

public class Consumo {

    private double consumoActivo;
    private double consumoReactivo;
    private CuadroTarifario cuadroTarifario;

    public Consumo( double consumoActivo, double consumoReactivo, CuadroTarifario cuadroTarifario){
        this.consumoActivo = consumoActivo;
        this.consumoReactivo = consumoReactivo;
        this.cuadroTarifario = cuadroTarifario;
    }

    public double getConsumoActivo(){
        return this.consumoActivo;
    }
    public double getConsumoReactivo(){
        return this.consumoReactivo;
    }
    public CuadroTarifario geCuadroTarifario(){
        return this.cuadroTarifario;
    }

    private boolean factorPotenciaEstimado(){
        return 0.8 <= (
            this.getConsumoActivo() / (
                Math.sqrt(
                    (Math.pow(this.getConsumoActivo(), 2) + 
                    Math.pow(this.getConsumoReactivo(), 2))
                )
            )
        );
    }

    public double getMontoFinal(){
        double aux = this.getConsumoActivo() * this.geCuadroTarifario().getPrecioKWH();
        if(this.factorPotenciaEstimado()){
            aux = aux *1.1;
        }
        return aux;
    }
}
