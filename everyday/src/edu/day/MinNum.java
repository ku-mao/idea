package edu.day;

import java.util.Scanner;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组大小:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("请输入数组:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(minNumberArray(arr));
    }
    private  static int minNumberArray(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (left < right) {
            if (right - left == 1) {
                return array[right];
            }
            mid = (right + left) / 2;
            //存在重复的元素
            if (array[left] == array[right] && array[mid] == array[right]) {
                for (int i = left; i < right; i++) {
                    if (array[i] < array[i++]) {
                        return array[i+1];
                    }
                }
            }
            //二分查找的方法
            if (array[left] <= array[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return array[mid];
    }
}
