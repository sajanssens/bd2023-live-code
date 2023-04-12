package nl.bramjanssens.generics;

public class BoxNumber {

    private Number contents;

    public BoxNumber(Number contents) {
        this.contents = contents;
    }

    public Number getContents() {
        return contents;
    }

    public void setContents(Number contents) {
        this.contents = contents;
    }
}
