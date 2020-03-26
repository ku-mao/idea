package edu;

import java.util.Scanner;

public class 游戏标记 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        if(a<0||a>1024||b<0||b>1024){
            System.out.println(-1);
        }else{
            if(b==a) System.out.println(1);
            if(b!=a) System.out.println(0);
        }
    }
}
