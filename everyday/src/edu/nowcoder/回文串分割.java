package edu.nowcoder;

/**
 * 给出一个字符串s，分割s使得分割出的每一个子串都是回文串
 * 计算将字符串s分割成回文分割结果的最小切割数
 * 例如:给定字符串s="aab",
 * 返回1，因为回文分割结果["aa","b"]是切割一次生成的。
 */
public class 回文串分割 {
    //判断是否回文串
    public static boolean isPal(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }
    public static int minCut(String s) {
        int len = s.length();
        if(len == 0) {
            return 0;
        }
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
                if(isPal(s, j, i - 1)){
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
