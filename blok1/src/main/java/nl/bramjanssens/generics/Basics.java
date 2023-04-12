package nl.bramjanssens.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static nl.bramjanssens.generics.Util.verwerkSafe;
import static nl.bramjanssens.generics.Util.verwerkSafe2;
import static nl.bramjanssens.generics.Util.verwerkSafeCovariant;
import static nl.bramjanssens.generics.Util.verwerkUnsafe;
import static nl.bramjanssens.generics.Util.verwerkUnsafeArray;

public class Basics {

    // Generic types = Generics
    public static void main(String[] args) {
        // List<Person> personenUnsafe = new ArrayList<>();
        List personenUnsafe = new ArrayList();
        personenUnsafe.add(new Person("Bram"));
        personenUnsafe.add(new Person("Leon"));
        personenUnsafe.add("Corne");

        verwerkUnsafe(personenUnsafe);

        List<Person> personenSafe = new ArrayList<>();
        personenSafe.add(new Person("Bram"));
        personenSafe.add(new Person("Leon"));
        // personenSafe.add("Corne"); // NOK

        verwerkUnsafe(personenSafe);
        verwerkSafe(personenSafe);

        // type argument
        Box<Integer> bi = new Box<>(42);
        Integer contents = bi.getContents();

        Box<String> bs = new Box<>("42");
        String contents2 = bs.getContents();

        List<Person> persons = new ArrayList<>();
        persons.add(new Person());
        persons.add(new Trainee());
        persons.add(new Trainer());

        List<?> lijst = new ArrayList<>();
        verwerkSafe2(lijst);

        List<Trainee> javaKlasXII = new ArrayList<>();
        // javaKlasXII.add(new Person());
        javaKlasXII.add(new Trainee());
        // javaKlasXII.add(new Trainer());

        verwerkSafe(persons);
        // verwerkSafe(javaKlasXII);


        verwerkSafeCovariant(javaKlasXII);
        verwerkSafeCovariant(persons);

        verwerkUnsafeArray(new Trainee[10]);

        // Collections.sort(javaKlasXII);


    }


}
