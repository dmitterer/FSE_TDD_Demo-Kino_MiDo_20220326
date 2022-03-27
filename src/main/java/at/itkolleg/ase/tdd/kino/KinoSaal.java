package at.itkolleg.ase.tdd.kino;

import java.util.Map;

public class KinoSaal {

    private final String name;

    private final Map<Character, Integer> reihen;

    public KinoSaal(String name, Map<Character, Integer> reihen) {
        this.name = name;
        this.reihen = reihen;
    }

    public String getName() {
        return name;
    }

    boolean pruefePlatz(char reihe, int platz) {
        Integer platze = reihen.get(reihe);
        System.out.println(platze);
        return platze != null && platz <= platze && platz != 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof KinoSaal)) {
            return false;
        }
        return this.name.equals(((KinoSaal) obj).getName());
    }

    @Override
    public String toString() {
        return "KinoSaal{" +
                "name='" + name + '\'' +
                ", reihen=" + reihen +
                '}';
    }
}
