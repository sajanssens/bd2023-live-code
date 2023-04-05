package nl.bramjanssens.oo.records;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class BierAlsDataClass {

    private String naam;
    private double alc;
    private int vol;
}
