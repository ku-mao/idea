package edu.nowcoder;

import java.util.Scanner;

public class 不要二 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] arr = new int[row][col];//二维网格
        int count = 0; //可放的蛋糕的数目
        //把可以放蛋糕的地方的值改为1
        //找规律发现每四行是一个周期
        for (int i = 0; i < row ; i++) {
            if ((i % 4 == 0) || (i % 4 == 1)) {
                for (int j = 0; j < col; j++) {
                    if ((j % 4 == 0) || (j % 4 == 1)) {
                        arr[i][j] = 1;
                    }
                }
            } else {
                for (int j = 0; j < col; j++) {
                   if ((j % 4 == 2) || (j % 4 == 3)) {
                       arr[i][j] = 1;
                   }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
