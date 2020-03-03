package edu;

import java.util.Scanner;

public class 回文串 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = 0;
        while (s.hasNext()){
            String s1 = s.nextLine();
            String s2 = s.nextLine();

            String total = s1 + s2;
            if (judge(total))  num++;
            total = s2 + s1;
            if (judge(total))  num++;

            for (int i = 1; i < s1.length() ; i++) {
                String left = s1.substring(0,i);
                String right = s1.substring(i);
                 total = left + s2 + right;
                if(judge(total)) num++;
            }
            System.out.println(num);
            return ;
        }
    }
    public static boolean judge(String s){
       char[] c = s.toCharArray();
       int left = 0;
       int right = c.length - 1;
       while(left <= right ){
           if(c[left]!= c[right]){
               return false;
           }
           left++;
           right--;
       }
    return  true;
    }
}
