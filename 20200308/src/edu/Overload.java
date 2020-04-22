package edu;

import java.util.Scanner;

public class Overload {
    private static int add(int a, int b) {
        return a + b;
    }
    private static double add(double a, double b, double c) {
        return a + b + c;
    }

    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private static double max(double a,double b) {
        return (a > b) ? a : b;
    }

    private static double max (int a, double b, double c) {
        double d = (double) a;
        return max(max(b,c),d);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        double c = sc.nextDouble();
        double d = sc.nextDouble();
        double e = sc.nextDouble();
        System.out.println(max(a, b));
        System.out.println(max(c, d));
        System.out.println(max(a,c,d));
        System.out.println(add(a,b));
        System.out.println(add(c,d,e));
    }
}
