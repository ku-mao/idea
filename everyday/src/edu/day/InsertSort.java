package edu.day;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {4, 9, 2, 7, 1, 6};
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > tmp){
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tmp;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
