package edu.practice;

public class Test {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 2, 8, 5, 4};


        //冒泡排序
//        for (int i = 1; i < a.length; i++) {
//            for (int j = 1; j < a.length  - i; j++) {
//                if (a[j] > a[j + 1]) {
//                    int tmp = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = tmp;
//                }
//            }
//        }

        //插入排序
//        for (int i = 0; i < a.length - 1; i++) {
//            int index = i + 1;
//            int tmp = a[i + 1];//待排序的元素
//            //找到待插入的位置
//            for (int j = i; j >= 0; j--) {
//                if (a[j] > tmp) {
//                    index = j;
//                } else {
//                    break;
//                }
//            }
//            for (int j = i; j >= index; j--) {
//                a[j + 1] = a[j];
//            }
//            a[index] = tmp;
//        }

        //快排
//        quickSort(a);
//    }
//    //快速排序
//    private static void quickSort(int[] a) {
//        int i = 0;
//        int j = a.length - 1;
//        quickSortHelper(a, i, j);
//    }
//    private static void quickSortHelper(int[] a, int i, int j) {
//        if (i >= j) {
//            return;
//        }
//        int low = i;
//        int high = j;
//        int position = a[i];
//        while (low < high) {
//            while (low < high && a[high] > position) {
//                high--;
//            }
//            a[low] = a[high];
//            while (low < high && a[low] < position) {
//                low++;
//            }
//            a[high] = a[low];
//        }
//        a[low] = position;
//        quickSortHelper(a, i, low - 1);
//        quickSortHelper(a, low + 1, j);
//    }


        //选择排序
//        for (int i = 0; i < a.length; i++) {
//            int minIndex = i;
//            for (int j = i + 1; j < a.length; j++) {
//                if (a[minIndex] > a[j]) {
//                    minIndex = j;
//                }
//            }
//            swap(a, minIndex, i);
//        }




        for (int i : a) {
            System.out.print(i + " ");
        }

    }

    //交换方法
    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
