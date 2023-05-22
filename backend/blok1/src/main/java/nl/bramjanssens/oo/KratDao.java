package nl.bramjanssens.oo;

import nl.bramjanssens.oo.records.Bier;

import java.util.ArrayList;

public enum KratDao { // Data Access Object
    // singleton start ----------------------------------------
    INSTANCE;
    // singleton end ------------------------------------------

    private ArrayList<Krat> database = new ArrayList<>();

    // CRUD: Create, Read, Update, Delete
    public void voegToe(Krat b) {
        database.add(b);
    }

    public Krat nieuw() {
        return new Krat();
    }

    public ArrayList<Krat> getAll() {
        return database;
    }
}
