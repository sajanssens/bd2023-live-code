package nl.bramjanssens.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Hashing {

    public static void main(String[] args) {
        Person bram0 = new Person(42, "Bram");
        Person bram1 = new Person(43, "Bram"); // equal by name, but also by hashcode?
        Person bram2 = new Person(43, "Mieke");

        Set<Person> persons = new HashSet<>();

        persons.add(bram0);
        persons.add(bram1);
        persons.add(bram2);

        if (bram0.equals(bram1)) System.out.println("Equals");
        persons.forEach(System.out::println);

        // A hashset uses a map internally to store its elements as keys in the map, like this:
        Map<Person, Object> personMap = new HashMap<>();
        Object PRESENT = new Object();

        personMap.put(bram0, PRESENT);
        personMap.put(bram1, PRESENT); // key must be unique, so equal persons won't get put into map
        personMap.put(bram2, PRESENT);

        personMap.keySet().forEach(System.out::println);
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
        return 42;
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(((Person) obj).name);
    }

    @Override public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
