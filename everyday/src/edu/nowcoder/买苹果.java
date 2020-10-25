package edu.nowcoder;
import java.util.Scanner;

/**
 * 小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，
 * 只提供6个每袋和8个每袋的包装(包装不可拆分)。
 * 可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。
 * 如果不能购买恰好n个苹果，小易将不会购买。
 * 输出一个整数表示最少需要购买的袋数，如果不能买恰好n个苹果则输出-1
 */
public class 买苹果 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        if(num%2!=0){
            System.out.print("-1");
        }else if(num%8==0) {
            System.out.print(num/8);
        }
        else {
            System.out.print(num/8 + 1);
        }
    }
}
