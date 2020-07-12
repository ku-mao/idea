package edu.nowcoder;

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
