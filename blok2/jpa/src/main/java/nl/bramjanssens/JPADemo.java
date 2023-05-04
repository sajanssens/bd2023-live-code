package nl.bramjanssens;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JPADemo {

    public static void main(String[] args) {

        PersonDao dao = new PersonDao();
        Person cornéSatriani = Person.builder().name("Corné Satriani").age(32).build();
        dao.insert(cornéSatriani);
        dao.close();

        PersonDao dao2 = new PersonDao();
        Person person = dao2.select(1);
        log.info(person.toString());
        dao2.close();

        // ...
    }
}
