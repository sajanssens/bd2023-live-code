package nl.bramjanssens.inheritance;

public class Item implements Calculatable {
    @Override
    public double calculateSalary() {
        return 1337;
    }
}
