package nl.bramjanssens.di.met;

public class Person {

    // Person heeft een dependency, nl. Laptop
    /*@Inject */
    // voor field injection
    Laptop laptop = new Laptop("Dell"); // person krijgt  de instance van de dependency aangeleverd

    // altijd nodig
    public Person() { }

    // voor constructor injection
    // @Inject
    public Person(Laptop lap) {
        this.laptop = lap;
    }

    // voor setter injection
    // @Inject
    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
}
