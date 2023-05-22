package nl.bramjanssens.paradigms;

public class Bier {

    // STATE (data) (fields, attributes)
    public String type;
    private Biertype typeAlsEnum;
    private double alcoholpercentage;

    // BEHAVIOUR (functies)
    public Bier() {

    }

    // overloading
    public Bier(String eenType, double a) { // constructor
        this(Biertype.T, a);
        this.type = eenType;
    }

    public Bier(Biertype t, double a) {
        type = t.getName();
        typeAlsEnum = t;
        setAlcoholpercentage(a);
    }

    public Bier(Bier teKopierenBiertje) {
        type = new String(teKopierenBiertje.type.toCharArray());
        setAlcoholpercentage(teKopierenBiertje.alcoholpercentage);
        typeAlsEnum = teKopierenBiertje.typeAlsEnum;
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
