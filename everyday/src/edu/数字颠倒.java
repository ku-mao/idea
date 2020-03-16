package edu;

import java.util.Scanner;
/**输入一个整数，将这个整数以字符串的形式逆序输出
 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 */
public class 数字颠倒 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        char[] c = str.toCharArray();
        int len = c.length;
        for(int i = 0; i < len/2; i++){
            char temp = c[i];
            c[i] = c[len-1-i];
            c[len-1-i] = temp;
        }
        for(char i : c){
            System.out.print(i);
        }


    }
}
