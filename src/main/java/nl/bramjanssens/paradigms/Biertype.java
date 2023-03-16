package nl.bramjanssens.paradigms;

public enum Biertype {

    B("Blond"), T("Tripel"), DUBBEL(), PILS();

    // STATE (data) (fields, attributes)
    private String name;

    // BEHAVIOUR (functies)
    Biertype() {

    }

    Biertype(String n) {
        name = n;
    }

    public String getName(){
        return name;
    }
}
