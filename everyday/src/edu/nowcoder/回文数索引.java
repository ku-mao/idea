package edu.nowcoder;

import java.util.Scanner;

/**
 * 给定一个仅由小写字母组成的字符串。
 * 现在请找出一个位置，删掉那个字母之后，字符串变成回文。
 * 请放心总会有一个合法的解。如果给定的字符串已经是一个回文串，那么输出-1。
 */
public class 回文数索引 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            StringBuilder str = new StringBuilder(scan.next());
            isResult(str);
        }
    }
    private static void isResult(StringBuilder str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                int index = ++i;
                if (str.charAt(index) == str.charAt(j)) {
                    System.out.println(index - 1);
                } else {
                    System.out.println(j);
                }
                return;
            }
        }
        System.out.println(-1);
    }
}
