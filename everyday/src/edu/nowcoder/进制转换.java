package edu.nowcoder;

import java.util.Scanner;

public class 进制转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String s_16 = s.substring(2);
            int res = Integer.parseInt(s_16, 16);// s 是要转换的字符串, radix 是转换的基数
            System.out.println(res);
        }
    }
}
