package nl.bramjanssens;

public class InlineConditional {

    public static void main(String[] args) {
        int i = 0;
        // i < 3 ? 5 : 7;
        int result = i < 3 ? 5 : 7;

        System.out.println(i < 3 ? 5 : 7);

        int resultToo;
        if (i < 3) {
            resultToo = 5;
        } else {
            resultToo = 7;
        }
    }
}
