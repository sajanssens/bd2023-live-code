package nl.bramjanssens.oo;

import java.util.ArrayList;

public class Dao<T> { // Data Access Object

    private final Dao<T> instance = new Dao<>();

    private ArrayList<T> database = new ArrayList<>();

    // CRUD: Create, Read, Update, Delete
    public void voegToe(T b) {
        database.add(b);
    }

    public T nieuw() {
        return (T) new Object();
    }

    public ArrayList<T> getAll() {
        return database;
    }
}
