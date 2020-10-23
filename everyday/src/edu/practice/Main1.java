package edu.practice;

import java.util.Scanner;
import java.util.Stack;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int ret = cal(str);
        System.out.println(ret);
    }

    private static int cal(String s) {
        int res = 0, d = 0;
        char sign = '+';
        Stack<Integer> nums = new Stack <>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0') {
                d = d * 10 + s.charAt(i) - '0';
            }
            if ((s.charAt(i) < '0' && s.charAt(i) != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    nums.push(d);
                } else if (sign == '-') {
                    nums.push(-d);
                } else if (sign == '*' || sign == '/') {
                    int temp = sign == '*' ? nums.pop() * d : nums.pop() / d;
                    nums.push(temp);
                }
                sign = s.charAt(i);
                d = 0;
            }
        }
        for (int t : nums) {
            res += t;
        }
        return res;
    }
}
