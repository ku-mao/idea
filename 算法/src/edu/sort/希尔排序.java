package edu.sort;

public class 希尔排序 {

    public static void main(String[] args) {

        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        shellSort(data);
    }

    public static void shellSort(int[] data) {
        // 计算出最大的h值
        int h = 1;
        while (h <= data.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (int i = h; i < data.length; i += h) {
                if (data[i] < data[i - h]) {
                    int tmp = data[i];
                    int j = i - h;
                    while (j >= 0 && data[j] > tmp) {
                        data[j + h] = data[j];
                        j -= h;
                    }
                    data[j + h] = tmp;
                }
            }
            // 计算出下一个h值
            h = (h - 1) / 3;
        }
        for( int i : data){
            System.out.print(i+" ");
        }
    }
}
