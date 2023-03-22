package nl.bramjanssens;

import java.util.ArrayList;

public class ArrayLists {
    public static void main(String[] args) {
        ArrayList<Integer> getallen = new ArrayList<Integer>();

        getallen.add(1);
        getallen.add(34);
        getallen.add(-23341);
        getallen.add(10);

        System.out.println(getallen.get(0));

        for (Integer item : getallen) {
            System.out.println(item);
        }

        // met arrays:
        int currentElement = 0;
        int[] getallenAlsArray = new int[10];
        getallenAlsArray[currentElement] = 42;
        currentElement++;
        getallenAlsArray[currentElement] = 42;
        currentElement++;
        for (int i = 0; i < currentElement; i++) {
            System.out.println(getallenAlsArray[i]);
        }
    }
}



