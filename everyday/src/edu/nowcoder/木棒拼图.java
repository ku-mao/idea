package edu.nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 最长的 < 除过最长的其余长的的和 就可以组成简单多边形
 */
public class 木棒拼图 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList <>();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            while (n-- > 0) {
                int type = sc.nextInt();
                int L = sc.nextInt();
                if (type == 1) {
                    list.add(L);
                } else if (list.contains(L)) {
                    list.remove((Object) L);
                }

                Collections.sort(list);
                int maxLen = list.get(list.size() - 1);
                int sumLen = 0;
                for (int i = 0; i < list.size() - 1; i++) {
                    sumLen += list.get(i);
                }
                if (maxLen < sumLen) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}
