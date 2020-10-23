package edu.nowcoder;

import java.util.Scanner;

public class 找零 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int num = 1024 - s.nextInt();
            int[] dp = new int[num + 1];
            // 初始化dp数组，因为要找最小值，这里给每个位置赋最大值，即都是由1元组成的，即num/1
            for (int i = 0; i < dp.length; i++) {
                dp[i] = i;
            }
            // 定义钱的集合，方便遍历
            int[] money = {1, 4, 16, 64};

            // 状态转移方程 从 1 ~ num
            for (int i = 1; i <= num ; i++) {
                // dp[num]的最小值就是能组成它的前一步 + 1 和 本身进行比较
                for (int j = 0; j < money.length; j++) {
                    if (i - money[j] >= 0){
                        dp[i] = Math.min(dp[i - money[j]] + 1, dp[i]);
                    }
                }
            }
            System.out.println(dp[num]);
            if(s.nextInt()== 0) {
                break;
            }
        }
    }
}
