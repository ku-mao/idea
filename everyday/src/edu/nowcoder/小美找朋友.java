package edu.nowcoder;

import java.util.Scanner;

public class 小美找朋友 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String nStr = scanner.next();
            String mStr = scanner.next();
            int n = Integer.parseInt(nStr);
            int m = Integer.parseInt(mStr);
            String str = scanner.next();
            String childStr = scanner.next();
            if (m > n) {
                System.out.println("No");
                return;
            }
            int count = 0;
            int k = 0; //记录上次找的位置
            int j = 0;
            for (int i = 0; i < m; i++) {
                for (j = k; j < n; j++) {
                    char child = childStr.charAt(i);
                    char c = str.charAt(j);
                    if (child == c) {
                        count = count + j + 1;
                        break;
                    }
                }
                if (j == n) {
                    System.out.println("No");
                    return;
                }
                k = j + 1;
            }
            System.out.println("Yes");
            System.out.println(count);
        }
    }
}
