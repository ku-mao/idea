package edu.practice;


import java.util.Scanner;

public class Sort {
    /**
     * 冒泡排序
     */
    private void bubbleSort(int[] array) {
        for (int k = 1; k < array.length; k++) {
            for (int i = 0; i < array.length - k; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("请输入要排序数组的长度: ");
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        System.out.println("请输入要排序的数组: ");
        int[] array = new int[len];
        int i = 0;
        while (i < len) {
            array[i] = scanner.nextInt();
            i++;
        }
        Sort sort = new Sort();
        sort.bubbleSort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
