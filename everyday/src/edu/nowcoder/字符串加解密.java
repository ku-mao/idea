package edu.nowcoder;

import java.util.Scanner;

/**
 *加密方法为：
 *当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,
 * 如字母a时则替换为B；字母Z时则替换为a；
 *当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 *其他字符不做变化。
 *
 * 解密方法为加密的逆过程。
 */
public class 字符串加解密 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String pwd = sc.nextLine();
            String unPwd = sc.nextLine();
            System.out.println(Encrypt(pwd));
            System.out.println(unEncrypt(unPwd));
        }
    }
    private static String Encrypt(String pwd) {
        char[] ch = pwd.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'a' && ch[i] < 'z') {
                ch[i] = (char)(ch[i] - 31);
            } else if (ch[i] == 'z') {
                ch[i] = 'A';
            } else if (ch[i] >= 'A' && ch[i] < 'Z') {
                ch[i] = (char)(ch[i] + 33);
            } else if (ch[i] == 'Z') {
                ch[i] = 'a';
            } else if (ch[i] >= '0' && ch[i] < '9') {
                ch[i] = (char)(ch[i] + 1);
            } else if(ch[i] == '9'){
                ch[i] = '0';
            }
        }
        return String.copyValueOf(ch);
    }
    private static String unEncrypt(String unPwd) {
        char[] ch = unPwd.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] > 'a' && ch[i] <= 'z') {
                ch[i] = (char)(ch[i] - 33);
            } else if (ch[i] == 'a') {
                ch[i] = 'Z';
            } else if (ch[i] > 'A' && ch[i] <= 'Z') {
                ch[i] = (char)(ch[i] + 31);
            } else if (ch[i] == 'A') {
                ch[i] = 'z';
            } else if (ch[i] > '0' && ch[i] <= '9') {
                ch[i] = (char)(ch[i] - 1);
            } else if (ch[i] == '0'){
                ch[i] = '9';
            }
        }
        return String.copyValueOf(ch);
    }
}
