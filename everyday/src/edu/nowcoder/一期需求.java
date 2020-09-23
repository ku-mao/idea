package edu.nowcoder;

import java.util.Scanner;

public class 一期需求 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            String[] s1 = str1.split(" ");
            String[] s2 = str2.split(" ");
            int count = 0;
            int max = 0;
            for (int i = 0; i < s1.length; i++) {
                for (int j = 0; j < s2.length; j++) {
                    if (s1[i].equals(s2[j])) {
                        count = find(s1, s2, i, j);
                        System.out.println(count);
                        if (count > max) {
                            max = count;
                        }
                    }
                    count = 0;
                }
            }
            System.out.println(max);
        }
    }
    private static int find(String[] s1, String[] s2, int start1, int start2) {
        int count = 0;
        for (int i = start2; i < s2.length; i++){
            for (int j = start1; j < s1.length; j++) {
                if (s2[i].equals(s1[j])) {
                    count++;
                    start1 = j + 1;
                    break;
                }
            }
        }
        return count;
    }
}
