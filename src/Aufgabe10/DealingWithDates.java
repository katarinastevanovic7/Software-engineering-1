package Aufgabe10;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DealingWithDates {
    public static void main(String[] args) {
        //a)
        LocalDate geburtsdatumY = LocalDate.of(1995, Month.MAY, 18);
        LocalDate localDate = LocalDate.now();      //aktuelles Datum

        // Period = Zeit in Jahre, Monate, Tage ||  Duration = Sekunden
        Period alter = Period.between(geburtsdatumY, localDate);     // Differenz zwischen zwei LocalDate-Instanzen

        System.out.println(alter.getYears());   //getYears, getMonth, getDays -> einzelne Komponente

        //b)
        long tageSeitGeburt = ChronoUnit.DAYS.between(geburtsdatumY, localDate);      //Zeitabstand zwischen zwei LocalDate-Objekten
        System.out.println(tageSeitGeburt);

        //c)
        LocalDate geburtsdatumM = LocalDate.of(2002, Month.JULY, 21);
        long altersunterschied = ChronoUnit.DAYS.between(geburtsdatumY, geburtsdatumM);
        System.out.println(Math.abs(altersunterschied));        // Math.abs für absoluten Unterschied, sonst negative Zahl

        //d)
        LocalDate startDatum = LocalDate.of(2023, Month.APRIL, 20);
        LocalDate n = startDatum.plus(248, ChronoUnit.DAYS);

       System.out.println(n);


    }
}

