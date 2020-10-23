package edu.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 有一个神奇的口袋，总的容积是40，用这个口袋可以变出一些物品，这些物品的总体积必须是40。
 * John现在有n个想要得到的物品，每个物品的体积分别是a1，a2……an。John可以从这些物品中选择一些，
 * 如果选出的物体的总体积是40，那么利用这个神奇的口袋，John就可以得到这些物品。
 * 现在的问题是，John有多少种不同的选择物品的方式。
 * 输入描述:
 * 输入的第一行是正整数n (1 <= n <= 20)，表示不同的物品的数目。接下来的n行，每行有一个1到40之间的正整数，分别给出a1，a2……an的值。
 * 输出描述:
 * 输出不同的选择物品的方式的数目。
 * 示例1
 * 输入
 * 3
 * 20
 * 20
 * 20
 * 输出
 * 3
 */
public class 神奇的口袋 {
//    private static int[] dp = new int[41];
//    private static int[] thing = new int[21];
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String str;
//        while((str = bf.readLine()) != null) {
//            int n = Integer.parseInt(str);
//            for(int i = 1; i <= n; i++) {
//                thing[i] = Integer.parseInt(bf.readLine());
//            }
//            for(int i = 1; i <= n; i++){ //遍历所有物品
//                for(int j = 40; j >= thing[i]; j--) {
//                    dp[j] += dp[j - thing[i]];
//                }
//                dp[thing[i]]++;
//            }
//            System.out.print(dp[40]);
//        }
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            int[][] dp = new int[n + 1][41];
            //dp[i][j] 表示第i件物品, 放在体积为j的口袋中的方式个数
            //体积为0时, 任何东西都可以选择不放, 只有一种方式
            //没有物品放时, 方式就为0
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= 40; j++) {
                    dp[i - 1][0] = 1;
                    if (arr[i - 1] <= j) {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            System.out.println(dp[n][40]);
        }
    }
}
