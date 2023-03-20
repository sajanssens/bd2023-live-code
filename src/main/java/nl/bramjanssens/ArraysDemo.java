package nl.bramjanssens;

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
}
