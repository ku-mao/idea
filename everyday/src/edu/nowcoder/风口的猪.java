package edu.nowcoder;

/**
 * 已知一支股票连续n天的价格走势，以长度为n的整数数组表示，
 * 数组中第i个元素（prices[i]）代表该股票第i天的股价。
 * 假设你一开始没有股票，但有至多两次买入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。
 * 若两次交易机会都放弃，收益为0。
 * 设计算法，计算你能获得的最大收益。 输入数值范围：2<=n<=100,0<=prices[i]<=100
 */
public class 风口的猪 {
    public static void main(String[] args) {
        int [] prices = new int[] {3, 8, 5, 1, 7, 8};
        System.out.println(calculateMax(prices));
    }
    private static int calculateMax(int[] prices) {
        int firstBuy = Integer.MIN_VALUE;
        int secondBuy = Integer.MIN_VALUE;
        int firstShell = 0;
        int secondShell = 0;
        for (int i = 0; i < prices.length; i++) {
            firstBuy = Math.max(firstBuy, -prices[i]);
            firstShell = Math.max(firstShell, firstBuy + prices[i]);
            secondBuy = Math.max(secondBuy, firstShell - prices[i]);
            secondShell = Math.max(secondShell, secondBuy + prices[i]);
        }
        return secondShell;
    }
}
