package nl.bramjanssens.arraylists;

import java.util.ArrayList;

public class CijferadministratieMetList {

    private ArrayList<Integer> cijfers = new ArrayList<>();

    public void voegNieuwCijferToe(int cijfer) {
        cijfers.add(cijfer);
    }

    public void berekenGemiddeldeImperativeProceduralStyle() {
        double som = 0.0;
        for (Integer cijfer : cijfers) {
            som += cijfer;
        }
        System.out.println(som / cijfers.size());
    }

    public void berekenGemiddeldeDeclarativeFunctionalStyle() {
        double result = cijfers.stream()
                .filter(i -> i >= 6)
                .mapToInt(i -> i.intValue())
                .average()
                .orElse(0.0);

        System.out.println(result);
    }
}
