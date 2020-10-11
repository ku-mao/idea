package edu.nowcoder;

import java.util.*;


public class Solution {
    /**
     * 反转字符串
     * @param str string字符串 
     * @return string字符串
     */
    public String solve (String str) {
        // write code here
        StringBuffer ret = new StringBuffer();
        //for (int i = str.length() - 1; i >= 0 ; i--) {
            //ret.append(str.charAt(i));
        //}
        //return ret.toString();
        //String ret = "";
        for (int i = 0; i < str.length(); i++) {
            ret.insert(0,str.charAt(i));
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "abcd";
        String s = solution.solve(str);
        System.out.println(s);
    }
}