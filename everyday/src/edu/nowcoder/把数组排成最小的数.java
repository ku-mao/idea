package edu.nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
 */
public class 把数组排成最小的数 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.println(PrintMinNumber(arr));
    }
    private static String PrintMinNumber(int [] numbers) {
        if (numbers.length == 0) {
            return new String();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                String aStr = a + "" + b;
                String bStr = b + "" + a;
                return aStr.compareTo(bStr);
            }
        });
        StringBuilder result =new StringBuilder();
        for (int num : list) {
            result.append(num);
        }
        return result.toString();
    }
}
