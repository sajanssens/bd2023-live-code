package nl.bramjanssens.inheritance;

import java.util.Objects;

public class PermanentEmployee extends Employee implements Comparable<PermanentEmployee>, Calculatable {

    private int position;

    public PermanentEmployee() {
        super();
    }

    public PermanentEmployee(String name, int id, double salary, int position) {
        super(name, id, salary);
        this.position = position;
    }

    public static int geefHetUniverseleAntwoord() {
        return 42;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public double calculateSalary() {
        return position * 100;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PermanentEmployee that = (PermanentEmployee) o;
        return position == that.position;
    }

    @Override public int hashCode() {
        return Objects.hash(super.hashCode(), position);
    }

    @Override
    public int compareTo(PermanentEmployee other) {
        return this.position - other.position;
        // if (this.position < other.position) {
        //     return -1;
        // }
        //
        // if (this.position > other.position) {
        //     return 1;
        // }
        //
        // return 0;
    }

    @Override public String toString() {
        return "PermanentEmployee{" +
                "position=" + position +
                '}';
    }
}
