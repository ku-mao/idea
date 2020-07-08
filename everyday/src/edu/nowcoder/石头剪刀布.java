package edu.nowcoder;

import java.util.Scanner;

/**
 * 输入第1行给出正整数N（<=105），即双方交锋的次数。
 * 随后N行，每行给出一次交锋的信息，即甲、乙双方同时给出的的手势。
 * C代表“锤子”、J代表“剪刀”、B代表“布”
 * 第1个字母代表甲方，第2个代表乙方，中间有1个空格。
 
 * 输出第1、2行分别给出甲、乙的胜、平、负次数，数字间以1个空格分隔。
 * 第3行给出两个字母，分别代表甲、乙获胜次数最多的手势，中间有1个空格。
 * 如果解不唯一，则输出按字母序最小的解。
 */
public class 石头剪刀布 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sucess = 0;
        int fair = 0;
        int fail = 0;
        int c_a = 0;
        int j_a = 0;
        int b_a = 0;
        int c_b = 0;
        int j_b = 0;
        int b_b= 0;
        StringBuffer ab = new StringBuffer();
        StringBuffer bb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            ab.append(sc.next());
            bb.append(sc.next());
        }
        char[] a = ab.toString().toCharArray();
        char[] b = bb.toString().toCharArray();
        for (int i = 0; i < n; i++) {
            if (a[i] == 'C') {
                if (b[i] == 'C') {
                    fair++;
                } else if (b[i] == 'J'){
                    j_a++;
                    sucess++;
                } else {
                    b_b++;
                    fail++;
                }
            } else if (a[i] == 'J') {
                if (b[i] == 'C') {
                    c_b++;
                    fail++;
                } else if (b[i] == 'J'){
                    fair++;
                } else {
                    b_a++;
                    sucess++;
                }
            } else if (a[i] == 'B') {
                if (b[i] == 'C') {
                    c_a++;
                    sucess++;
                } else if (b[i] == 'J'){
                    j_b++;
                    fail++;
                } else {
                    fair++;
                }
            }
        }
        System.out.println(sucess + " " + fair + " " + fail);
        System.out.println(fail + " " + fair + " " + sucess);
        max(b_a, c_a, j_a);
        System.out.print(" ");
        max(b_b, c_b, j_b);
        System.out.println();

    }
    private static void max(int b, int c, int j) {
        if (b >= c && b >= j) {
            System.out.print('B');
        } else if (c > b && c >= j) {
            System.out.print('C');
        } else {
            System.out.println('J');
        }
    }
}
