package nl.bramjanssens.generics;

import java.util.ArrayList;
import java.util.List;

import static nl.bramjanssens.generics.Util.verwerkSafe;
import static nl.bramjanssens.generics.Util.verwerkSafeContravariant;
import static nl.bramjanssens.generics.Util.verwerkSafeCovariant;
import static nl.bramjanssens.generics.Util.verwerkSafeRaw;
import static nl.bramjanssens.generics.Util.verwerkUnsafeArray;
import static nl.bramjanssens.generics.Util.verwerkUnsafeRaw;

public class Basics {

    // Generic types = Generics
    public static void main(String[] args) {
        // Using generics:
        List personenUnsafe = new ArrayList();
        personenUnsafe.add(new Person("Bram"));
        personenUnsafe.add(new Person("Leon"));
        personenUnsafe.add("Corne");

        verwerkUnsafeRaw(personenUnsafe);
        verwerkSafeRaw(personenUnsafe);

        List<Person> personenSafe = new ArrayList<>();
        personenSafe.add(new Person("Bram"));
        personenSafe.add(new Person("Leon"));
        // personenSafe.add("Corne"); // NOK

        verwerkUnsafeRaw(personenSafe);
        verwerkSafeRaw(personenUnsafe);
        verwerkSafe(personenSafe);

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

        List<Trainee> trainees = new ArrayList<>();
        // trainees.add(new Person());
        trainees.add(new Trainee());
        // trainees.add(new Trainer());

        // what types can I pass to methods?

        verwerkSafe(persons);
        // verwerkSafeInvariant(trainees);

        verwerkSafeCovariant(persons);
        verwerkSafeCovariant(trainees);

        verwerkSafeContravariant(objects);
        verwerkSafeContravariant(persons);
        // verwerkSafeContravariant(trainees);

        verwerkUnsafeArray(new Trainee[10]);
    }
}
