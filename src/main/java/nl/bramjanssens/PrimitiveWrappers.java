package nl.bramjanssens;

public class PrimitiveWrappers {

    int parsedInt;
    int getal;

    public int telEenOp(Object input) {
        if (input instanceof String s) {  // pattern matching
            int parsedInt;
            try {
                parsedInt = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.parsedInt);
            System.out.println(this.getal);

            // ....
            return parsedInt + 1;
        } else {
            throw new IllegalArgumentException("Input moet een string zijn.");
        }
    }

    public void nogEenFunctie() {
        Integer parsedInt = 0;

        System.out.println(parsedInt);
    }
}
