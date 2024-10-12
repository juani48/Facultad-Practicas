package Practica1.Ej11;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class PlazoFijo implements Inversiones {

    private LocalDate fechaDeConstitucion;
    private double montoDepositado;
    private double porcentajeDeInteresDiario;

    public PlazoFijo(double montoDepositado, double porcentajeDeInteresDiario){
        this.montoDepositado = montoDepositado;
        this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
        this.fechaDeConstitucion = LocalDate.now();
    }

    public double getMontoDepositado(){
        return this.montoDepositado;
    }

    public double getPorcentajeDeInteresDiario(){
        return this.porcentajeDeInteresDiario;
    }

    public LocalDate getFechaDeConstitucion(){
        return this.fechaDeConstitucion;
    }

    public void setFechaDeConstitucion(LocalDate fechaDeConstitucion){
        this.fechaDeConstitucion = fechaDeConstitucion;
    }

    @Override
    public double valorActual() {
        return (DAYS.between(this.getFechaDeConstitucion(), LocalDate.now()))*this.getPorcentajeDeInteresDiario()*this.getMontoDepositado();
    }

    
}
