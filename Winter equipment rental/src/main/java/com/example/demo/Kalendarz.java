package com.example.demo;

import java.time.LocalDate;

public class Kalendarz {

   private double cena;
   private LocalDate StartWypozyczenia;
    private LocalDate KoniecWypozyczenia;

    public Kalendarz(double cena, LocalDate startWypozyczenia, LocalDate koniecWypozyczenia) {
        this.cena = cena;
        StartWypozyczenia = startWypozyczenia;
        KoniecWypozyczenia = koniecWypozyczenia;
    }

    public double getCena() {
        return cena;
    }


    @Override
    public String toString() {
        return "Kalendarz{" +
                "cena=" + cena +
                ", StartWypozyczenia=" + StartWypozyczenia +
                ", KoniecWypozyczenia=" + KoniecWypozyczenia +
                '}';
    }
}
