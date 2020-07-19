package edu.nowcoder;

import java.util.Scanner;

public class 日期天数转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] days = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ) {
            days[1] = 29;
        }
        System.out.println(days[1]);
        for (int i = 0; i < month - 1; i++) {
            day += days[i];
        }
        System.out.println(day);
    }
}
