package edu.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestSort {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList <>();
        arrayList.add(9);
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(7);
        arrayList.add(3);
        arrayList.add(6);
        arrayList.add(8);

        Collections.sort(arrayList);
        System.out.println(arrayList);

        int[] array = {9, 5, 2, 7, 3, 6, 8};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
