package nl.bramjanssens.oo;

import nl.bramjanssens.oo.inheritance.Animal;
import nl.bramjanssens.oo.inheritance.Cat;
import nl.bramjanssens.oo.inheritance.Dog;
import nl.bramjanssens.oo.inheritance.Polymorphism;
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
