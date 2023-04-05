package nl.bramjanssens;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysDemo {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int i = s.nextInt();
        Integer[] lijst = new Integer[i];
        for (Integer getal : lijst) {
            System.out.println(getal);
        }
    }

    public void copyArray() {
        int[] getallen = {1, 2, 3};

        int[] getallenGroter = new int[6];
        for (int i = 0; i < getallen.length; i++) {
            getallenGroter[i] = getallen[i];
        }

        int[] getallenGroter2 = Arrays.copyOf(getallenGroter, 6);
    }
}
