package edu.nowcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 首个重复单词 {
    public static char findFirstRepeat(String A, int n) {
        char[] ch = A.toCharArray();
        Set<Character> set = new HashSet<>();
        int i = 0;
        for (; i < n; i++) {
            if (set.contains(ch[i])) {
                break;
            } else {
                set.add(ch[i]);
            }
        }
        return ch[i];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入带有重复字符的字符串: ");
        String str = scanner.nextLine();
        System.out.println(findFirstRepeat(str, str.length()));
    }
}
