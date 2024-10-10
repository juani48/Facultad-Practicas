package Practica1.Ej14b;

import java.time.LocalDate;

import Practica1.Ej14a.IDateLapse;

public class DateLapse2 implements IDateLapse{

    private LocalDate from;
    private long sizeInDays;

    public DateLapse2(LocalDate from, LocalDate to){
        this.from = from;
        this.sizeInDays = to.toEpochDay();
    }  

    @Override
    public LocalDate getFrom() {
        return this.from;
    }

    @Override
    public LocalDate getTo() {
        return LocalDate.ofEpochDay(this.sizeInDays);
    }

    @Override
    public int sizeInDays() {
        return this.sizeInDays();
    }

    @Override
    public boolean includesDate(LocalDate other) {
        return other.isAfter(this.getFrom()) && other.isBefore(this.getTo());
    }
    
}
