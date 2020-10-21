package edu.nowcoder;

public class 回文串分割2 {
    //判断是否回文串
    private static boolean isPal(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
    private static boolean[][] getHuiWen(String s) {
        int len = s.length();
        boolean[][] result = new boolean[len][len];
        //F(i, j) 区间i到j是否是回文串
        //F(i, j): s(i) == s(j) && F[i + 1][j - 1]
        //从最后一行开始更新, 只需要更新一半, i <= j
        for (int i = len - 1; i > 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    result[i][j] = true;
                } else if (i + 1 == j) {
                    result[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    result[i][j] = s.charAt(i) == s.charAt(j) && result[i+1][j - 1];
                }
            }
        }
        return result;
    }


    public static int minCut(String s) {
        int len = s.length();
        if(len == 0) {
            return 0;
        }
        boolean[][] result = getHuiWen(s);
        int[] minCut = new int[len + 1];
        // F(i)初始化
        // F(0）= -1，必要项，如果没有这一项，对于重叠字符串“aaaaa”会产生错误的结果
        for(int i = 0; i <= len; ++i){
            minCut[i] = i - 1;
        }
        for(int i = 2; i <= len; ++i){
            for(int j = 0; j < i; ++j){
                // F(i) = min{F(i), 1 + F(j)},  j<i && j+1到i是回文串
                // 从最长串判断，如果从第j+1到i为回文字符串
                // 则再加一次分割，从1到j，j+1到i的字符就全部分成了回文字符串
                if(result[j][i - 1]){
                    minCut[i] = Math.min(minCut[i], minCut[j] + 1);
                }
            }
        }
        return minCut[len];
    }

    public static void main(String[] args) {
        String str = "aab";
        System.out.println(minCut(str));
    }
}
