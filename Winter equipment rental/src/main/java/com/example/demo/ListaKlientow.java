package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class ListaKlientow {

    private final ArrayList<Klient> listaKlientow = new ArrayList<>();


    //lista klientow


    public ListaKlientow() {
        listaKlientow.add(new Klient("Jakub", "Osowski", 22));
        listaKlientow.add(new Klient("Maciek", "Cieślak", 19));
        listaKlientow.add(new Klient("Martin ", "Pawlak", 21));
        listaKlientow.add(new Klient("Fryderyk", "Nowak", 10));
        listaKlientow.add(new Klient("Jarosław ", "Mazur", 8));
        listaKlientow.add(new Klient("Paulina ", "Debis", 90));
    }

    public ArrayList<Klient> getListaKlientow() {
        return listaKlientow;
    }
    //1
    public void DodajDoWypozyczen(Klient klient){
        listaKlientow.add(klient);
    }

    //stream->wyszukiwanie

    //2
    public Optional<Klient> CzyKlientOTymNazwiskuCosWypozyczyl(String nazwisko) {
        return listaKlientow.stream().filter(klient -> klient.getNazwisko().equals(nazwisko)).findFirst();
    }

}

