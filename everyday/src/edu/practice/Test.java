package edu.practice;

public class Test {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 2, 8, 5, 4};
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a.length  - i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
