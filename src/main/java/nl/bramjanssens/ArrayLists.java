package nl.bramjanssens;

import java.util.ArrayList;

public class ArrayLists {

    public static void main(String[] args) {
        // met arrays:
        int currentElement = 0;
        int[] getallenAlsArray = new int[10];
        getallenAlsArray[currentElement] = 42;
        currentElement++;
        getallenAlsArray[currentElement] = 43;
        currentElement++;

        for (int i = 0; i < currentElement; i++) {
            System.out.println(getallenAlsArray[i]);
        }

        // same met arraylist:
        ArrayList<Integer> getallen = new ArrayList<Integer>();

        getallen.add(1);
        getallen.add(34);
        getallen.add(-23341);
        getallen.add(10);

        System.out.println(getallen.remove(Integer.valueOf(1)));

        for (Integer item : getallen) {
            System.out.println(item);
        }
    }
}



