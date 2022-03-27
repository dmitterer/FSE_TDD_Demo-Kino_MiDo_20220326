package at.itkolleg.ase.tdd.kino;

import org.junit.jupiter.api.AfterAll;
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
public class TestTicket {
    @Mock
    private Ticket ticketMock;
    private Ticket ticketOriginal;
    private KinoSaal kinosaal;
    private Map<Character, Integer> map = new HashMap<>();


    @BeforeEach
    void setup() {
        ticketOriginal = new Ticket("Saal1", Zeitfenster.NACHT, LocalDate.of(2022, 10, 26), 'c', 5);
    }

    @Test
    void test_Get_Saal_from_ticketOriginal() {
        assertEquals("Saal1", ticketOriginal.getSaal());
    }

    @Test
    void test_getZeitfenster_from_ticketOriginal() {
        assertEquals(Zeitfenster.NACHT, ticketOriginal.getZeitfenster());
    }

    @Test
    void test_Datum_From_ticketOriginal() {
        assertEquals(LocalDate.of(2022, 10, 26), ticketOriginal.getDatum());
    }

    @Test
    void test_Datum_From_ticketMock() {
        Mockito.when(ticketMock.getDatum()).thenReturn(LocalDate.of(2022, 10, 26));
        assertEquals(LocalDate.of(2022, 10, 26), ticketMock.getDatum());
    }

    @Test
    void test_Reihe_Form_ticketOriginal() {
        assertEquals('c', ticketOriginal.getReihe());
    }

    @Test
    void test_getPlatz_from_ticketOriginal() {
        assertEquals(5, ticketOriginal.getPlatz());
    }

    @Test
    void test_Equal_ticketOriginal_ticketMock() {
        ticketMock = new Ticket("Saal1", Zeitfenster.ABEND, LocalDate.of(2022, 7, 26), 'c', 2);
        ticketOriginal.equals(ticketMock);
    }
}
