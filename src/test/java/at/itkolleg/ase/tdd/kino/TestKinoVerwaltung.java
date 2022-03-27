package at.itkolleg.ase.tdd.kino;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.*;


@ExtendWith(MockitoExtension.class)
public class TestKinoVerwaltung {
    private Vorstellung The_Batman, Squid_Game;    private KinoVerwaltung kinoVerwaltung = new KinoVerwaltung();
    private KinoSaal ks;

    @BeforeEach
    void setup() {
        //Saal anlegen
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 10);
        map.put('B', 20);
        map.put('C', 15);
        ks = new KinoSaal("Saal1", map);
        The_Batman = new Vorstellung(ks, Zeitfenster.ABEND, LocalDate.of(2022, 10, 26), "The Batman", 12);
        Squid_Game =  new Vorstellung(ks, Zeitfenster.NACHMITTAG, LocalDate.of(2022, 02, 01), "Squid Game", 10);

        kinoVerwaltung.einplanenVorstellung(The_Batman);
    }

    @Test
    void test_einpalenVorstellungEinplanenMehrfach() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> kinoVerwaltung.einplanenVorstellung(The_Batman));
    }

    @Test
    void test_einpalenVorstellungMitNichtVorhandenenPlatz() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> kinoVerwaltung.kaufeTicket(The_Batman, 'P', 8, 10), "I am Batman");
    }

    @Test
    void testTicketKaufenMitBelegtemPlatz() {


        ArrayList<Throwable> al = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            int testValue = random.nextInt(20) + 1;
            System.out.println(testValue);
            try {
                Assertions.assertEquals('B', kinoVerwaltung.kaufeTicket(Squid_Game,'B', testValue, 10).getReihe());
            } catch (IllegalArgumentException | IllegalStateException e1) {
                al.add(e1);

            }
        }
        if (al.size() > 0) {
            System.out.println("Ausgabe");
            System.out.println(al);
           // Assertions.fail();
        }
    }

    @TestFactory
    Collection<DynamicTest> testZufaelligVorstellungEinplanen() {

        List<DynamicTest> testListe = new ArrayList<>();

        ArrayList<Throwable> al = new ArrayList<>();
        int i;
        for (i = 0; i < 20; i++) {
            The_Batman = new Vorstellung(ks, Zeitfenster.ABEND, LocalDate.of(2022, 10, i + 1), "The  Batman", 12);

            Random random = new Random();
            int testValue = random.nextInt(20) + 1;
            System.out.println(testValue);
            try {
                if (testValue > 5) {
                    testListe.add(
                            DynamicTest.dynamicTest(
                                    "The Batman",
                                    () -> Assertions.assertEquals('B', kinoVerwaltung.kaufeTicket(The_Batman, 'B', testValue, 12).getReihe())));
                } else {
                    testListe.add(
                            DynamicTest.dynamicTest(
                                    "Squid Game",
                                    () -> Assertions.assertEquals("Saal1", kinoVerwaltung.kaufeTicket(Squid_Game,'C', testValue, 12).getSaal())));
                }
            } catch (IllegalArgumentException | IllegalStateException e1) {
                al.add(e1);

            }
        }
        if (al.size() > 0) {
            System.out.println("Ausgabe");
            System.out.println(al);
            Assertions.fail();
        }
        return testListe;
    }
}
