package nl.bramjanssens.oo;

public class Bier {

    // Fields -------------------------------------
    public static final String RECEPT_VOOR_PILS = "Niet erg lekker, maar wel goedkoop";
    private static final double MAX_ALC = 16.0;

    private final String naam;
    private final double alcoholPercentage;
    private byte volume = 100;

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
}
