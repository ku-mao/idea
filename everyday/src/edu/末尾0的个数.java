package edu;

import java.util.Scanner;

/**
 * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？
 * 比如: n = 10; n! = 3628800,所以答案为2
 * 因为需要求n阶乘后末尾0的个数
 * 而n的阶乘可以看做是小于等于n的数的质数因子的乘积的乘积，要想末尾是0，则是一个偶数和5的乘积
 * 所以只需要知道有几个5就可以知道有几个0
 */
public class 末尾0的个数 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        while(n/5!=0){
            n = n/5;
            count += n;
        }
        System.out.println(count);
    }
}
