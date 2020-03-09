package edu.sort;

public class 希尔排序 {

    public static void main(String[] args) {

        int[] a = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        shellSort(a);
    }

    public static void shellSort(int[] a) {
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
        for( int i : a){
            System.out.print(i+" ");
        }
    }
}
