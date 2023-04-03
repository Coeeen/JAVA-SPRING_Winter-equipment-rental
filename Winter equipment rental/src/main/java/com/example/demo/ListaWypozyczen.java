package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ListaWypozyczen {

    private final ArrayList<Wypozycz>listaWypozyczen = new ArrayList<>();


    public ListaWypozyczen(){
        listaWypozyczen.add(new Wypozycz(new Klient("Jakub","Osowski",22),new Sprzet(SprzetSportowy.ButyNarciarskie,"Nowe","Alpine PRO")));
        listaWypozyczen.add(new Wypozycz(new Klient("Paulina","Debis",40),new Sprzet(SprzetSportowy.Google,"Uzywane","Alpina")));
        listaWypozyczen.add(new Wypozycz(new Klient("Maciek","Cieślak",19),new Sprzet(SprzetSportowy.Google,"Nowe","Addidas")));
        listaWypozyczen.add(new Wypozycz(new Klient("Mateusz","Cieślak",12),new Sprzet(SprzetSportowy.ButyNarciarskie,"Uzywane","Bern")));
    }



    public ArrayList<Wypozycz> getListaWypozyczen() {
        return listaWypozyczen;
    }
    //3
    public void DodajDoWypozyczen(Wypozycz wypozycz){
        listaWypozyczen.add(wypozycz);
    }

    //4
    public boolean CzyZostalyWypozyczone(String nazwaModelu){
        return listaWypozyczen.stream().map(Wypozycz::getSprzet).anyMatch(sprzet -> sprzet.getNazwaModelu().equals(nazwaModelu));
    }

}
