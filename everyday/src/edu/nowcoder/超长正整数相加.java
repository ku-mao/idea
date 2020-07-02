package edu.nowcoder;

import java.util.Scanner;

public class 超长正整数相加 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            System.out.println(AddLongInteger(str1, str2));
        }
    }
    public static String AddLongInteger(String addend, String augend) {
        StringBuffer s1 = new StringBuffer(addend);
        StringBuffer s2 = new StringBuffer(augend);
        StringBuffer s = new StringBuffer();
        int len1 = s1.length();
        int len2 = s2.length();

        //把两个字符串补得一样长
        if (len1 - len2 > 0) {
            for (int i = 0; i < len1 - len2; i++) {
                s2.insert(0, '0');
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                s1.insert(0, '0');
            }
        }

        int temp = 0;
        int sum = 0;
        for (int i = s1.length() - 1; i >= 0; i--) {
            int n1 = s1.charAt(i) - '0';
            int n2 = s2.charAt(i) - '0';
            sum = n1 + n2 + temp;
            temp = sum / 10;
            s.insert(0, sum % 10);
        }
        if (temp != 0) {
            s.insert(0, temp);
        }
        return s.toString();
    }
}
