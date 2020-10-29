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
        for (int i = 0; i < a.length - 1; i++) {
            int index = i + 1;
            int tmp = a[i + 1];//待排序的元素
            //找到待插入的位置
            for (int j = i; j >= 0; j--) {
                if (a[j] > tmp) {
                    index = j;
                } else {
                    break;
                }
            }
            for (int j = i; j >= index; j--) {
                a[j + 1] = a[j];
            }
            a[index] = tmp;
        }
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
