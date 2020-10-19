package edu.nowcoder;

public class 背包问题 {
    public static void main(String[] args) {
        int[] A = {2, 10, 1};
        int[] V = {3, 1, 20};
        int m = 11;
        System.out.println(backPackII(m, A, V));
        System.out.println(backPackI(m, A, V));
    }
    private static int backPackII(int m, int[] A, int[] V) {
        int n = A.length;
        int[][] maxValue = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] <= j) {
                    //如果背包的容量足够装第i个物品
                    //此时选择装 maxValue[i - 1][j - A[i - 1]] + V[i - 1]
                    //不装进去  maxValue[i - 1][j]
                    maxValue[i][j] = Math.max(maxValue[i - 1][j],
                            maxValue[i - 1][j - A[i - 1]] + V[i - 1]);
                } else { //如果背包的容量不够装第i个物品
                    maxValue[i][j] = maxValue[i - 1][j];
                }
            }
        }
        return maxValue[n][m];
    }

    private static int backPackI(int m, int[] A, int[] V) {
        int[] maxValue = new int[m + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = m; j > 0; j--) { //因为是需要借助i- 1的值 所以要从后更新
                if (A[i - 1] <= j) {
                    //如果背包的容量足够装第i个物品
                    //此时选择装 maxValue[j - A[i - 1]] + V[i - 1]
                    //不装进去  maxValue[j]
                    maxValue[j] = Math.max(maxValue[j],
                            maxValue[j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        return maxValue[m];
    }
}
