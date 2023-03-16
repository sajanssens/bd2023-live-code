package nl.bramjanssens.types;

public class PrimitiveDemo {

    public static void main(String[] args) {
        byte b1 = 127;
        byte b2 = 2;
        byte b3 = (byte) (b1 + b2); // + geeft altijd een int!
        System.out.println(Math.abs(b3));

        // 16 bits +/-
        short s = -200;

        // 16 bits +
        char a = 97;
        char b = 'b';
        System.out.println(a + b);

        // 32 bits +/-
        int i = 42;
        int result = (int) (4.0 / 5);
        System.out.println(result);

        // 64 bits +/-
        long l = 42424242424242L;

        // 32 bits +/-
        float f = 1f;

        // 64 bits +/-
        double d = 1;

        // 1 bit
        boolean vlag = true;
        boolean vlag2 = false;
    }
}
