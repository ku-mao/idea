package edu.nowcoder;

import java.util.Scanner;

/**
 * 请编写一个函数，使用递归的方法生成N位的格雷码。
 *
 * 给定一个整数n，请返回n位的格雷码，顺序为从0开始
 *
 * 1
 * 返回：["0","1"]
 */
public class 生成格雷码 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = getGray(n);
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i] + " ");
        }

    }
    private  static String[] getGray(int n) {
        String[] res = null ;
        if (n == 1) {
            res = new String[] {"0", "1"};
            return res;
        } else {
            String[] temp = getGray(n - 1);
            res = new String[temp.length * 2];
            for (int i = 0; i < temp.length; i++) {
                res[i] =  "0" + temp[i];
                res[res.length - 1 - i] = "1" + temp[i];
            }
        }
        return res;
    }
}
