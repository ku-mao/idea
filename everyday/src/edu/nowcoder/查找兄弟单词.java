package edu.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 查找兄弟单词 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            ArrayList<String> broList = new ArrayList<>();
            String[] dict = scan.nextLine().split(" ");
            int n = Integer.parseInt(dict[0]);
            String target = dict[n + 1];
            int index = Integer.parseInt(dict[dict.length - 1]);
            for (int i = 1; i <= n; i++) {
                if (dict[i].length() == target.length()
                        && !target.equals(dict[i])
                        && isBrother(dict[i], target)) {
                    broList.add(dict[i]);
                }
            }
            Collections.sort(broList);
            System.out.println(broList.size());
            if (index <= broList.size()) {
                System.out.println(broList.get(index - 1));
            }
        }
    }
    private static boolean isBrother(String word, String target) {
        char[] ch1 = word.toCharArray();
        char[] ch2 = target.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] != ch2[i]) {
                return false;
            }
        }
        return true;
    }
}
