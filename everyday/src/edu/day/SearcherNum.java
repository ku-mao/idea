package edu.day;

import java.util.Scanner;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class SearcherNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入二维数组的大小:");
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println("请输入一个二维数组");
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println("请输入要找的数字");
        int num = scanner.nextInt();
        System.out.println(find(arr, num));
    }
    private static boolean find(int[][] arr, int target) {
        int row = arr.length;
        int col = arr[0].length;
        int i = 0;
        int j = col - 1;
        while (i < row && j >= 0) {
            if (target > arr[i][j]) {
                i++;
            } else if (target < arr[i][j]) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}
