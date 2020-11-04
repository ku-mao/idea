package edu.nowcoder;


import java.util.ArrayList;
import java.util.Collections;

public class 重复字符串 {
    public  static String[] find(String[] s1, String[] s2) {
        ArrayList<String> list = new ArrayList <>();
        for (String str1 : s1) {
            for (String str2 : s2) {
                if (str1.equals(str2)) {
                    list.add(str1);
                }
            }
        }
        Collections.sort(list);
        String[] ret = new String[list.size()];
        int i = 0;
        for (String s : list) {
            ret[i] = s;
            i++;
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] s1 = {"sun", "star", "moon", "sky"};
        String[] s2 = {"moon", "noon", "mar", "star"};
        String[] ret = find(s1, s2);
        for (String s : ret) {
            System.out.print(s + " ");
        }
    }
}
