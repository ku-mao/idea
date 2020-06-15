package edu.nowcoder;

import java.util.Scanner;

public class 尼科彻斯定理 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            System.out.println(GetSequeOddNum(m));
        }
    }

    private static String GetSequeOddNum(int m) {
        int num = (m * (m - 1)) + 1;
        StringBuffer s = new StringBuffer();
        s.append(num);
        while (m > 1) {
            num += 2;
            s.append("+");
            s.append(num);
            m--;
        }
        return s.toString();
    }
}
