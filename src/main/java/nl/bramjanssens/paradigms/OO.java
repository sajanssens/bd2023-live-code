package nl.bramjanssens.paradigms;

public class OO {

    public static void main(String[] args) {
        double a = 8.5; // literal value
        Bier laTrappe = new Bier();
        laTrappe.setType("Tripel");
        laTrappe.setAlcoholpercentage(8.55);

        Bier leffeBlond = new Bier("Blond", 6.02);

        Bier affligemBlond = new Bier(Biertype.B, 6.3);
    }
}


