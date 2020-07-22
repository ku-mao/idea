package edu.nowcoder;

import java.util.Scanner;

public class 替换空格 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串: ");
        StringBuffer str = new StringBuffer(scanner.nextLine());
        System.out.println(replaceSpace(str));
    }
    private static String replaceSpace(StringBuffer str) {
        // 字符串肯定会变长 新的长度 = 原来的长度 + 2 * 空格的长度
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        int newLength = str.length() + 2 * count;
        int oldIndex = str.length() - 1;
        str.setLength(newLength);
        int newIndex = newLength - 1;

        while (newIndex >= 0 && oldIndex >= 0) {
            if (str.charAt(oldIndex) == ' ') {
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
                oldIndex--;
            } else {
                str.setCharAt(newIndex--, str.charAt(oldIndex--));
            }
        }
        return str.toString();
    }
}
