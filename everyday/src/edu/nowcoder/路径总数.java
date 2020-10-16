package edu.nowcoder;

import java.util.Scanner;

/**
 * 一个机器人在m×n大小的地图的左上角（起点，下图中的标记“start"的位置）。
 * 机器人每次向下或向右移动。机器人要到达地图的右下角。（终点，下图中的标记“Finish"的位置）。
 * 可以有多少种不同的路径从起点走到终点？
 */
public class 路径总数 {
    public static int uniquePaths (int m, int n) {
        // write code here
        //定义状态
        int[][] path = new int[m][n];
        //初始化
        for (int i = 0; i < m; i++) {
            path[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            path[0][j] = 1;
        }
        //状态转移方程
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }
        return path[m - 1][n  - 1];
    }

    public static void main(String[] args) {
        System.out.println("请输入地图的长度: ");
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println("请输入地图的宽度: ");
        int n = scanner.nextInt();
        System.out.println(uniquePaths(m, n));
    }
}
