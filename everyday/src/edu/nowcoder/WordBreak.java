package edu.nowcoder;

import java.util.Set;

/**
 * 给定一个字符串s和一组单词dict，判断s是否可以用空格分割成一个单词序列，
 * 使得单词序列中所有的单词都是dict中的单词（序列可以包含一个或多个单词）。
 * 例如:
 * 给定s=“leetcode”；
 * dict=["leet", "code"].
 * 返回true，因为"leetcode"可以被分割成"leet code".
 */
public class WordBreak {
//    public boolean wordBreak(String s, Set<String> dict) {
//        if (s.length() == 0) {
//            return false;
//        }
//        boolean canBreak[] = new boolean[s.length() + 1];
//        //i 是 [1, s.length()]
//        for (int i = 1; i <= s.length(); i++) {
//            //j < i && f(j) = true && f(j + 1, s.length) = true
//
//            //[1, i]
//            if (dict.contains(s.substring(0, i))) {
//                canBreak[i] = true;
//                continue;
//            }
//
//            //canBreak[j] && [j + 1, i]
//            for (int j = 1; j < i; j++) {
//                if (canBreak[j] && dict.contains(s.substring(j, i))) {
//                    canBreak[i] = true;
//                    break;
//                }
//            }
//        }
//        return canBreak[s.length()];
//    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (s.length() == 0) {
            return false;
        }
        boolean canBreak[] = new boolean[s.length() + 1];
        canBreak[0] = true;
        //i 是 [1, s.length()]
        for (int i = 1; i <= s.length(); i++) {
            //j < i && f(j) = true && f(j + 1, s.length) = true


            //canBreak[j] && [j + 1, i]
            for (int j = 0; j < i; j++) {
                if (canBreak[j] && dict.contains(s.substring(j, i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }
}
