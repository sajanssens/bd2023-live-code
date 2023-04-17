package nl.bramjanssens.unittesting;

public class Factorial {

    public long fac(int n) {
        if (n < 0) throw new IllegalArgumentException();

        return n == 0 ? 1 : n * fac(n - 1);
    }
}
