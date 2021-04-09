package edu.day;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        reOrderArray(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    private static int[] reOrderArray (int[] array) {
        int k = 0;//记录现在要放的奇数的下标
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                int tmp = array[i];
                int j = i;
                while (j > k) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[k++] = tmp;
            }
        }
        return array;
    }
}
