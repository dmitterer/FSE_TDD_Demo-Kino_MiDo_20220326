package at.itkolleg.ase.tdd.kino;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class KinoVerwaltung {

    private final List<Vorstellung> vorstellungen = new LinkedList<>();

    public void einplanenVorstellung(Vorstellung vorstellung) {
        if (vorstellungen.contains(vorstellung)) {
            throw new IllegalArgumentException("Die Vorstellung ist bereits eingeplant");
        }
        vorstellungen.add(vorstellung);
    }


    public Ticket kaufeTicket(Vorstellung vorstellung, char reihe, int platz, float geld) {
        return vorstellung.kaufeTicket(reihe, platz, geld);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KinoVerwaltung that = (KinoVerwaltung) o;
        return Objects.equals(vorstellungen, that.vorstellungen);
    }

    @Override
    public String toString() {
        return "KinoVerwaltung{" +
                "vorstellungen= " + this.vorstellungen +
                '}';
    }
}
