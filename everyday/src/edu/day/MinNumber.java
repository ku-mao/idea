package edu.day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MinNumber {
    public static void main(String[] args) {
        int[] arr = {3, 32, 321};
        System.out.println(printMinNumber(arr));
    }
    public static String printMinNumber(int [] numbers) {
        if (numbers.length == 0) {
            return new String();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                String aStr = a + "" + b;
                String bStr = b + "" + a;
                return aStr.compareTo(bStr);
            }
        });
        String result = "";
        for (int num : list) {
            result += num;
        }
        return result;
    }
}
