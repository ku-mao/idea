package edu.day;

import java.util.Scanner;

public class DelSameStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (!s2.contains(c + "")){
                System.out.print(c);
            }
        }
    }
}
