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

    // Type erasure
    public static void verwerkSafe(List<Person> list) {
        for (Person person : list) {
            System.out.println(person.getName());
        }

        list.add(new Person());
        list.add(new Trainee());
        list.add(new Trainer());
    }

    public static <T> void verwerkSafe2(List<T> list) {

    }

    // PECS
    // Producer Extends Consumer Super

    //
    public static void verwerkSafeCovariant(List<? extends Person> list) {
        // for (T person : list) {
        //     System.out.println(person.getName());
        // }
        // no writing allowed
        // list.add(new Person());
        // list.add(new Trainee());
        // list.add(new Trainer());
    }

    // super
    public static void verwerkSafeContravariant(List<?> list) {
        // for (Trainee person : list) {
        //     System.out.println(person.train());
        // }
        //
        // list.add();

    }

    public static void verwerkUnsafeArray(Person[] array) {
        for (Person person : array) {
            if (person != null)
                System.out.println(person.getName());
        }

        array[0] = new Person("Anton");
        array[1] = new Trainer();
        array[2] = new Trainee();
    }

    public void pakLaatste(List<?> list) {
        // list.add(new Object());
    }
}
