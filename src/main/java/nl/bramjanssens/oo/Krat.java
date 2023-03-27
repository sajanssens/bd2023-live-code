package nl.bramjanssens.oo;

import java.awt.*;
import java.util.ArrayList;

public class Krat {

    private int capaciteit;
    private Color kleur;

    ArrayList<Bier> inhoud = new ArrayList<>();

    void voegToe(Bier b) {
        this.inhoud.add(b);
    }
}
