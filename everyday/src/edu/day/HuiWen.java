package edu.day;

import java.util.Scanner;

public class HuiWen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        String B = scanner.nextLine();
        int count = 0;
        for (int i = 0; i <= A.length(); i++) {
            StringBuilder s = new StringBuilder(A);
            s.insert(i, B);
            if (isTrue(s)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isTrue(StringBuilder s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
