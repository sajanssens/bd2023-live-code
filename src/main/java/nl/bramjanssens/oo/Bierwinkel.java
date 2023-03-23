package nl.bramjanssens.oo;

public class Bierwinkel {

    public static void main(String[] args) {
        Bier b1 = new Bier();
        Bier b2 = new Bier("Java", 5.0);
        Bier b3 = new Bier("JTech", 5.8);
        // b3.volume = (byte) 200; // not allowed: encapsulation

        // methods maken
        System.out.println("B3 zit nog " + b3.getVolume() + "% vol.");
        b3.neemSlok();
        System.out.println("B3 zit nog " + b3.getVolume() + "% vol.");
        b3.neemSlok();
        System.out.println("B3 zit nog " + b3.getVolume() + "% vol.");

        System.out.println(Bier.RECEPT_VOOR_PILS);
        System.out.println(Bier.geefReclame());
    }
}
