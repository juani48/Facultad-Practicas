package Practica1.Ej14a;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse1 implements IDateLapse {

    private LocalDate from;
    private LocalDate to;

    public DateLapse1(LocalDate from, LocalDate to){
        this.from = from;
        this.to = to;
    }

    //“Retorna la fecha de inicio del rango”
    public LocalDate getFrom(){
        return this.from;
    }

    //“Retorna la fecha de fin del rango”
    public LocalDate getTo(){
        return this.to;
    }

    // “retorna la cantidad de días entre la fecha 'from' y la fecha 'to'”
    public int sizeInDays(){
        return (int)(this.getFrom().until(this.getTo(), ChronoUnit.DAYS));
    }

    //“recibe un objeto LocalDate y retorna true si la fecha está entre el from y el to del receptor y false en caso contrario”
    public boolean includesDate(LocalDate other){
        return this.getFrom().isAfter(other) && this.getTo().isBefore(other) || this.getFrom().equals(other) || this.getTo().equals(other);
    }
}