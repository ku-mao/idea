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

    /**
     * 插入排序
     */
    public void insertSort(int[] arr) {
        for(int index = 0 ; index < arr.length -1 ; index++){ //已排好数组的最后一个元素的索引
            int temp = arr[index+1];//待插入元素的值
            int insert_index = index + 1;//待插入位置的索引,必须加1，因为可能会不交换

            //找到待插入位置的索引
            for(int i = index ; i >= 0 ; i-- ){
                if(temp < arr[i]){
                    insert_index = i;
                }else {
                    break;
                }
            }
            //后移插入元素后面的元素
            for(int j = index ; j >= insert_index ; j--){
                arr[j+1] = arr[j];
            }
            arr[insert_index] = temp;
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
        //sort.bubbleSort(array);
        sort.insertSort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
