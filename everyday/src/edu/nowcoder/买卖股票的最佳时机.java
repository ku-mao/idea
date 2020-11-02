package edu.nowcoder;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出,
 * 这笔交易所能获得利润 = 5-1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出,
 * 这笔交易所能获得利润 = 6-3 = 3 。
 */
public class 买卖股票的最佳时机 {
    public static void main(String[] args) {
        int[] price = new int[] {7, 1, 5, 3, 6, 4};//股票的价格数组
        System.out.println(maxProfit(price));
    }
    private static int maxProfit(int[] prices) {
        /**
         *连续上涨:第一天买最后一天卖收益最大,等价于每天都买卖
         *连续下降: 不买卖收益最大，即不会亏钱。
         *遍历整个价格列表，在所有上涨日都买卖（赚到所有利润)
         *所有下降交易日都不买卖（永不亏钱）
         */
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
