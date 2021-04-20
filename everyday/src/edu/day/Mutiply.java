package edu.day;

public class Mutiply {
    public static void main(String[] args) {
        int[] A = {1, 3, 6, 4};
        int[] B = multiply(A);
        for (int i : B) {
            System.out.print(i+ " ");
        }
    }
    public static int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    B[i] *= A[j];
                }
            }
        }
        return B;
    }
}
