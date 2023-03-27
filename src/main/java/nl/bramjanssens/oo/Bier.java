package nl.bramjanssens.oo;

import java.util.Objects;

public class Bier {

    // Fields -------------------------------------
    public static final String RECEPT_VOOR_PILS = "Niet erg lekker, maar wel goedkoop";
    private static final double MAX_ALC = 16.0;

    @HackDezeMaar
    private final String naam;

    private final double alcoholPercentage;
    private byte volume = 100;

    private Krat krat;

    // Constructors -------------------------------

    // constructor:
    //...  <classnaam>(){
    //}

    // no args constructor (== de default ctor)
    public Bier() {
        // constructor chaining
        this("Onbekend", 5.0);
    }

    // required/all args constructor
    public Bier(String naam, double alc) {
        this.naam = naam;
        this.alcoholPercentage = validate(alc);

        // ..
        // ....
    }

    private double validate(double alc) {
        if (alc > MAX_ALC) {
            throw new IllegalArgumentException("Alc% moet < 16%");
        }
        return alc;
    }

    // Methods -------------------------------------------

    public void neemSlok() {
        decreaseVolume((byte) 10);
    }

    private void decreaseVolume(byte volume) {
        if (this.volume - volume >= 0) {
            this.volume -= volume;
        }
    }

    public static String geefReclame() {
        return "Loat ow vollopen, dat is ons advies. Want bier is lekker, en cola vies.";
    }

    // @Override // annotatie
    // public boolean equals(Object that) {
    //     if (that instanceof Bier b) {
    //         byte volume = b.volume;
    //         double alcoholPercentage = b.alcoholPercentage;
    //         String naam = b.naam;
    //         if (this.volume == volume &&
    //                 this.alcoholPercentage == alcoholPercentage &&
    //                 this.naam.equals(naam)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bier bier = (Bier) o;
        return Double.compare(bier.alcoholPercentage, alcoholPercentage) == 0 && volume == bier.volume && Objects.equals(naam, bier.naam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam, alcoholPercentage, volume);
    }

    // @Override
    // public String toString() {
    //     return "Ik zit nog " + getVolume() + "% vol.";
    // }

    @Override public String toString() {
        return "Bier{" +
                "naam='" + naam + '\'' +
                ", alcoholPercentage=" + alcoholPercentage +
                ", volume=" + volume +
                '}';
    }

    //      get/set --------------------------------------

    // getters

    // getters
    // public <fieldtype> get<field>(){
    //     return this.<field>;
    // }

    // setters
    // public void set<field>(<fieldtype> <identifier>){
    //     this.<field> = <identifier>;
    // }

    public byte getVolume() {
        return volume;
    }

    public String getNaam() {
        return naam;
    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setKrat(Krat krat) {
        this.krat = krat;
        krat.voegToe(this);
    }
}
