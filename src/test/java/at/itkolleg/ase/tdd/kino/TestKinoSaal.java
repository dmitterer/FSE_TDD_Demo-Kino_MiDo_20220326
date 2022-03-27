package at.itkolleg.ase.tdd.kino;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TestKinoSaal {
    @Mock
    private KinoSaal kinosaalMock; //Mocking Data zum Testen


    private KinoSaal kinosaalOrig;
    private Map<Character, Integer> map = new HashMap<>();

    @BeforeEach
    void setup() {
        //Saal anlegen
        map.put('A', 10);
        map.put('B', 10);
        map.put('C', 15);
        map.put('D', 16);
        map.put('F', 12);
        map.put('G', 14);
        map.put('E', 15);
        kinosaalOrig = new KinoSaal("KS2", map);
    }

    @Test
    void testKinosaalMockName() {
        //Wenn vom Stub die getName aufgerufen wird, soll KS1 zurückkommen.
        Mockito.when(kinosaalMock.getName()).thenReturn("KS1");
        //Überprüfung, ob der Wert gemockt wurde.
        assertEquals("KS1", kinosaalMock.getName());

        Mockito.verify(kinosaalMock).getName();
    }

    @Test
    void testKinosaalMockName_Falsch() {
        //Wenn vom Stub die getName aufgerufen wird, soll KS1 zurückkommen.
        Mockito.when(kinosaalMock.getName()).thenReturn("KS1");
        //Überprüfung, ob der Wert gemockt wurde.
        assertEquals("KS1", kinosaalMock.getName(), "Der richtige Saal wurde angegeben :)");

        Mockito.verify(kinosaalMock).getName();
    }

    @Test
    void testKinosaalName_Setup_gegen_Mock() {
        Mockito.when(kinosaalMock.getName()).thenReturn("KS2");
        assertEquals(kinosaalMock.getName(), kinosaalOrig.getName());
    }

    @Test
    void testKinosaalPlätze() {
        assertFalse(kinosaalOrig.pruefePlatz('A', 11));
        assertTrue(kinosaalOrig.pruefePlatz('A', 10));
        assertTrue(kinosaalOrig.pruefePlatz('B', 10));
        assertTrue(kinosaalOrig.pruefePlatz('C', 14));
        assertTrue(kinosaalOrig.pruefePlatz('G', 14));
        assertTrue(kinosaalOrig.pruefePlatz('F', 12));
    }

    @Test
    void testKinosaalName() {
        assertEquals("KS2", kinosaalOrig.getName());
    }

    @Test
    void testKinosaal() {

        map.put('A', 10);
        map.put('B', 10);
        map.put('C', 15);
        kinosaalMock = new KinoSaal("KS2", map);
        // Mockito.verify(kinosaalOrig).equals(kinosaalMock);
        kinosaalOrig.equals(kinosaalMock);
    }
}
