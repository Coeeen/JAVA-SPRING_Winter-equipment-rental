package com.example.demo;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Component
public class Wypozyczalnia {

    private final ListaWypozyczen listaWypozyczen;
    private final ListaKlientow listaKlientow;
    double cenaBazowa=1;


    public Wypozyczalnia(ListaWypozyczen listaWypozyczen, ListaKlientow listaKlientow) {
        this.listaWypozyczen = listaWypozyczen;
        this.listaKlientow = listaKlientow;
    }

    //5
    public Kalendarz Zimowawypozyczalnia(Klient klient, String nazwaModelu , LocalDate StartWypozyczenia, LocalDate KoniecWypozyczenia, SprzetSportowy sprzetSportowy) {
    double cena;
    long zliczenieDni=KalkulatorDni(StartWypozyczenia,KoniecWypozyczenia);
    boolean sprzet =listaWypozyczen.CzyZostalyWypozyczone(nazwaModelu);
        Optional<Klient>naziwsko=listaKlientow.CzyKlientOTymNazwiskuCosWypozyczyl(klient.getNazwisko());
    if(naziwsko.isPresent()){
        System.out.println("Cwaniaku oddawaj sprzęt");
        return null;
    }
    if(!(klient.getWiek()<=18) && klient.getWiek()>=65)
        if(zliczenieDni>31){
            ZaDlugoWypozyczasz();

        }

    if(sprzet==true){
        System.out.println("Aktualnie nie posiadamy tego sprzetu,znajdz cos innego");
        return null;
    }
    if(klient.getWiek()<=18){
        CzyJestPelnoletni();

    }
        if(klient.getWiek()>=65){
            CzyJestSeniorem();


        }
        if(zliczenieDni<1){
           DniSieNieZgadzaja();
           return null;
        }
        cena=KalkulatorCenowy(sprzetSportowy,zliczenieDni);
        listaKlientow.DodajDoWypozyczen(klient);
        return new Kalendarz(cena,StartWypozyczenia,KoniecWypozyczenia);
    }

    //6
    public long KalkulatorDni(LocalDate StartWypozyczenia,LocalDate KoniecWypozyczenia){
        return ChronoUnit.DAYS.between(StartWypozyczenia,KoniecWypozyczenia);
    }
    //7
    public double KalkulatorCenowy(SprzetSportowy sprzetSportowy, long KalkulatorDni){
         return sprzetSportowy.getKosztWypozyczenia()*KalkulatorDni*cenaBazowa;
        }
        //8
    public void CzyJestPelnoletni(){
        System.out.println("Dzieci maja za darmo,tylko niech przyjdzie opiekun");
              cenaBazowa=0;
    }
    //9
    public void CzyJestSeniorem(){
            System.out.println("Seniorzy maja za darmo,tylko nie szalejcie");
            cenaBazowa=0;

    }
    //10
    public void DniSieNieZgadzaja(){
        System.out.println("Sprawdz date?");

    }
    //11
    public void ZaDlugoWypozyczasz(){
        System.out.println("Nie wypozyczamy dluzej niz miesiac!Dodatkowe oplaty!");
        cenaBazowa=2;
    }




}