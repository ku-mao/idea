package edu.nowcoder;

import java.util.ArrayList;

/**
 * 给出一个三角形，计算从三角形顶部到底部的最小路径和，每一步都可以移动到下面一行相邻的数字，
 * 例如，给出的三角形如下：
 * [↵     [2],↵    [3,4],↵   [6,5,7],↵  [4,1,8,3]↵]
 * 最小的从顶部到底部的路径和是2 + 3 + 5 + 1 = 11。
 */
public class triangle {
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
}
