package edu;

import java.util.Scanner;

public class TestDemo {
    //递归求解n的阶乘
    private static int fac1(int n) {
        if(n == 1) {
            return 1;
        }
        return n * fac1(n-1);
    }


    //求n的阶乘
    private static int fac(int n) {
        int ret = 1;
        for (int i = 1; i <= n; i++) {
            ret = ret * i;
        }
        return ret;
    }

    //1到n的阶乘的和
    private static int facSum(int n) {
        int sum = 0;
        int ret = 1;
        for (int i = 1; i <= n; i++) {
            ret = ret * i;
            sum += ret;
        }
        return sum;
    }

    //2个数中的最大值
    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    //三个数中的最大值
    private static int maxT(int a, int b, int c) {
         return max(max(a,b),c);
    }

    //求1到n的和
    private static void sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println(sum);
    }


    public static void main(String[] args) {
        System.out.println(max(10, 20));
        System.out.println(maxT(10,15,12));
        System.out.println(facSum(4));
        System.out.println(fac(5));
        System.out.println(fac1(5));
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sum(n);
    }
}
