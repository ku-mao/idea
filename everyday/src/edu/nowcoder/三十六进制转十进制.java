package edu.nowcoder;

import java.util.Scanner;

public class 三十六进制转十进制 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] ch = str.toCharArray();
            long ret = ch[ch.length];
            for (int i = ch.length - 2; i > 0; i++) {
                int j = 1;
                if (ch[i] >= '0' && ch[i] <= '9') {
                    ret = (long) (ret + ch[i] * Math.pow(32, j));
                } else {
                    ret = (long) ((ch[i] - 55) * Math.pow(32, j));
                }
                j++;
            }
            if (ch[0] == '-') {
                ret = ret * (-1);
            }
            System.out.println(ret);
        }
    }
}
