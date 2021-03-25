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
     * 冒泡优化1
     * 对于整片数字来说是有顺序 但是整体没有顺序
     * 采用标记标记, 若此次排序没有交换数据说明已经排好顺序
     */
    private void bubbleSort1(int[] array) {
        int n = array.length;
        boolean flag = true;//是否交换数据
        for (int i = 1; i < n && flag; i++) {
            flag = false;
            for (int j = 0; j < n - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = true;
                }
            }
        }
    }

    /**
     * 冒泡排序优化2
     * 对于前面大部分数据未排序, 后面少部分有序的情况, 第一种优化方案就效率不高了
     * 现在记录排序上次最后一个交换的位置, 这个位置后面的数字肯定是有序的
     */
    private void bubbleSort2(int[] a) {
        int n = a.length;
        boolean flag = true;
        int right = n - 1;
        int last = right;
        for (int i = 1; i < n && flag; i++) {
            flag = false;
            for (int j = 0; j < right; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                    last = j;
                }
            }
            right = last;
        }
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
            if(j != min) {
                int temp = arr[j];
                arr[j] = arr[min];
                arr[min] = temp;
            }
        }
    }

    /**
     * 选择排序优化
     * 不管你的数据如何时间复杂度都是o(n^2)
     * 但是我们可以同时找出最大和最小的, 减少排序次数
     */

    private void selSort1(int[] arr) {
        int n = arr.length;
        int p = n - 1; //存放未排序中最大元素的下标
        for(int i = 0; i < n/2; i++, p--) {
            int min = i;
            int max = i;
            for (int j = i + 1; j <= p; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
                if (arr[max] < arr[j]) {
                    max = j;
                }
            }
            //把最大元素和p位置的元素交换
            int tmp = arr[p];
            arr[p] = arr[max];
            arr[max] = tmp;

            if (i != min) {
                tmp = arr[i];
                if (min == p) {//有一种特殊情况, 就是min刚好与p的的位置重合, 最大值交换后, min变成了最大的, 原来的最小的被换走了
                    arr[i] = arr[max];
                    arr[max] = tmp;
                } else {
                    arr[i] = arr[min];
                    arr[min] = tmp;
                }
            }
        }
    }

    /**
     * 插入排序
     */
    private void insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {//待排元素下标
            int tmp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > tmp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tmp;
        }
    }

    /**
     * 插入排序的优化, 在查找待查元素的位置时, 采用2分查找
     */
    private void insertSort1(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] > tmp) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            for (int j = i - 1; j >= low; j--) {
                arr[j + 1] = arr[j];
            }
            arr[low] = tmp;
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
     * 希尔排序
     */
    private  void shellSort(int[] a) {
        // 计算出最大的h值
        int h = 1;
        while (h <= a.length / 3) {
            h = h * 3 + 1;
        }
        for (; h >= 1; h /= 3) {
            for (int i = 0; i < a.length - h; i += h) {
                for (int j = i + h; j > 0; j -= h) {
                    if (a[j] < a[j - h]) {
                        int temp = a[j];
                        a[j] = a[j - h];
                        a[j - h] = temp;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 7, 6, 4, 9};
        Sort sort = new Sort();
        //sort.bubbleSort1(arr);
        //sort.bubbleSort2(arr);
        //sort.selSort1(arr);
        //sort.insertSort(arr);
        sort.insertSort1(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    public static void main1(String[] args) {
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
        //sort.selSort(array);
        sort.shellSort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
