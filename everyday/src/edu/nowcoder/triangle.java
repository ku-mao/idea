package edu.nowcoder;

import java.util.ArrayList;

/**
 * 给出一个三角形，计算从三角形顶部到底部的最小路径和，每一步都可以移动到下面一行相邻的数字，
 * 例如，给出的三角形如下：
 * [↵     [2],↵    [3,4],↵   [6,5,7],↵  [4,1,8,3]↵]
 * 最小的从顶部到底部的路径和是2 + 3 + 5 + 1 = 11。
 */
public class triangle {
    /**
     * 自顶向下计算
     * 状态:f(i)(j) 表示的是从顶部到(i, j)的最小路径和
     * 状态转移方程: f(i)(j) = min(f(i - 1), j), f(i - 1, j - 1) + array[i][j]
     * 在三角形的边的点, 只有一条路径可以到达, 就是j == 0 和 j == i 的时候
     * 初始值, f(0)(0) = array[0][0]
     * 返回结果是, 最后一行的最小值
     * @param triangle
     * @return
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle.isEmpty()) {
            return 0;
        }
        int row = triangle.size();
        for (int i = 1; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                int cur = triangle.get(i).get(j);
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i - 1).get(j) + cur);
                } else if (j == i) {
                    triangle.get(i).set(j, triangle.get(i - 1).get(j - 1) + cur);
                } else {
                    triangle.get(i).set(j, Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)) + cur);
                }
            }
        }
        int min = triangle.get(row - 1).get(0);
        for (int i = 1; i < row; i++) {
            min = min > triangle.get(row - 1).get(i) ? triangle.get(row - 1).get(i) : min;
        }
        return min;
    }

    /**
     * 自底向上计算
     * 状态: f(i)(j) 到达最后一行的最小路径和
     * 状态转移方程: f(i)(j) = min(f(i + 1, j), f(i + 1, j + 1)) + array[i][j]; 每个点都会有两条路径到达
     * 初始值: f(row - 1)(j) = array[row - 1][j]
     * 返回值: f(0)(0)
     */
    public int minimumTotal_2(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle.isEmpty()) {
            return 0;
        }
        int row = triangle.size();
        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int cur = triangle.get(i).get(j);
                triangle.get(i).set(j, Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + cur);
            }
        }
        return triangle.get(0).get(0);
    }
}
