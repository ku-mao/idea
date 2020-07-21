package edu.nowcoder;



import java.util.Scanner;

public class 调整数组奇数位于偶数前 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组的长度:");
        int n = sc.nextInt();
        System.out.println("请输入一个数组:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        print(arr);
        method1(arr);
        print(arr);
    }

    /**
     * 奇数位于偶数前,相对位置改变
     * @param arr
     */
    private  static void method1(int[] arr) {

    }

    /**
     * 相对不变  奇数往前插
     * @param arr
     */
    private  static void method2(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & 1) == 1) { //当前数是奇数
                //把奇数前的偶数都后移(借助插入排序的思想)
                int tmp = arr[i];
                //从那开始移, 移多少 从当前位置的前一个偶数开始移, 给当前奇数移出一个位置
                int j = i;
                while (j > k) { // k 表示当前奇数要放的位置
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[k++] = tmp;
            }
        }
    }

    /**
     * 相对位置不变, 偶数向后插
     * @param arr
     */
    private  static void method3(int[] arr) {

    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
