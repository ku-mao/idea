package edu;
import java.util.*;
public class 汽水瓶 {
    public static int bottle(int n) {
        int total = 0;//饮料总数，当大于两个空瓶的时候才可以换饮料
        while(n > 2) {
            //n/3-->能够换来的饮料
            total = total+n/3; //新的空瓶子个数--n%3可能会不能整除
            n = n/3 + n%3;
         }
         //如果n==2，说明有两个空瓶可以喝商家借一瓶饮料
         if(n == 2) {
             total = total + 1;
         }
         return total;
    }
      public static void main(String[] args){
                 Scanner sc=new Scanner(System.in);
                 int n;
                 while(sc.hasNext()) {
                    n=sc.nextInt();
                    System.out.println(bottle(n));
                    if(n==0){
                        return;
                    }
            }
    }
}
