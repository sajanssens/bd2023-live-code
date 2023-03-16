package nl.bramjanssens.paradigms;

public class Bier {

    // STATE (data) (fields, attributes)
    private String type;
    private Biertype typeAlsEnum;
    private double alcoholpercentage;

    // BEHAVIOUR (functies)
    public Bier() {

    }

    // overloading
    public Bier(String eenType, double a) { // constructor
        type = eenType;
        setAlcoholpercentage(a);
    }

    public Bier(Biertype t, double a) {
        type = t.getName();
        typeAlsEnum = t;
        setAlcoholpercentage(a);
    }

    public void setType(String eenType) {
        type = eenType;
    }

    public void setAlcoholpercentage(double a) {
        if (a < 20.0) {
            alcoholpercentage = a;
        }
    }
}
