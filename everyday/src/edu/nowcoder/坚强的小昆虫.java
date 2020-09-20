package edu.nowcoder;

import java.util.Scanner;

public class 坚强的小昆虫 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int t = scanner.nextInt();
            while (t > 0) {
                int n = scanner.nextInt();
                int m = scanner.nextInt();
                char[][] map = new char[n][m];
                for (int i = n; i < n; i++) {
                    map[i] = scanner.next().toCharArray();
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (map[i][j] == '@') {
                            System.out.println(find(i, j, map));
                        }
                    }
                }
                t--;
            }
        }
    }
    public static int find(int i, int j, char[][] map) {
        int n = map.length;
        int m = map[0].length;
        while (i < n && j < m && j > 0 && i > 0) {
            if ((i + 1) < n && map[i + 1][j] == '#' &&
                    (i - 1) > 0 && map[i - 1][j] == '#' &&
                    (j + 1) < m && map[i][j + 1] == '#' &&
                    (j - 1) > 0 && map[i][j - 1] == '#') {
                return -1;
            }
        }
        return 0;
    }
}
