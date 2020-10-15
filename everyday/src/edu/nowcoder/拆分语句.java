package edu.nowcoder;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串s和一组单词dict，判断s是否可以用空格分割成一个单词序列，使得单词序列中所有的单词都是dict中的单词（序列可以包含一个或多个单词）。
 * 例如:
 * 给定s=“nowcode”；
 * dict=["now", "code"].
 * 返回true，因为"nowcode"可以被分割成"now code".
 */
public class 拆分语句 {
    public static void main(String[] args) {
        String s = "nowcode";
        Set<String> dict = new HashSet <>();
        dict.add("now");
        dict.add("code");
        System.out.println(wordBreak(s, dict));
    }
    private static boolean wordBreak(String s, Set<String> dict) {
        //状态定义
        boolean[] canBreak = new boolean[s.length() + 1];
        //初始化
        canBreak[0] = true;
        //状态间的转移状态
        for (int i = 1; i <= s.length();i++) {
            //对于要求的字符串f(4)来说, 只要
            // f(1) && [2, 4] 找到 或者
            // f(2) && [3, 4] 找到 或者
            // f(3) && [4] 找到 f(4) 就可以找到

            // j < i && f(j) && [j + 1, i]
            for (int j = 0; j < i; j++) {
                if (canBreak[j] && dict.contains(s.substring(j, i))) { //第j+1个字符对应的下标是j
                    canBreak[i] = true;
                    break;
                }
            }
        }
        //返回结果
        return canBreak[s.length()];
    }
}
