package nl.bramjanssens.types;

import java.math.BigDecimal;

public class DoubleDemo {

    public static void main(String[] args) {
        double berenburgSinas = 1.81;
        double vanillecolaUitDeKoelkast = 1.09;

        System.out.println(berenburgSinas + vanillecolaUitDeKoelkast);

        BigDecimal berenburgSinas2 = new BigDecimal("1.81");
        BigDecimal vanillecolaUitDeKoelkast2 = new BigDecimal("1.09");
        BigDecimal sum = berenburgSinas2.add(vanillecolaUitDeKoelkast2);

        System.out.println(sum.toString());
    }
}
