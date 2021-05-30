package edu.day;

import java.util.Scanner;

public class DeleString {
    public static void removeDuplucate(String str){
        char[] chars=str.toCharArray();
        int len=chars.length;
        int flag = 0;
        for(int i = 0;i < len; i++){
            int shift = (chars[i] - 97) % 32;
            if ((flag & (1 << shift))== 0) {
                flag = flag ^ (1 << shift);
                System.out.print(chars[i]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        removeDuplucate(str);
    }
}
