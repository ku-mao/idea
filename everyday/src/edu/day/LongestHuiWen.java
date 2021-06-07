package edu.day;

import java.util.Scanner;

/**
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
 */
public class LongestHuiWen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(get(str, str.length()));
    }
    public static int get(String A, int n) {
        if (A == null || A.length() == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int res = 0;
        char[] ch = A.toCharArray();
        for (int i = 0; i < n; i++) {
            left = i;
            right = i;
            while (left - 1 >= 0 && ch[left - 1] == ch[i]) {
                left--;
            }
            while (right + 1 < n && ch[right + 1] == ch[i]) {
                right++;
            }
            while (left - 1 >= 0 && right + 1 < n && ch[left - 1] == ch[right + 1]) {
                left--;
                right++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
