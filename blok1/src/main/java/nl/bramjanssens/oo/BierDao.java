package nl.bramjanssens.oo;

import nl.bramjanssens.oo.records.Bier;

import java.util.ArrayList;

public enum BierDao { // Data Access Object
    // singleton start ----------------------------------------
    INSTANCE;
    // singleton end ------------------------------------------

    private ArrayList<Bier> database = new ArrayList<>();

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
