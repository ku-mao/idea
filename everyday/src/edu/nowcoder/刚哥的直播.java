package edu.nowcoder;

import java.util.Scanner;

public class 刚哥的直播 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            long tmp1 = 1;
            long tmp2 = 1;
            for (int i = 0; i < n; i++) {
                tmp1 = tmp1 * (m - i);
                tmp2 = tmp2 * (n - i);
            }
            System.out.println(tmp1 / tmp2);
        }
    }
}
