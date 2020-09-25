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

    /**
     * 堆排序
     */

    public  void heapsort(int[] a) {

        for (int i = a.length - 1; i > 0; i--) {
            max_heapify(a, i);

            //堆顶元素(第一个元素)与Kn交换
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
        }
    }

    /***
     *
     *  将数组堆化
     *  i = 第一个非叶子节点。
     *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
     *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
     * 父节点i的左子节点在位置：(2*i+1);
     * 父节点i的右子节点在位置：(2*i+2);
     * 子节点i的父节点在位置：floor((i-1)/2)
     * @param a
     * @param n
     */
    private   void max_heapify(int[] a, int n) {
        int child;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            //左子节点位置
            child = 2 * i + 1;
            //右子节点存在且大于左子节点，child变成右子节点
            if (child != n && a[child] < a[child + 1]) {
                child++;
            }
            //交换父节点与左右子节点中的最大值
            if (a[i] < a[child]) {
                int temp = a[i];
                a[i] = a[child];
                a[child] = temp;
            }
        }
    }

    /**
     * 快速排序
     */
    private void quickSort(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        quickSortHelper(arr, i, j);
    }
    private void quickSortHelper(int[] arr, int i, int j) {
        if (i >= j) {
            return;
        }
        int low = i;
        int high = j;
        int position = arr[i];
        while (low < high) {
            while (low < high && arr[high] > position) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] < position) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = position;
        quickSortHelper(arr, i, low - 1);
        quickSortHelper(arr, low + 1, j);
    }

    /**
     * 选择排序
     */
    public void selSort(int[] arr) {
        for(int j = 0 ; j < arr.length - 1 ; j++) {
            int min = j;//查找过程中最小元素的索引
            for (int i = arr.length - 1; i > j; i--) {
                if (arr[i] < arr[min]) {
                    min = i;
                }
            }
            int temp = arr[j];
            arr[j] = arr[min];
            arr[min] = temp;
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
        //sort.insertSort(array);
        //sort.heapsort(array);
        //sort.quickSort(array);
        sort.selSort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
