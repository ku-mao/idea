package edu.nowcoder;

public class 不同的子序列 {
    public static int numDistinct (String S, String T) {
        //F[i, j] 表示T的前j个字符串中是S的前i个字符串的个数
        int m = S.length();
        int n = T.length();
        int[][] count = new int[m + 1][n + 1];
        count[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            count[i][0] = 1;
            for (int j = 1; j <= n; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    //使用S.charAt(i - 1) 和 不使用S.charAt(i - 1)
                    count[i][j] = count[i - 1][j - 1] + count[i - 1][j];
                } else {
                    count[i][j] = count[i - 1][j];
                }
            }
        }
        return count[m][n];
    }

    //因为每次只需要二维数组中的前一行的当前列和前一列, 所以可以简化为一维的数组
    public static int numDistinct2 (String S, String T) {
        //F[j] 表示T的前j个字符串中是S的前i个字符串的个数
        int m = S.length();
        int n = T.length();
        int[] count = new int[n + 1];
        count[0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = n; j > 0; j--) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    //使用S.charAt(i - 1) 和 不使用S.charAt(i - 1)
                    count[j] = count[j - 1] + count[j];
                }
            }
        }
        return count[n];
    }

    public static void main(String[] args) {
        String S = "r";
        String T = "a";
        System.out.println(numDistinct(S, T));
        System.out.println(numDistinct2(S, T));
    }
}
