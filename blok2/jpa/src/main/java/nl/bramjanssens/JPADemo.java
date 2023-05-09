package nl.bramjanssens;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.jboss.weld.environment.se.Weld;

import java.util.List;

@Slf4j
@Singleton
public class JPADemo {

    @Inject // CDI = Contexts and Dependency Injection
    private PersonDao verbinding1;

    @Inject // CDI = Contexts and Dependency Injection
    private PersonDao verbinding2;

    @Inject // CDI = Contexts and Dependency Injection
    private DepartmentDao departmentDao;

    @Inject // CDI = Contexts and Dependency Injection
    private DepartmentDao departmentDao2;

    @Inject // CDI = Contexts and Dependency Injection
    private DepartmentDao departmentDao3;

    @Inject // CDI = Contexts and Dependency Injection
    private TeamDao teamDao;

    public static void main(String[] args) {
        try (SeContainer ballenbakMetDependencyInstanties = Weld.newInstance().initialize()) {
            JPADemo app = ballenbakMetDependencyInstanties.select(JPADemo.class).get();
            app.run();
        }
    }

    private void run() {
        Person cornéSatriani = Person.builder().name("Corné Satriani").age(32).build();
        Person bramPetrucci = Person.builder().name("Bram Petrucci").age(43).build();
        Person leonVai = Person.builder().name("Leon Vai").age(31).build();
        cornéSatriani.getRollen().add(Rol.DEVELOPER);
        cornéSatriani.getRollen().add(Rol.SCRUM_MASTER);
        // Team g3 = Team.builder().name("G3 is the best!").build();
        // cornéSatriani.setMijnTeam(g3);
        // bramPetrucci.setMijnTeam(g3);
        // leonVai.setMijnTeam(g3);
        verbinding1.create(cornéSatriani);
        // verbinding1.create(bramPetrucci);
        // verbinding1.create(leonVai);
        // verbinding1.close();

        // even later...
        Person person = verbinding2.read(1);
        log.info(person.toString());
        verbinding2.close();

        Department iv = Department.builder().name("IV").build();
        departmentDao.create(iv);

        iv.getEmployees().add(cornéSatriani);
        iv.getEmployees().add(bramPetrucci);
        iv.getEmployees().add(leonVai);

        cornéSatriani.setAfdelingWaarIkWerk(iv);
        bramPetrucci.setAfdelingWaarIkWerk(iv);
        leonVai.setAfdelingWaarIkWerk(iv);

        departmentDao.update(iv);
        departmentDao.close();

        // even later...
        Department read = departmentDao2.read(3); // entity is managed = HOT = in verbinding met de DB
        departmentDao2.close(); // entities get detached == unmanaged = COLD = in !verbinding met de DB
        for (Person employee : read.getEmployees()) {
            log.info(employee.toString());
        }

        List<Person> ivs = departmentDao3.getAllEmployees("IV");
        ivs.forEach(System.out::println);

        List<Person> g31 = teamDao.findTeamMembersOf("G3 is the best!");
        g31.forEach(System.out::println);

    }
}
