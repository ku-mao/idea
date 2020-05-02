package edu.sort;

public class Sort {
    public static void insertSort(int array[]) {
        for(int bound = 1; bound < array.length; bound++) {
            //处理bound位置的元素怎么往前插入
            int tmp = array[bound];
            //需要从后往前,找到合适的位置进行插入
            int cur = bound - 1;
            for (; cur >= 0; cur--) {
                if(array[cur] > tmp) {
                    array[cur + 1] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }

    public static void shellSort(int[] array) {
        int gap = array.length / 2;
        while (gap > 1) {
            insertSortGap(array, gap);
            gap = gap / 2;
        }
        insertSortGap(array,1);

    }

    private static void insertSortGap(int[] array, int gap) {
        for (int bound = gap; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - gap;
            for (; cur >= 0; cur -= gap) {
                if(tmp < array[cur]) {
                    array[cur + gap] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + gap] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 6, 4, 3, 9, 7, 5};
        //insertSort(array);
        shellSort(array);
        for (int a :array) {
            System.out.print(a + " ");
        }
    }
}
