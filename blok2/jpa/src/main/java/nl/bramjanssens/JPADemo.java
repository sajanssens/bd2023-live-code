package nl.bramjanssens;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.jboss.weld.environment.se.Weld;

@Slf4j
@Singleton
public class JPADemo {

    @Inject // CDI = Contexts and Dependency Injection
    private PersonDao dao;

    public static void main(String[] args) {
        try (SeContainer ballenbakMetDependencyInstanties = Weld.newInstance().initialize()) {
            JPADemo app = ballenbakMetDependencyInstanties.select(JPADemo.class).get();
            app.run();
        }
    }

    private void run() {
        Person cornéSatriani = Person.builder().name("Corné Satriani").age(32).build();
        dao.insert(cornéSatriani);

        Person person = dao.select(1);
        log.info(person.toString());
        dao.close();

        // ...
    }
}
