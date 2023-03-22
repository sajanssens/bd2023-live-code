package nl.bramjanssens.arraylists;

public class Cijferadministratie {

    private int[] cijfers = new int[10];
    private int nextIndex = 0;

    public void voegNieuwCijferToe(int cijfer) {
        this.cijfers[nextIndex] = cijfer;
        nextIndex++;
    }

    public void berekenGemiddelde() {
        int som = 0;
        for (int i = 0; i < nextIndex; i++) {
            som += cijfers[i];
        }
        System.out.println(som / nextIndex);
    }
}
