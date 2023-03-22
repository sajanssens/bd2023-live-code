package nl.bramjanssens.arraylists;

import java.util.ArrayList;

public class CijferadministratieMetList {

    private ArrayList<Integer> cijfers = new ArrayList<>();

    public void voegNieuweCijfersToe(int... cijfers) {
        for (int cijfer : cijfers) {
            this.cijfers.add(cijfer);
        }
    }

    public double berekenGemiddeldeImperativeProceduralStyle() {
        double som = 0.0;
        int aantal = 0;

        for (Integer cijfer : cijfers) {
            if (cijfer >= 6) {
                som += cijfer;
                aantal++;
            }
        }

        if (aantal > 0) {
            return som / aantal;
        } else {
            return 0.0;
        }
    }

    public double berekenGemiddeldeDeclarativeFunctionalStyle() {
        return cijfers.stream()
                .filter(i -> i >= 6)
                .mapToInt(i -> i.intValue())
                .average()
                .orElse(0.0);
    }
}
