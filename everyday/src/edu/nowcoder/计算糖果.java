package edu.nowcoder;
import  java.util.Scanner;
public class 计算糖果 {
        public static void main(String[] args){
            Scanner s = new Scanner(System.in);
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            int d = s.nextInt();
            if((a+c)%2 == 0 && (a+c)>=0 && (b+d)%2 == 0 && (b+d)>=0){
                int A = (a+c)/2;
                int B = (b+d)/2;
                if((d - B) >= 0) {
                    int C = d - B;
                    System.out.print(A + " " + B + " " + C);
                    return;
                }
            }
            System.out.println("No");

        }
}

