package edu.nowcoder;

import java.util.Scanner;

/**
 * 对其ASCII码值进行奇校验，若二进制表示中有奇数个1则正确，
 * 若是偶数个1则应添加一个1使其含奇数个1。此处应特别记住几个常用的ASCII码值:
 * 0–48，A—65，Z–90，a—97,z—122,所以不会超过128，即最初的最高位一定为零，
 * 若要补1，直接在最高上补即可。
 */
public class 奇偶校验 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            System.out.println(check(a[i]));
        }
    }
    private static String check(int num) {
        StringBuffer sb = new StringBuffer();
        StringBuffer tmp = new StringBuffer(Integer.toBinaryString(num));
        int len = 8 - tmp.length();
        while (len != 0) {
            tmp.insert(0, "0");
            len--;
        }
        String str = tmp.substring(1);
        sb.append(str);
        int count = 0;//计算数字中1的个数
        while (num != 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >>> 1;
        }
        if (count % 2 == 0) {
            sb.insert(0, "1");
        } else {
            sb.insert(0, "0");
        }
        return sb.toString();
    }

}
