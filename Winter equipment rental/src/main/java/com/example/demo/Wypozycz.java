package com.example.demo;

public class Wypozycz {

    private Klient klient;
    private Sprzet sprzet;

    public Wypozycz(Klient klient, Sprzet sprzet) {
        this.klient = klient;
        this.sprzet = sprzet;
    }

    public Sprzet getSprzet() {
        return sprzet;
    }

}
