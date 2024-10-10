package Practica1.Ej14a;

import java.time.LocalDate;

public interface IDateLapse {
    
    public LocalDate getFrom();
    public LocalDate getTo();
    public int sizeInDays();
    public boolean includesDate(LocalDate other);
}
