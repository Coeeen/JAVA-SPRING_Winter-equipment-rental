package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class WypozyczalniaSprzetowZimowych {

	//13
	public WypozyczalniaSprzetowZimowych(Wypozyczalnia wypozyczalnia){

		 Kalendarz Wypozycz=wypozyczalnia.Zimowawypozyczalnia(
				 new Klient("Michał","Żołądek",19),"Nike",
				 LocalDate.of(2023,1,12),LocalDate.of(2023,1,13), SprzetSportowy.ButyNarciarskie
		 );
		System.out.println(Wypozycz);
	}

	public static void main(String[] args) {
		SpringApplication.run(WypozyczalniaSprzetowZimowych.class, args);
	}

}
