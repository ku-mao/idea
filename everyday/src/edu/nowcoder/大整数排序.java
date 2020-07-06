package edu.nowcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 大整数排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() - s2.length() != 0) {
                    return s1.length() - s2.length();
                } else {
                    return s1.compareTo(s2);
                }
            }
        });
        for (String ss : s) {
            System.out.println(ss);
        }
    }
}
