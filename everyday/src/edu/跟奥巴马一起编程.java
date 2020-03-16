package edu;

import java.util.Scanner;
/**
 输入描述:
   输入在一行中给出正方形边长N（3<=N<=20）和组成正方形边的某种字符C，间隔一个空格。
 输出描述:
   输出由给定字符C画出的正方形。
   但是注意到行间距比列间距大，
  所以为了让结果看上去更像正方形，我们输出的行数实际上是列数的50%（四舍五入取整）
*/
public class 跟奥巴马一起编程 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        char c = s.next().charAt(0);
        int row = (N+1)/2;
        for(int i = 0; i < row ; i++){
            for (int j = 0; j < N ; j++) {
                if(i == 0 || i == (row-1) || j==0||j==N-1){
                    System.out.print(c);
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
