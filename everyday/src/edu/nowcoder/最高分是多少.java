package edu.nowcoder;

import java.util.Scanner;

public class 最高分是多少 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = sc.nextInt();
        int[] score = new int[n];
        for (int i = 0; i < n && sc.hasNext(); i++) {
            score[i] = sc.nextInt();
        }
        sc.nextLine();
        for (int i = 0; i < len && sc.hasNext(); i++) {
            String str = sc.nextLine();
            String[] s = str.split(" ");
            int a = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);
            if (s[0].equals("Q")) {
                System.out.println(findMax(score, a, b));
            } else {
                score[a - 1] = b;
            }
        }
    }
    private static int findMax(int[] score, int a, int b) {
        if (a > b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        int max = score[a - 1];
        for (int i = a - 1; i < b; i++) {
            max = (score[i] > max) ? score[i] : max;
        }
        return max;
    }
}
