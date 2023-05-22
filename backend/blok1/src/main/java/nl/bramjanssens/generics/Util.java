package nl.bramjanssens.generics;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Util {

    public static void verwerkUnsafe(List list) {
        for (Object o : list) {
            if (o instanceof Person) {
                Person p = (Person) o;
                System.out.println(p.getName());
            } else {
                log.error("Dit is geen persoon: " + o);
            }
        }
    }

    // wildcard
    public static void verwerk(List<?> list) {
        // U niet gebruikt
    }

    // Variance:

    // only List<Person> allowed, nothing else (for T)
    // reading from and writing to list both allowed and safe
    public static void verwerkSafeInvariant(List<Person> list) {
        for (Person person : list) {
            System.out.println(person.getName());
        }

        list.add(new Person());
        list.add(new Trainee());
        list.add(new Trainer());
    }

    // PECS
    // Producer Extends Consumer Super

    // Extends = Producer: reading from list allowed and safe, writing not
    public static <T extends Person> void verwerkSafeCovariant(List<T> list) {
        for (T person : list) {
            System.out.println(person.getName());
        }
        // no writing allowed
        // list.add(new Person());
        // list.add(new Trainee());
        // list.add(new Trainer());
    }

    // Super = Consumer: writing to list allowed and safe, reading too (but Object)
    public static void verwerkSafeContravariant(List<? super Person> list) {
        // reading
        // element can be anything, so Object
        for (Object o : list) {
            System.out.println(o);
        }

        // writing
        // allowed are T's that extend Person and Person itself, since that's the only thing we know for sure:
        list.add(new Person());
        list.add(new Trainee());
        list.add(new Trainer());
    }

    // Arrays are covariant, but unsafe
    public static void verwerkUnsafeArray(Person[] array) {
        for (Person person : array) {
            if (person != null)
                System.out.println(person.getName());
        }

        array[0] = new Person("Anton");
        array[1] = new Trainer();
        array[2] = new Trainee();
    }
}
