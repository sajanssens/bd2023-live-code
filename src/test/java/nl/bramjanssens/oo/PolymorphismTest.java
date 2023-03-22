package nl.bramjanssens.oo;

import org.junit.jupiter.api.Test;

class PolymorphismTest {

    @Test
    void print() {
        Polymorphism p = new Polymorphism();

        p.print(new Animal());
        p.print(new Dog());
        p.print(new Cat());
    }
}
