package edu.nowcoder;

public class 编辑距离 {
    public static int minDistance (String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] minOpe = new int[m + 1][n + 1];
        //初始化 [i][0] = i [0][j] = j
        for (int i = 0; i <= m; i++) {
            minOpe[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            minOpe[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //插入, 删除操作
                minOpe[i][j] = Math.min(minOpe[i - 1][j], minOpe[i][j - 1]) + 1;
                //替换
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    //不需要替换
                    minOpe[i][j] = Math.min(minOpe[i][j], minOpe[i - 1][j - 1]);
                } else {
                    //需要替换
                    minOpe[i][j] = Math.min(minOpe[i][j], minOpe[i - 1][j - 1] + 1);
                }
            }
        }
        return minOpe[m][n];
    }

    public static void main(String[] args) {
        String str1 = "abd";
        String str2 = "nba";
        System.out.println(minDistance(str1, str2));
    }
}
