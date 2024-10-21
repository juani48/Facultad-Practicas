package Practica1.Ej14;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Practica1.Ej14a.DateLapse1;
import Practica1.Ej14a.IDateLapse;

public class DateLapse1Test {

    private IDateLapse dateLapse1;
    

    @BeforeEach
    void setUp(){
        this.dateLapse1 = new DateLapse1(LocalDate.of(1, 1, 1), LocalDate.of(1, 1, 10));
        
        
    }

    @Test
    void testSizeInDays1(){
        
        assertEquals(9, this.dateLapse1.sizeInDays());
        assertNotEquals(10, this.dateLapse1.sizeInDays());
    }

    @Test
    void testIncludesDate1(){
        assertTrue(this.dateLapse1.includesDate(LocalDate.of(1, 1, 1)));
        assertTrue(this.dateLapse1.includesDate(LocalDate.of(1, 1, 10)));
        assertFalse(this.dateLapse1.includesDate(LocalDate.of(1, 1, 11)));
    }

    

}
