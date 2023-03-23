package nl.bramjanssens.oo;

public class Bierwinkel {

    public static void main(String[] args) {
        Bier b1 = new Bier();
        Bier b2 = new Bier("Java", 5.0);
        Bier b3 = new Bier("JTech", 5.8);
        Bier b4 = new Bier("JTech", 5.8);
        Wijn w1 = new Wijn("Malbec", 12.8, (byte) 100);
        Wijn w2 = new Wijn("Malbec", 12.8, (byte) 100);
        // b3.volume = (byte) 200; // not allowed: encapsulation

        // methods maken
        System.out.println("B3 zit nog " + b3.getVolume() + "% vol.");
        b3.neemSlok();
        System.out.println("B3 zit nog " + b3.getVolume() + "% vol.");
        b3.neemSlok();
        System.out.println("B3 zit nog " + b3.getVolume() + "% vol.");

        System.out.println(Bier.RECEPT_VOOR_PILS);
        System.out.println(Bier.geefReclame());

        System.out.println(b3);
        System.out.println(b4);

        // objects (instances van reference types) vergelijk je ALTIJD met equals.
        if (b3.equals(b4)) {
            System.out.println("b3 en 4 zijn gelijk!");
        }

        System.out.println(w1);

        if (w1.equals(w2)) {
            System.out.println("Wijngelijk!");
        }
    }
}
