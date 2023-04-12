package nl.bramjanssens.generics;

import java.util.ArrayList;
import java.util.List;

import static nl.bramjanssens.generics.Util.verwerkSafeContravariant;
import static nl.bramjanssens.generics.Util.verwerkSafeCovariant;
import static nl.bramjanssens.generics.Util.verwerkSafeInvariant;
import static nl.bramjanssens.generics.Util.verwerkUnsafe;
import static nl.bramjanssens.generics.Util.verwerkUnsafeArray;

public class Basics {

    // Generic types = Generics
    public static void main(String[] args) {
        // Using generics:
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
        verwerkSafeInvariant(personenSafe);

        // Creating (and using) generic classes:
        Box<Integer> bi = new Box<>(42); //   Integer is a type argument
        Integer i = bi.getContents();

        Box<String> bs = new Box<>("42");
        String s = bs.getContents();

        // Super/subtypes and generics: ----------

        List<Object> objects = new ArrayList<>();
        objects.add(new Person("Bram"));
        objects.add(new Person("Leon"));
        objects.add("Corne");

        List<Person> persons = new ArrayList<>();
        persons.add(new Person());
        persons.add(new Trainee());
        persons.add(new Trainer());

        List<Trainee> javaKlasXII = new ArrayList<>();
        // javaKlasXII.add(new Person());
        javaKlasXII.add(new Trainee());
        // javaKlasXII.add(new Trainer());

        // what types can I pass to methods?

        verwerkSafeInvariant(persons);
        // verwerkSafeInvariant(javaKlasXII);

        verwerkSafeCovariant(persons);
        verwerkSafeCovariant(javaKlasXII);

        verwerkSafeContravariant(objects);
        verwerkSafeContravariant(persons);
        // verwerkSafeContravariant(javaKlasXII);

        verwerkUnsafeArray(new Trainee[10]);
    }
}
