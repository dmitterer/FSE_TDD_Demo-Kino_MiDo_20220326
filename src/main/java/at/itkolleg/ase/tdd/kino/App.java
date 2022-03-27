package at.itkolleg.ase.tdd.kino;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Dieses Beispiel stammt aus https://training.cherriz.de/cherriz-training/1.0.0/testen/junit5.html
 */
public class App {
    public static void main(String[] args) {
        //Saal anlegen
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 10);
        map.put('B', 10);
        map.put('C', 15);
        map.put('D', 10);
        KinoSaal ks = new KinoSaal("Saal1", map);

        //Platz prüfen
        System.out.println(ks.pruefePlatz('A', 11));
        System.out.println(ks.pruefePlatz('A', 10));
        System.out.println(ks.pruefePlatz('B', 10));
        System.out.println(ks.pruefePlatz('C', 14));

        //-------------------------
        System.out.println("-----------------------------------");

        //Vorstellung anlegen
        Vorstellung The_Batman = new Vorstellung(ks, Zeitfenster.ABEND, LocalDate.of(2022, 10, 26), "The Batman", 12);
        Vorstellung SquidGame = new Vorstellung(ks, Zeitfenster.NACHMITTAG, LocalDate.of(2022, 02, 01), "Squid Game", 12);
        //Vorstellung prüfen
        System.out.println(The_Batman.getFilm());
        System.out.println(The_Batman.getDatum());
        System.out.println(The_Batman.getSaal());
        System.out.println(The_Batman.getZeitfenster());
        System.out.println("***********************************");
        System.out.println(SquidGame.getFilm());
        System.out.println(SquidGame.getDatum());
        System.out.println(SquidGame.getSaal());
        System.out.println(SquidGame.getZeitfenster());
        System.out.println("-----------------------------------");
        //Ticket kaufen
        Ticket ticket1 = The_Batman.kaufeTicket('B', 1, 10F);
        System.out.println("Ticket1: \n\t" + ticket1);
        // Ticket ticket2 = vorstellung.kaufeTicket('b', 1, 10F);
        //  System.out.println("Ticket2: \n\t" + ticket2);
        // Ticket ticket3 = vorstellung.kaufeTicket('B', 1, 10F);
        //  System.out.println("Ticket3: \n\t" + ticket3);
        //  Ticket ticket4 = vorstellung.kaufeTicket('B', 1, 5F);
        //  System.out.println("Ticket4: \n\t" + ticket4);
        System.out.println("***********************************");
        Ticket ticket5 = SquidGame.kaufeTicket('B', 2, 1F);
        System.out.println("Ticket5: \n\t" + ticket5);
        System.out.println("-----------------------------------");
        //Verwaltung kaufen
        KinoVerwaltung kinoVerwaltung = new KinoVerwaltung();
        kinoVerwaltung.einplanenVorstellung(The_Batman);
        kinoVerwaltung.einplanenVorstellung(SquidGame);
        System.out.println("Vorstellungen: \n\t" + kinoVerwaltung);

    }
}
