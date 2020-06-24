package edu.nowcoder;

import java.util.Scanner;

/**
 * Fibonacci数列是这样定义的：
 * F[0] = 0
 * F[1] = 1
 * for each i ≥ 2: F[i] = F[i-1] + F[i-2]
 * 因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...，
 * 在Fibonacci数列中的数我们称为Fibonacci数。给你一个N，你想让其变为一个Fibonacci数，
 * 每一步你可以把当前数字X变为X-1或者X+1，现在给你一个数N求最少需要多少步可以变为Fibonacci数。
 */
public class Fibonacci数列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int f1 = 0;
        int f2 = 1;
        int res = 0;
        while (res < N) {
            res = f1 + f2;
            f1 = f2;
            f2 = res;
        }
        System.out.println((f2 - N) < (N - f1) ? (f2 - N) : (N - f1) );
    }
}
