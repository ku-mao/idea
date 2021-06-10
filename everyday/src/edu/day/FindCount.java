package edu.day;

import java.util.Scanner;

/**
 * 给你一个非空模板串S，一个文本串T，问S在T中出现了多少次
 * 示例
 * 输入：
 * "ababab","abababab"
 * 返回值：
 * 2
 */
public class FindCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        String T = scanner.nextLine();
        System.out.println(kmp(S, T));
    }
    public static int kmp (String S, String T) {
        int lenS = S.length();
        int lenT = T.length();
        if (lenT <= 0 || lenS <= 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i <= lenT - lenS; i++) {
            if (S.equals(T.substring(i, i + lenS))) {
                count++;
            }
        }
        return count;
    }
}
