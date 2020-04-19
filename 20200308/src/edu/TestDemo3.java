package edu;

public class TestDemo3 {
    public static void main(String[] args) {
        System.out.println(sum(5));
        System.out.println(sum1(5));
        System.out.println(fac(5));
    }


    //递归
    public static int sum1(int n) {
        if(n == 1) {
            return 1;
        }
        return n + sum1(n - 1);
    }

    //迭代
    public static int sum(int n) {
        int ret = 0;
        for (int i = 1; i <= n; i++) {
            ret += i;
        }
        return ret;
    }

    //递归求n的阶乘
    public static int fac(int n) {
        if(n == 1) {
            return 1;
        }
        return n * fac(n - 1);
    }
}
