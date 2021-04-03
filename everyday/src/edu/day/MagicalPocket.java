package edu.day;

import java.util.Scanner;


/**
 * 有一个神奇的口袋，总的容积是40，用这个口袋可以变出一些物品，这些物品的总体积必须是40。
 * John现在有n个想要得到的物品，每个物品的体积分别是a1，a2……an。John可以从这些物品中选择一些，
 *
 * 如果选出的物体的总体积是40，那么利用这个神奇的口袋，
 *
 * John就可以得到这些物品。
 * 现在的问题是，John有多少种不同的选择物品的方式。
 */
public class MagicalPocket {
    private static int count;
    private static int[] goods;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        goods = new int[n + 1];
        int i = 1;
        while (i < n + 1) {
            goods[i++] = scanner.nextInt();
        }
        put(40, n);
        System.out.println(count);
    }
    private static void put(int capitity, int n) {
        if (capitity == 0) { //已经放完了 如果选出的物体的总体积是40，那么利用这个神奇的口袋
            count++;
            return;
        }
        if(capitity < 0 || (capitity > 0 && n < 0)) { //放不下/ 没放满
            return;
        }
        put(capitity - goods[n], n - 1);//放第n个物品
        put(capitity, n - 1);//不放第n个物品
    }
}
