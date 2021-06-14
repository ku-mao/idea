package edu.day;

import java.util.Scanner;

/**
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
 */
public class LongestHuiWen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(get2(str, str.length()));
    }

    /**
     * 中心扩散法
     * @param A
     * @param n
     * @return
     */
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
            //因为有abba这种情况
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

    /**
     * 暴力法
     */
    public static int get2(String A, int n) {
        if (A == null || A.length() == 0){
            return 0;
        }
        int res = 0;
        for(int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                //优化
                //如果当前的字符串小于最长的回文串  不用进行判断
                if(j - i + 1 < res) {
                    continue;
                }
                if (isHuiWen(A, i, j)) {
                    res = res > j - i + 1 ? res :  j - i + 1;
                }
            }
        }
        return res;
    }
    public static boolean isHuiWen(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
