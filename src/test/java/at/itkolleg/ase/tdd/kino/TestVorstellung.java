package at.itkolleg.ase.tdd.kino;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class TestVorstellung {
    @Mock
    private Vorstellung vorstellungMock;

    private Vorstellung vorstellung;
    private KinoSaal kinosaal;
    private Map<Character, Integer> map = new HashMap<>();

    @BeforeEach
    void setup() {

        map.put('A', 10);
        map.put('B', 10);
        map.put('C', 15);
        kinosaal = new KinoSaal("KS2", map);
        vorstellung = new Vorstellung(kinosaal, Zeitfenster.ABEND, LocalDate.of(2022, 6, 26), "The Batman", 12);
    }

    @Test
    void testVorstellungNamen_ohne_Mock() {

        assertEquals("The Batman", vorstellung.getFilm());
    }

    @Test
    void testVorstellungNamen_mit_Mock() {
        Mockito.when(vorstellungMock.getFilm()).thenReturn("The Batman");
        assertEquals("The Batman", vorstellungMock.getFilm());

    }

    @Test
    void testVorstellungNamen_Vergleich_Original_vs_Mock() {
        Mockito.when(vorstellungMock.getFilm()).thenReturn("The Batman");
        assertEquals(vorstellung.getFilm(), vorstellungMock.getFilm());
    }

    @Test
    void testVorstellung_getZeitfenster() {
        assertEquals(Zeitfenster.ABEND, vorstellung.getZeitfenster());
    }

    @Test
    void testVorstellung_getDatum() {
        assertEquals(LocalDate.of(2022, 6, 26), vorstellung.getDatum());

    }

    @Test
    void testVorstellung_getSaal() {
        map.put('A', 10);
        map.put('B', 10);
        map.put('C', 15);
        kinosaal = new KinoSaal("KS2", map);
        Mockito.when(vorstellungMock.getSaal()).thenReturn(kinosaal);
        assertEquals(vorstellungMock.getSaal().getName(), vorstellung.getSaal().getName());
    }

    @Test
    void testVorstellung_getPreis() {
    }

    @Test
    void test_Vorstellung_equals_VorstellungMock() {
        map.put('A', 10);
        map.put('B', 10);
        map.put('C', 15);
        kinosaal = new KinoSaal("KS2", map);
        vorstellung.equals(vorstellungMock);
    }

    @Test
    void test_kaufeTicket() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> vorstellung.kaufeTicket('C', 5, 1F));
        Assertions.assertThrows(IllegalArgumentException.class, () -> vorstellung.kaufeTicket('A', 7, 1F));
        Assertions.assertThrows(IllegalArgumentException.class, () -> vorstellung.kaufeTicket('D', 8, 1F));


    }
}
