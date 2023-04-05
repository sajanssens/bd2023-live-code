package nl.bramjanssens.inheritance;

public interface Calculatable2 {

    double calculateSalary();

    default int plus42(int i) {
        return i + 42;
    }
}
