package edu.day;

/**
 * 实现函数 atoi 。函数的功能为将字符串转化为整数
 * 提示：仔细思考所有可能的输入情况。
 * 这个问题没有给出输入的限制，你需要自己考虑所有可能的情况。
 */

import java.util.Scanner;

/**
 * 1.前后空格
 * 2.字符串为空
 * 3.中间有字符
 * 4.数组越界
 */
public class Atoi {
    public static void main(String[] args) {
        System.out.println("请输入一个字符串: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(atoi(str));
    }
    public static int atoi (String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        str = str.trim();
        int num = 0;
        int index = 0;
        int flag = 1;
        if (str.charAt(0) == '+') {
            index++;
        }
        if (str.charAt(0) == '-') {
            flag = -1;
            index++;
        }
        for (int i = index; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                if (num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE / 10 && str.charAt(i) > '7') {
                    return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }else {
                    num = num * 10 + (str.charAt(i) - '0');
                }
            } else {
                break;
            }
        }
        return flag * num;
    }
}
