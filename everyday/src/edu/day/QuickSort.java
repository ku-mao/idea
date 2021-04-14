package edu.day;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 0, 6, 9, 1, 3};
        quickHelper(arr,0,arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    private static void quickHelper(int[] arr, int i, int j) {
        if (i >= j) {
            return;
        }
        int low = i;
        int high = j;
        int position = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= position) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= position) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = position;
        quickHelper(arr, i,low - 1);
        quickHelper(arr, low + 1, j);
    }
}
