package at.itkolleg.ase.tdd.kino;

import java.time.LocalDate;
import java.util.Objects;

public class Ticket {

    private final String saal;

    private final Zeitfenster zeitfenster;

    private final LocalDate datum;

    private final char reihe;

    private final int platz;

    public Ticket(String saal, Zeitfenster zeitfenster, LocalDate datum, char reihe, int platz) {
        this.saal = saal;
        this.zeitfenster = zeitfenster;
        this.datum = datum;
        this.reihe = reihe;
        this.platz = platz;
    }

    public String getSaal() {
        return saal;
    }

    public Zeitfenster getZeitfenster() {
        return zeitfenster;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public char getReihe() {
        return reihe;
    }

    public int getPlatz() {
        return platz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return reihe == ticket.reihe && platz == ticket.platz && Objects.equals(saal, ticket.saal) && zeitfenster == ticket.zeitfenster && Objects.equals(datum, ticket.datum);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "saal='" + this.getSaal() + '\'' +
                ", zeitfenster=" + this.getZeitfenster() +
                ", datum=" + this.getDatum() +
                ", reihe=" + this.getReihe() +
                ", platz=" + this.getPlatz() +
                '}';
    }
}
