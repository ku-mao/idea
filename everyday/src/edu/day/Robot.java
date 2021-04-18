package edu.day;

import java.util.Scanner;

public class Robot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] ch = str.toCharArray();
        int x = 0;
        int y = 0;
        int dir = 1;
        for (char c : ch) {
            switch (c) {
                case 'R' :
                    if (dir == 1) {
                        dir = 4;
                    } else {
                        dir = dir + 1;
                    }
                    break;
                case 'L' :
                    if (dir == 4) {
                        dir = 1;
                    } else {
                        dir++;
                    }
                    break;
                case 'G' :
                    if (dir == 1) {
                        y = y + 1;
                    } else if (dir == 2) {
                        x = x - 1;
                    } else if (dir == 3) {
                        y = y - 1;
                    } else {
                        x = x + 1;
                    }
                    break;
            }
        }
        System.out.println(x + "," + y);
    }
}
