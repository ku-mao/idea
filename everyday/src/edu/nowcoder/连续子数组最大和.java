package edu.nowcoder;

import java.util.Scanner;

public class 连续子数组最大和 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }
            int[] dp = new int[n];
            dp[0] = arr[0];
            int max = dp[0];
            for (int i = 1; i < n; i++) {
                if (dp[i - 1] > 0) {
                    dp[i] = dp[i - 1] + arr[i];
                } else {
                    dp[i] = arr[i];
                }
                max = max > dp[i] ? max : dp[i];
            }
            System.out.println(max);
        }
    }
}
