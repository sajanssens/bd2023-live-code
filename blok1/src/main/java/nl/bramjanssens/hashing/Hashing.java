package nl.bramjanssens.hashing;

import java.util.HashSet;
import java.util.Set;

public class Hashing {
    public static void main(String[] args) {
        Set<Person> persons = new HashSet<>();
        Person bram = new Person(42, "Bram");
        Person bram1 = new Person(43, "Bram");

        persons.add(bram);
        persons.add(bram1);

        if (bram.equals(bram1)) System.out.println("Equals");
        System.out.println(persons.size());
    }
}

class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 42;// age ;
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(((Person) obj).name);
    }
}
