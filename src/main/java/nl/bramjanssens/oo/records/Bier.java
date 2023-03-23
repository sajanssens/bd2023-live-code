package nl.bramjanssens.oo.records;

import java.util.Objects;

public class Bier {

    private final String naam;
    private final double alc;
    private final int vol;

    public Bier(String naam, double alc, int vol) {
        this.naam = naam;
        this.alc = alc;
        this.vol = vol;
    }

    public String naam() {
        return naam;
    }

    public double alc() {
        return alc;
    }

    public int vol() {
        return vol;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bier bier = (Bier) o;
        return Double.compare(bier.alc, alc) == 0 && vol == bier.vol && Objects.equals(naam, bier.naam);
    }

    @Override public int hashCode() {
        return Objects.hash(naam, alc, vol);
    }

    @Override public String toString() {
        return "Bier{" +
                "naam='" + naam + '\'' +
                ", alc=" + alc +
                ", vol=" + vol +
                '}';
    }
}
