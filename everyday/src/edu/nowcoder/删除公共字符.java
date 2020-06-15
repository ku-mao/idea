package edu.nowcoder;

import java.util.Scanner;

/**
 * 输入两个字符串，
 * 从第一字符串中删除第二个字符串中所有的字符。
 * 例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
 */
public class 删除公共字符 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        char[] c = str1.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if(!str2.contains(c[i] +"")) {
                System.out.print(c[i]);
            }
        }
    }
}
