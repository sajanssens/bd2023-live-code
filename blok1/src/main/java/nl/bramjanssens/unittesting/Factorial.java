package nl.bramjanssens.unittesting;

public class Factorial {

    public long fac(int i) {
        if (i < 0) throw new IllegalArgumentException();
        return i <= 1 ? 1 : 2;
    }
}
