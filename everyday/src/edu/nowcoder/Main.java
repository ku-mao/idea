package edu.nowcoder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long m = scanner.nextLong();
            long n = scanner.nextLong();
            long a = 0; //EF
            long b = 0; //CD
            long c = 0; //AB
            int count = 0;
            long i = 0;
            for (i = m; i <= n; i++) {
                a = i % 100;
                if (a < 10) {
                    continue;
                } else {
                    b = (i / 100) % 100;
                    if (b < 10) {
                        continue;
                    } else {
                        if (c < 10) {
                            continue;
                        } else {
                            c = i / 10000;
                        }
                    }
                }
                if (judge(i)&& (c + b == a)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    public static boolean judge(long num) {
        int[] arr = new int[10];
        while (num > 0) {
            int i = (int)num % 10;
            arr[i]++;
            num = num / 10;
        }
        for (int i = 0; i < 10; i++) {
            if (arr[i] > 1) {
                return false;
            }
        }
        return true;
    }
}
