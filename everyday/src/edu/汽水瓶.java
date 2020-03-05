package edu;
import java.util.*;
public class 汽水瓶 {
        public static void main(String[] args){
            Scanner s = new Scanner(System.in);
            while(s.hasNext()){
                int n = s.nextInt();
                System.out.println(bottle(n));
            }
        }
        
        public  static int bottle(int n){
            if (n <= 1) return 0;
            if(n == 2) return 1;
            if(n == 3) return 1;
            int num = 0;
            num = n / 3;
            return num + bottle(n-3*num + num);

        }

}
