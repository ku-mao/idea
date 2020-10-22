package edu.practice;

import java.util.Scanner;

public class M {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] ss = s.split(" ");
        int[] arr = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }
        int year = arr[ss.length-1];
        int ret = cal(year);
        System.out.println(ret);
    }
    static int count = 1;
    public static int cal(int year) {
        for (int i = 0; i <= year; i++) {
            if (i == 2 || i == 4) {
                count++;
                cal(year - i);
            }
            if (i == 5) {
                count--;
                continue;
            }
        }
        return count;
    }
}
