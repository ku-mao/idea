package edu.day;

import java.util.Scanner;

public class MaxStr {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            int end = 0;
            int max = 0;
            int i = 0;
            int count = 0;
            while (i < str.length()) {
                while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    i++;
                    count++;
                }
                if (max < count) {
                    max = count;
                    end = i;
                }
                count = 0;
                i++;
            }
            System.out.println(str.substring(end - max,end));
        }
    }
}
