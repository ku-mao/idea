package edu.day;

/**
 * 给定一个double类型的数组arr，其中的元素可正可负可0，
 * 返回子数组累乘的最大乘积
 */
public class MaxProduct {
    public static void main(String[] args) {
        double[] arr = {-2.5, 4, 0, 3, 0.5, 8, -1};
        System.out.println(maxProduct(arr));
    }
    public static double maxProduct(double[] arr) {
        //如果arr[i] 为负数, 则最大变最小, 或最小变最大
        double min = arr[0];
        double max = arr[0];
        double res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            double max1 = max;
            max = Math.max(Math.max(arr[i], arr[i] * max), arr[i] * min);
            min = Math.min(Math.min(arr[i], arr[i] * min), arr[i] * max1);
            res = Math.max(max, res);
        }
        return res;
    }
}
