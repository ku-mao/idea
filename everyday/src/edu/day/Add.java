package edu.day;

import java.util.Scanner;

/**
 * 两个数相加, 不用加减乘除符号
 */
public class Add {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个要相加的整数: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(add(a, b));
    }
    private static int add(int num1, int num2) {
        while (num1 != 0) {
            int tmp = num1 ^ num2; //无进位
            num1 = (num1 & num2) << 1; //进位
            num2 = tmp;
        }
        return num2;
    }
}
