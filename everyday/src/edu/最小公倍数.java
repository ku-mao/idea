package edu;

import java.util.Scanner;
//最小公倍数等于两个数的乘积/最大公因数

public class 最小公倍数 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int A = s.nextInt();
        int B = s.nextInt();
        System.out.print((A*B)/maxFactor(A,B));

    }
    //最大公因数
    public static int maxFactor(int a ,int b){
        if(b==0) return a;
        return maxFactor(b,a%b);
    }
}
