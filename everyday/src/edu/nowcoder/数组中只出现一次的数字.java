package edu.nowcoder;

import java.util.Scanner;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * //num1,num2分别为长度为1的数组。传出参数
 * //将num1[0],num2[0]设置为返回结果
 */
public class 数组中只出现一次的数字 {
    //我们可以采取先整体异或，异或结果一定不为0，而其中为1的比特位，
    // 不同的两个数据该位置上的数据一定不同，所以我们可以用该比特位进行分组
   //分组的结果一定是，相同数据被分到了同一组，不同数据一定被分到了不同的组

    private static void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || num1 == null || num2 == null) {
            return;
        }
        num2[0] = 0;
        num1[0] = 0;
        int result = array[0];//先找到两个的异或结果
        for (int i = 1; i < array.length; i++) {
            result ^= array[i];
        }
        if (result == 0) {
            return;
        }
        int flag = 1;// 找到异或结果1, 从低向高位找
        int size = Integer.SIZE;
        while (size > 0) {
            if ((result & flag) == 0) {
                flag = flag << 1;
            } else {
                break;
            }
            size--;
        }
        //进行分组
        for (int i = 0; i < array.length; i++) {
            if ((flag & array[i]) == 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组的长度:");
        int n = scanner.nextInt();
        System.out.println("这是一个整型数组里除了两个数字之外，其他的数字都出现了两次");
        System.out.println("请输入数组元素: ");
        int[] arr = new int[n];
        int i = 0;
        while (n > 0) {
            arr[i] = scanner.nextInt();
            i++;
            n--;
        }
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        findNumsAppearOnce(arr, num1, num2);
        System.out.println(num1[0] + " " + num2[0]);
    }
}
