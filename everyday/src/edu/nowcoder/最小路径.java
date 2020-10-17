package edu.nowcoder;

import java.util.Scanner;

/**
 * 给定一个由非负整数填充的m x n的二维数组，现在要从二维数组的左上角走到右下角，
 * 请找出路径上的所有数字之和最小的路径。
 * 注意：你每次只能向下或向右移动。
 */
public class 最小路径 {
    public static void main(String[] args) {
        System.out.println("请输入二维数组的长度: ");
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println("请输入二维数组中一维数组的长度: ");
        int n = scanner.nextInt();
        System.out.println("请输入二维数组: ");
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println(minPathSum(arr));
    }
    private static int minPathSum (int[][] grid) {
        int m = grid.length;//行
        int n = grid[0].length;//列
        for (int i = 1; i < n; i++) { //第一行
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {//第一列
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[m - 1][n - 1];
    }
}
