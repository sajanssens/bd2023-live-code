package nl.bramjanssens.types;

public class ReferenceTypeDemo {

    private static int z = 42;

    public static void main(String[] args) {
        int getalPrim = 3;
        int getalRef = Integer.valueOf(3); // wrappers for primitives

        Integer x = 42; // auto boxing
        int y = x + 1; // auto unboxing

        // veel sneller:
        int a = 42;
        int b = 42 + 1;

        int zLokaal = 42;
        zLokaal = verhoog(zLokaal); // pass by value/reference?
        System.out.println(zLokaal);

        verhoogZ();
        System.out.println(ReferenceTypeDemo.z);

        MyInteger zAlsRefInteger = new MyInteger(666);
        verhoogAlsRef(zAlsRefInteger);
        System.out.println(zAlsRefInteger.getValue());
    }

    private static void verhoogAlsRef(MyInteger zAlsRefInteger) {
        zAlsRefInteger.increment();
    }

    private static void verhoogZ() {
        z++;
    }

    private static int verhoog(int getalPrim) {
        // getalPrim++;
        // return getalPrim;
        return ++getalPrim;
    }
}
