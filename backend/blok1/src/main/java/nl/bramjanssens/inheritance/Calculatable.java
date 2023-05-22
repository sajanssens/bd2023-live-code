package nl.bramjanssens.inheritance;

@FunctionalInterface // BONUS
public interface Calculatable {

    double calculateSalary();

    default int plus42(int i) {
        return i + 42;
    }
}
