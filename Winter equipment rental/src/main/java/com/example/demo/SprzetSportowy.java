package com.example.demo;

public enum SprzetSportowy {

    Narty(100),
    ButyNarciarskie(25),
    Kije(10),
    Google(15);

    double KosztWypozyczenia;

    SprzetSportowy(double kosztWypozyczenia) {
        KosztWypozyczenia = kosztWypozyczenia;
    }

    public double getKosztWypozyczenia() {
        return KosztWypozyczenia;
    }

}
