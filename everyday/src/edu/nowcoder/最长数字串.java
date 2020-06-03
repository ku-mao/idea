package edu.nowcoder;

import java.util.*;

public class 最长数字串 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;//遍历过程中数字串的长度
        int max = 0;//数字串的最长长度
        int end = 0;//最长数字串的最后一个下标
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c <= '9' && c >= '0') {
                count++;
                if (max < count) {
                    max = count;
                    end = i;
                }
            } else {
                count = 0;
            }
        }
        System.out.println(str.substring((end - max + 1), (end + 1)));
    }
}
