package edu;

public class TestDemo2 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int ret = add(a, b);
        System.out.println(ret);
        double c = 10.6;
        double d = 12.6;
        double ret1 = add(c, d);
        System.out.println(ret1);
    }
    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }
}
