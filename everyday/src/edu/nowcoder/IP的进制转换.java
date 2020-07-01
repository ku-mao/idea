package edu.nowcoder;

import java.util.Scanner;

public class IP的进制转换 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String[] res = s1.split("\\.");
        System.out.println((Long.parseLong(res[0]) << 24) | (Long.parseLong(res[1]) << 16) |
                (Long.parseLong(res[2]) << 8) | Long.parseLong(res[3]));
        long num = Long.parseLong(s2);
        System.out.println(((num >> 24) & 255) + "." + ((num >> 16) & 255) + "." +
                ((num >> 8) & 255) + "." + (num & 255));

    }
}
