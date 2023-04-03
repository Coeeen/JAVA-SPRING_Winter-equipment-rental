package com.example.demo;

public class Klient {

    private String Imie;
    private String Nazwisko;
    private double wiek;

    public Klient(String imie, String nazwisko, double wiek) {
        Imie = imie;
        Nazwisko = nazwisko;
        this.wiek = wiek;
    }
    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    public double getWiek() {
        return wiek;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "Imie='" + Imie + '\'' +
                ", Nazwisko='" + Nazwisko + '\'' +
                '}';
    }

    public Object getNazwiskoKlienta(Klient klient) {
        return klient.getNazwisko();
    }
}
