package edu.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 神奇的口袋 {
    private static int[] dp = new int[41];
    private static int[] thing = new int[21];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = bf.readLine()) != null) {
            int n = Integer.parseInt(str);
            for(int i = 1; i <= n; i++) {
                thing[i] = Integer.parseInt(bf.readLine());
            }
            for(int i = 1; i <= n; i++){ //遍历所有物品
                for(int j = 40; j >= thing[i]; j--) {
                    dp[j] += dp[j - thing[i]];
                }
                dp[thing[i]]++;
            }
            System.out.print(dp[40]);
        }
    }
}
