package edu.nowcoder;

import java.util.Scanner;
//不借助第三个数 去交换2个数的值

public class 交换两个数 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
         int num1 = s.nextInt();
         int num2 = s.nextInt();
        System.out.println("交换前两个数的值");
        System.out.println("num1="+ num1);
        System.out.println("num2="+ num2);

        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;
        System.out.println("交换后两个数的值");
        System.out.println("num1="+ num1);
        System.out.println("num2="+ num2);
    }
}
