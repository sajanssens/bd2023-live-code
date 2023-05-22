package nl.bramjanssens.unittesting.faking.person;

public interface PersonDao {
    Person insert(String name);

    Person select(String name);

    void remove(int id);
}
