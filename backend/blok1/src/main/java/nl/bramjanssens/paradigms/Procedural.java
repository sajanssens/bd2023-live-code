package nl.bramjanssens.paradigms;

public class Procedural {

    public static void main(String[] args) {
        String beerType;
        double alc;

        beerType = "Tripel";  // schrijven
        alc = 8.55;
        print(beerType, alc); // lezen

        beerType = "Blond";
        alc = 6.02;
        print(beerType, alc);

        String zesKommaNulAlsTekst = "6.0";
        double zesKommaNulAlsKommagetal = 6.0;

        System.out.println(zesKommaNulAlsTekst + zesKommaNulAlsTekst); // + als tekstuele bewerking
        System.out.println(zesKommaNulAlsKommagetal + zesKommaNulAlsKommagetal); // + als rekenkundige bewerking
        System.out.println(zesKommaNulAlsKommagetal + zesKommaNulAlsTekst);
        System.out.println(zesKommaNulAlsTekst + zesKommaNulAlsKommagetal);
        System.out.println((zesKommaNulAlsKommagetal + zesKommaNulAlsKommagetal) + zesKommaNulAlsTekst);
        System.out.println(zesKommaNulAlsKommagetal + zesKommaNulAlsTekst + zesKommaNulAlsKommagetal);
        System.out.println(zesKommaNulAlsTekst + zesKommaNulAlsKommagetal + zesKommaNulAlsKommagetal);
    }

    private static void print(String type, double alc) {
        String bericht = String.format("Biertype is \"%-10s\" en bevat %.0f %% alcohol.", type, alc);
        System.out.println("Biertype is " + type + " en bevat " + alc + "% alcohol."); // string concatenation
    }
}
