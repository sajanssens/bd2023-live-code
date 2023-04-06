package nl.bramjanssens.inheritance;

public class SpecialLocalClasses {

    public void notAnonymous() {
        Item item = new Item();
        item.calculateSalary();
    }

    public void methodLocal() {
        class ItemLocal implements Calculatable {
            @Override
            public double calculateSalary() {
                return 1337;
            }
        }

        calculate(new ItemLocal());
        calculate(new ItemLocal());
        calculate(new ItemLocal());
    }

    public int methodLocalToo() {
        record Tuple(int x, int y, int z) { }

        Tuple tuple = new Tuple(1, 2, 3);

        return tuple.x + tuple.y + tuple.z;
    }

    public void anonymous() {
        Calculatable c = new Calculatable() {
            @Override public double calculateSalary() {
                return 52;
            }
        };

        calculate(c);

        // BONUS
        calculate(() -> 52);
    }

    public double calculate(Calculatable c) {
        return c.calculateSalary();
    }
}


