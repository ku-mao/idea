package edu.nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则按字典序打印出
 * 由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class 字符串的排列 {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        StringBuilder s = new StringBuilder(str);
        PermutationHelper(s, 0, result);
        Collections.sort(result);
        return result;
    }
    private static void PermutationHelper(StringBuilder s, int start, ArrayList<String> result){
        //递归出口, 就是子问题只有一个字符
        if (start == s.length() - 1) {
            if (!isExit(s, result)) {
                result.add(s.toString());
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            swap(s, start, i);
            // 第一个元素定了, 后面的就是一个原问题的子问题
            PermutationHelper(s, start + 1, result);
            swap(s, start, i);
        }
    }
    private static boolean isExit(StringBuilder s, ArrayList<String> result) {
        return result.contains(s.toString());
    }
    private static void swap(StringBuilder s, int start, int i) {
        char c1 = s.charAt(start);
        char c2 = s.charAt(i);
        s.setCharAt(start, c2);
        s.setCharAt(i, c1);
    }

    public static void main(String[] args) {
        System.out.println("请输入一个字符串: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("全排序的结果是: ");
        System.out.println(Permutation(str));
    }
}
