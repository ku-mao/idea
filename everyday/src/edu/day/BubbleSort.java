package edu.day;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 9, 4, 7, 3, 2};
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
