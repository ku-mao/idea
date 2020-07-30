package edu.nowcoder;

import java.util.Scanner;

/**
 * 现在他需要判别A盒是否包含了B盒中所有的种类，并且每种球的数量不少于B盒中的数量
 * 输入有多组数据。
 * 每组数据包含两个字符串A、B，代表A盒与B盒中的乒乓球，每个乒乓球用一个大写字母表示，即相同类型的乒乓球为相同的大写字母
 * 每一组输入对应一行输出：如果B盒中所有球的类型在A中都有，并且每种球的数量都不大于A，则输出“Yes”；否则输出“No”。
 */
public class 乒乓球筐 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String aStr = scan.next();
            String bStr = scan.next();
            int[] arr = new int[26];
            for (int i = 0; i < bStr.length(); i++) {
                int index = bStr.charAt(i) - 'A';
                arr[index]++;
            }
            for (int i = 0; i < aStr.length(); i++) {
                int index = aStr.charAt(i) - 'A';
                if (arr[index] > 0) {
                    arr[index]--;
                }
            }
            int i = 0;
            for (; i < arr.length; i++) {
                if (arr[i] > 0) {
                    System.out.println("No");
                    break;
                }
            }
            if (i == arr.length) {
                System.out.println("Yes");
            }
        }
    }
}
