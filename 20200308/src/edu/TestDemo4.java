package edu;

import java.util.Scanner;

public class TestDemo4 {
    /**
     * 递归解决斐波那契数列
     */
    private static int fib(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 循环实现斐波那契数列
     * @param n
     * @return
     */
    private static int fib2(int n){
        int f1 = 1;
        int f2 = 1;

        int f3 = 1;
        for (int i = 3; i <= n; i++) {
           f3 = f1 + f2;
           f1 = f2;
           f2 = f3;
        }
        return f3;
    }

    /**
     * 汉诺塔
     */

    private static void move(char pos1,char pos3) {
        System.out.println(pos1 + "->" + pos3 + " ");
    }
    private static void hanoi(int n,char pos1,char pos2,char pos3) {
        if(n == 1) {
            move(pos1,pos3);
            return ;
        }
        hanoi(n - 1, pos1,pos3,pos2);//开始位置,中间位置,终止位置
        move(pos1,pos3);
        hanoi(n - 1, pos2, pos1,pos3);
    }

    /**
     * 123 打印1+2+3的值
     */
    private static int print2(int n) {
        if(n  < 10){
            return n;
        }
        return n % 10 + print2(n /10);
    }

    /**
     * 123打印 1 2 3
     * @return
     */
    private static void print(int n) {
        if(n  > 9){
            print(n /10);
        }
        System.out.println(n % 10);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("顺序打印数字的各位:");
        print(n);
        System.out.println("打印数字各位的和");
        System.out.println(print2(n));
        System.out.println("斐波那切数列的n项:");
        System.out.println(fib(4));
        System.out.println(fib2(4));
        System.out.println("汉诺塔:");
        hanoi(3,'A','B','C');
    }
}
