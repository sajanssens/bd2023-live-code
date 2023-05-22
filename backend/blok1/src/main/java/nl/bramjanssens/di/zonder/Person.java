package nl.bramjanssens.di.zonder;

public class Person {

    // Person heeft een dependency, nl. Laptop
    private Laptop laptop = new Laptop("Dell"); // person maakt zelf de instance van de dependency aan
}
