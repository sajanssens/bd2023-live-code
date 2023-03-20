package nl.bramjanssens.types;

public class MyInteger {

    private int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public void increment() {
        value++;
    }

    public int getValue() {
        return value;
    }
}
