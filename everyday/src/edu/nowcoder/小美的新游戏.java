package edu.nowcoder;

import java.util.Scanner;

public class 小美的新游戏 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            char[][] map = new char[n][m];
            int score = 0;
            for (int i = 0; i < n; i++) {
                String str = scanner.next();
                map[i] = str.toCharArray();
            }
            String way = scanner.next();
            char[] ch = way.toCharArray();
            int i = 0;
            int j = 0;
            int k = 0;
            while (k < ch.length) {
                if (map[i][j] == 'S') {
                    if (ch[k] == 'W' && i > 0) {
                        i--;
                    }
                    if (ch[k] == 'A' && j > 0) {
                        j--;
                    }
                    if (ch[k] == 'S' && i < n - 1) {
                        i++;
                    }
                    if (ch[k] == 'D' && j < m - 1) {
                        j++;
                    }

                }
            }
        }
    }
}
