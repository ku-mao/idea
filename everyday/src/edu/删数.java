package edu;

import java.util.Scanner;

public class 删数 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if(n>1000)
            n = 999;
            int res = lastDel(n);
            System.out.print(res);
    }
    public static int lastDel(int n){
        if(n==1){
            return 0;
        }else {
           return (lastDel(n-1)+3)%n;
        }
    }
}
