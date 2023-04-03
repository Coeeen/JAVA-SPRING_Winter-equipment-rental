package com.example.demo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class testyIntegracyjne {

    Wypozyczalnia wypozyczalnia;
    @BeforeEach
            void setup() {
        ListaKlientow listaKlientow=new ListaKlientow();
        ListaWypozyczen listaWypozyczen=new ListaWypozyczen();
         wypozyczalnia = new Wypozyczalnia(listaWypozyczen, listaKlientow);
    }
    //1
@Test
    public void CzyAplikacjaDzialaPoprawnie(){
    Kalendarz Wypozyczalnia = wypozyczalnia.Zimowawypozyczalnia(
            new Klient("Michal","Zoladek",20),"Nike",
            LocalDate.of(2023,1,12),LocalDate.of(2023,1,13), SprzetSportowy.ButyNarciarskie
    );
    assertThat(Wypozyczalnia).hasToString("Kalendarz{cena=25.0, StartWypozyczenia=2023-01-12, KoniecWypozyczenia=2023-01-13}");
}

    @Test
    public void KtosProbojeWypozyczycDrugiRaz(){
        Kalendarz Wypozyczalnia = wypozyczalnia.Zimowawypozyczalnia(
                new Klient("Paulina","Debis",40),"Nike",
                LocalDate.of(2023,1,12),LocalDate.of(2023,1,13), SprzetSportowy.ButyNarciarskie
        );
        assertThat(Wypozyczalnia).isNull();
    }
    @Test
    public void CzyPdodajeNowychKlientow(){
        Kalendarz Wypozyczalnia = wypozyczalnia.Zimowawypozyczalnia(
                new Klient("Michal","Zoladek",20),"Nike",
                LocalDate.of(2023,1,12),LocalDate.of(2023,1,13), SprzetSportowy.ButyNarciarskie
        );
        assertThat(Wypozyczalnia).isNotNull();
    }
    @Test
    public void JestAktualnieWypozyczona(){
        Kalendarz Wypozyczalnia = wypozyczalnia.Zimowawypozyczalnia(
                new Klient("Michal","Zoladek",20),"Addidas",
                LocalDate.of(2023,1,12),LocalDate.of(2023,1,13), SprzetSportowy.ButyNarciarskie
        );
        assertThat(Wypozyczalnia).isNull();
    }
    @Test
    public void PomyloneDni(){
        Kalendarz Wypozyczalnia = wypozyczalnia.Zimowawypozyczalnia(
                new Klient("Michal","Zoladek",20),"Nike",
                LocalDate.of(2023,1,15),LocalDate.of(2023,1,1), SprzetSportowy.Google
        );
        assertThat(Wypozyczalnia).isNull();
    }
    @Test
    public void CenaNartSieZgadza(){
        Kalendarz Wypozyczalnia = wypozyczalnia.Zimowawypozyczalnia(
                new Klient("Michal","Zoladek",20),"Nike",
                LocalDate.of(2023,1,1),LocalDate.of(2023,1,2), SprzetSportowy.Narty
        );
        assertThat(Wypozyczalnia).hasToString("Kalendarz{cena=100.0, StartWypozyczenia=2023-01-01, KoniecWypozyczenia=2023-01-02}");
    }
    @Test
    public void CenaGogliSieZgadza(){
        Kalendarz Wypozyczalnia = wypozyczalnia.Zimowawypozyczalnia(
                new Klient("Michal","Zoladek",20),"Nike",
                LocalDate.of(2023,1,1),LocalDate.of(2023,1,2), SprzetSportowy.Google
        );
        assertThat(Wypozyczalnia).hasToString("Kalendarz{cena=15.0, StartWypozyczenia=2023-01-01, KoniecWypozyczenia=2023-01-02}");
    }
    @Test
    public void CenaKiji(){
        Kalendarz Wypozyczalnia = wypozyczalnia.Zimowawypozyczalnia(
                new Klient("Michal","Zoladek",20),"Nike",
                LocalDate.of(2023,1,1),LocalDate.of(2023,1,2), SprzetSportowy.Kije
        );
        assertThat(Wypozyczalnia).hasToString("Kalendarz{cena=10.0, StartWypozyczenia=2023-01-01, KoniecWypozyczenia=2023-01-02}");
    }
    @Test
    public void CenaButowNarciarskich(){
        Kalendarz Wypozyczalnia = wypozyczalnia.Zimowawypozyczalnia(
                new Klient("Michal","Zoladek",20),"Nike",
                LocalDate.of(2023,1,1),LocalDate.of(2023,1,2), SprzetSportowy.ButyNarciarskie
        );
        assertThat(Wypozyczalnia).hasToString("Kalendarz{cena=25.0, StartWypozyczenia=2023-01-01, KoniecWypozyczenia=2023-01-02}");
    }
    @Test
    public void KalkulatorNartDobrzedziala(){
        Kalendarz Wypozyczalnia = wypozyczalnia.Zimowawypozyczalnia(
                new Klient("Michal","Zoladek",20),"Nike",
                LocalDate.of(2023,1,1),LocalDate.of(2023,1,3), SprzetSportowy.ButyNarciarskie
        );
        assertThat(Wypozyczalnia).hasToString("Kalendarz{cena=50.0, StartWypozyczenia=2023-01-01, KoniecWypozyczenia=2023-01-03}");
    }
    @Test
    public void KalkulatorKijiDobrzedziala(){
        Kalendarz Wypozyczalnia = wypozyczalnia.Zimowawypozyczalnia(
                new Klient("Michal","Zoladek",20),"Nike",
                LocalDate.of(2023,1,1),LocalDate.of(2023,1,3), SprzetSportowy.Kije
        );
        assertThat(Wypozyczalnia).hasToString("Kalendarz{cena=20.0, StartWypozyczenia=2023-01-01, KoniecWypozyczenia=2023-01-03}");
    }
    @Test
    public void KalkulatorGogliDobrzedziala(){
        Kalendarz Wypozyczalnia = wypozyczalnia.Zimowawypozyczalnia(
                new Klient("Michal","Zoladek",20),"Nike",
                LocalDate.of(2023,1,1),LocalDate.of(2023,1,3), SprzetSportowy.Google
        );
        assertThat(Wypozyczalnia).hasToString("Kalendarz{cena=30.0, StartWypozyczenia=2023-01-01, KoniecWypozyczenia=2023-01-03}");
    }
    @Test
    public void Niepelnoletni(){
        Kalendarz Wypozyczalnia = wypozyczalnia.Zimowawypozyczalnia(
                new Klient("Krystian","Jank",8),"Nike",
                LocalDate.of(2023,1,1),LocalDate.of(2023,1,3), SprzetSportowy.Google
        );
        assertThat(Wypozyczalnia).hasToString("Kalendarz{cena=0.0, StartWypozyczenia=2023-01-01, KoniecWypozyczenia=2023-01-03}");
    }
    @Test
    public void Senior(){
        Kalendarz Wypozyczalnia = wypozyczalnia.Zimowawypozyczalnia(
                new Klient("Jakub","Dufke",98),"Nike",
                LocalDate.of(2023,1,1),LocalDate.of(2023,1,3), SprzetSportowy.Google
        );
        assertThat(Wypozyczalnia).hasToString("Kalendarz{cena=0.0, StartWypozyczenia=2023-01-01, KoniecWypozyczenia=2023-01-03}");
    }
    @Test
    public void DzieciNiePlacaKary(){
        Kalendarz Wypozyczalnia = wypozyczalnia.Zimowawypozyczalnia(
                new Klient("Krystian","Jank",1),"Nike",
                LocalDate.of(2023,1,1),LocalDate.of(2023,2,3), SprzetSportowy.Google
        );
        assertThat(Wypozyczalnia).hasToString("Kalendarz{cena=0.0, StartWypozyczenia=2023-01-01, KoniecWypozyczenia=2023-02-03}");
    }
    @Test
    public void SeniorzyNiePlacaKary(){
        Kalendarz Wypozyczalnia = wypozyczalnia.Zimowawypozyczalnia(
                new Klient("Jakub","Dufke",1),"Nike",
                LocalDate.of(2023,1,1),LocalDate.of(2023,2,3), SprzetSportowy.Google
        );
        assertThat(Wypozyczalnia).hasToString("Kalendarz{cena=0.0, StartWypozyczenia=2023-01-01, KoniecWypozyczenia=2023-02-03}");
    }
}
