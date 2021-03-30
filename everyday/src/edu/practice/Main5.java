package edu.practice;

import java.util.ArrayList;

public class Main5 {
    public int[][] help (int[] arr, int start, int end) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        if (start == end) {
            list.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i <= end; i++) {
                tmp.add(arr[i]);
                int k = arr[i];
                arr[i] = arr[start];
                arr[start] = k;
                help(arr, start+1, end);
                k = arr[start];
                arr[start] = arr[i];
                arr[i] = k;
            }
        }
        int[][] ret = new int[list.size()][list.get(0).size()];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < ret[0].length; j++) {
                ret[i][j] = list.get(i).get(j);
            }
        }
        return ret;
    }
}
