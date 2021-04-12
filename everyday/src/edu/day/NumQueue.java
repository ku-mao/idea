package edu.day;

import java.util.Scanner;

public class NumQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            if (arr[i] < arr[j]) {
                sb.append(arr[i]);
                i++;
            } else if (arr[i] > arr[j]){
                sb.append(arr[j]);
                j--;
            } else {
                if (arr[i + 1] > arr[j - 1] ) {
                    sb.append(arr[j]);
                    j--;
                } else {
                    sb.append(arr[i]);
                    i++;
                }
            }
        }
        for (int k = 0; k < sb.length();k++) {
            System.out.print(sb.charAt(k));
        }
    }
}

