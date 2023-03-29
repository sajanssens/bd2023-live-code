package nl.bramjanssens.oo;

import nl.bramjanssens.oo.records.Bier;

import java.util.ArrayList;

public class BierDao { // Data Access Object

    private ArrayList<Bier> database = new ArrayList<>();

    // singleton start ----------------------------------------
    private static BierDao instance;// = new BierDao();

    private BierDao() { }

    public static BierDao getInstance() {
        if (instance == null) {
            instance = new BierDao();
        }

        return instance;
    }
    // singleton end ------------------------------------------

    // CRUD: Create, Read, Update, Delete
    public void voegToe(Bier b) {
        database.add(b);
    }

    public Bier nieuw(String naam, double alc, int volume) {
        return new Bier(naam, alc, volume);
    }

    public ArrayList<Bier> getAll() {
        return database;
    }
}
