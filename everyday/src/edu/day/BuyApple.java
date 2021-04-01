package edu.day;

import java.util.Scanner;

/**
 * 小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。
 * 可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。
 * 如果不能购买恰好n个苹果，小易将不会购买, 输出 -1。
 *
 * 思路： 8和6都是偶数， 所以当n为奇数时, 将不会购买
 * 所以你只能是偶数
 * 如果刚好是8的倍数, 直接输出除数
 * 余数为2, 4, 6
 * 余数为2 少买2袋8个, 买3袋6个
 * 余数为4, 少买1袋8个, 买2袋6个
 * 余数为6, 再买一袋6个
 * ,不管余数是几, 买的总袋数都是n/8 + 1
 */
public class BuyApple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n < 6 || n % 2 != 0 || n == 10) {
            System.out.println(-1);
            return;
        }
        if (n % 8 == 0) {
            System.out.println(n / 8);
        } else {
            System.out.println(n / 8 + 1);
        }
    }
}
