package edu.nowcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数；
 * 有m批客人，每批客人有两个参数:b人数，c预计消费金额。
 * 在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大
 *
 * 输入描述: 输入包括m+2行。
 * 第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000)
 * 第二行为n个参数a,即每个桌子可容纳的最大人数,以空格分隔,范围均在32位int范围内。
 * 接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分隔,范围均在32位int范围内。
 *
 * 输出描述:
 * 输出一个整数,表示最大的总预计消费金额
 */
public class 餐馆 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] a = new int[n];
            long money = 0L;
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            Arrays.sort(a);
            int[][] num = new int[m][2];
            for (int i = 0; i < m; i++) {
                num[i][0] = scanner.nextInt();
                num[i][1] = scanner.nextInt();
            }
            Arrays.sort(num, new Comparator<int[]>(){
                public int compare(int[] a, int[] b) {
                    return b[1] - a[1];
                }
            });
            int[] isUse = new int[n];//桌子是否使用, 使用为1
            for (int i = 0; i < m; i++) {
                if (num[i][0] > a[n - 1]) {
                    continue;
                }
                int person = num[i][0];
                int price = num[i][1];
                int index = find(person, a);
                while (index < n && isUse[index] == 1) {//找没用过的桌子
                    index++;
                }
                if (index < n) {
                    money += price;
                    isUse[index] = 1;
                }
            }
            System.out.println(money);
        }
    }

    private static int find(int num, int[] a) {
        int left = 0;
        int right = a.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if(num <= a[mid]){
                right = mid - 1; //这个要小于等于才能找到最左边的，
                //例如找到了num==a[mid],
                //继续二分，继续找左边的，直到找到最左边坐标的
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
