package nl.bramjanssens.inheritance;

public class TemporaryEmployee extends Employee {

    private int hours;

    public TemporaryEmployee() {
        super();
    }

    public TemporaryEmployee(String name, int id, double salary, int hours) {
        super(name, id, salary);
        this.hours = hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public double calculateSalary() {
        return plus42(hours) * 15;
    }
}
