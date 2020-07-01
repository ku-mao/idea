package edu.nowcoder;

import java.util.Scanner;

/**
 * 对于给定的正整数 n，
 * 计算其十进制形式下所有位置数字之和，
 * 并计算其平方的各位数字之和。
 */
public class 数字之和 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sum(n) + " " + sum(n * n));
    }
    private static int sum (int n) {
        int res = 0;
        while (n != 0) {
            res += (n % 10);
            n = n / 10;
        }
        return res;
    }
}
