package edu.nowcoder;

import java.util.Scanner;

/**
 * 把一个数组最开始的若千个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE:给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class 旋转数组中的最小元素 {
    public static int minNumberInRotateArray(int [] array) {
        if (array == null || array.length < 0) {
            return 0;
        }
        int right = array.length - 1;
        int left = 0;
        int mid = 0;
        while (left < right) {
            if (right - left == 1) {
                return array[right];
            }
            mid = (left + right) >> 1;
            if (array[left] == array[right] && array[left] == array[mid]) {
                int min = array[left];
                for (int i = left + 1; i <= right; i++) {
                    if (array[left] > array[i]) {
                        min = array[i];
                    }
                }
                return min;
            }
            if (array[left] <= array[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return array[mid];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组的长度:");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("请输入旋转数组:");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(minNumberInRotateArray(array));
    }
}
