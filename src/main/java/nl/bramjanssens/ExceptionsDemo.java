package nl.bramjanssens;

public class ExceptionsDemo {

    public static void main(String[] args) {
        fun1();
        System.out.println("Einde.");
    }

    private static void fun1() {
        try {
            fun3();
            System.out.println("einde try");
            return;
        } catch (RadioBergeijkException e) {
            System.out.println("Het is verschrikkellllijk!!! " + e.getMessage());
            return;
        } finally {
            System.out.println("Het is lente!!");
        }
    }

    private static void fun3() throws RadioBergeijkException {
        fun2();
    }

    private static void fun2() throws RadioBergeijkException {
        throw new RadioBergeijkException("Er ging iets vreselijk mis!");
    }
}


