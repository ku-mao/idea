package edu.day;

import java.util.Scanner;

public class JieCheng {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(calc(n));
        System.out.println(calc2(n));
    }
    private static int calc(int num) {
        int ret = 1;
        int sum = 0;
        while (num > 0) {
            for (int i = 2; i <= num; i++) {
                ret *= i;
            }
            sum += ret;
            num--;
            ret = 1;
        }
        return sum;
    }
    private static int calc2 (int n) {
        int ret = 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            ret *= i;
            sum += ret;
        }
        return  sum;
    }
}
