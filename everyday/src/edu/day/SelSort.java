package edu.day;

public class SelSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 3, 7, 6, 4};
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int tmp = arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
        }
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
