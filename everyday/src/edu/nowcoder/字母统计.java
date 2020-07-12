package edu.nowcoder;

import java.util.*;

public class 字母统计 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        while(sc.hasNext()) {
            String str = sc.nextLine();
            char[] c = str.toCharArray();
            for (int i = 0; i < c.length; i++) {
                if (c[i] >= 'A' && c[i] <= 'Z') {
                    Integer count = map.get(c[i]);
                    if (count == null) {
                        map.put(c[i], 1);
                    } else {
                        map.put(c[i], count + 1);
                    }
                }
            }
            char cc = 'A';
            Integer res = null;
            for (; cc <= 'Z'; cc++) {
                res = map.get(cc);
                if (res == null) {
                    res = 0;
                }
                System.out.println(cc + ":" + res);
            }
        }
    }
}
