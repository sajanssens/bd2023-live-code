package nl.bramjanssens.paradigms;

public class OO {

    public static void main(String[] args) {
        double a = 8.5; // literal value
        Bier laTrappe = new Bier();
        laTrappe.setType("Tripel");
        laTrappe.setAlcoholpercentage(8.55);

        Bier leffeBlond = new Bier("Blond", 6.02);

        Bier affligemBlond = new Bier(Biertype.B, 6.3);

        leffeBlond = null;
        System.gc();

        Bier laTrappe2 = new Bier();

        System.out.println(fac(10));
        System.out.println(facIteratief(10));
    }

    private static long fac(int n) {
        if (n <= 1) { // stopconditie
            return 1;
        } else { // recursieve stap
            return n * fac(n - 1);
        }
    }

    private static long facIteratief(int n) {
        long result;

        result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
            // result = result * i ;
        }
        return result;
    }
}


