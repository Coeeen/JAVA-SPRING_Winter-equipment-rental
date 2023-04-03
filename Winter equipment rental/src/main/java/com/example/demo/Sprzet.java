package com.example.demo;

public class Sprzet {



    private String Stan;
    private String NazwaModelu;
    private SprzetSportowy sprzetSportowy;

    public Sprzet(SprzetSportowy sprzetSportowy, String stan, String nazwaModelu) {
        this.sprzetSportowy = sprzetSportowy;
        Stan = stan;
        NazwaModelu = nazwaModelu;
    }


    public String getNazwaModelu() {
        return NazwaModelu;
    }

    @Override
    public String toString() {
        return "Sprzęt{" +
                "sprzętSportowy=" + sprzetSportowy +
                ", Stan='" + Stan + '\'' +
                ", NazwaModelu='" + NazwaModelu + '\'' +
                '}';
    }
}
