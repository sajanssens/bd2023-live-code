package nl.bramjanssens.di.met;

public class DiEngine {

    public static void main(String[] args) {
        Laptop dell = new Laptop("Dell");
        Laptop hp = new Laptop("HP");
        Person bram = new Person();

        // setter injection
        bram.setLaptop(dell);

        // field injection:
        bram.laptop = dell;

        // constructor injection:
        bram = new Person(dell);
    }

}
