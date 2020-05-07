package edu.sort;

public class Sort {
    /**
     * 插入排序
     * @param array
     */
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


    /**
     * 希尔排序
     * @param array
     */
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


    /**
     * 选择排序
     * @param array
     */
    private static void selectSort(int[] array) {
        for(int bound = 0; bound < array.length; bound++) {
            for(int cur = bound; cur < array.length; cur++) {
                if(array[cur] < array[bound]) {
                    swap(array, cur, bound);
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    /**
     * 堆排序
     * @param array
     */
    private static void heapSort(int[] array) {
        //建立堆
        creatHeap(array);
        int heapSize = array.length;
        for( int i = 0; i < array.length; i++) {
            //交换对顶元素和堆中的最后一个元素
            swap(array, 0, heapSize - 1);
            heapSize--;

            //向下调整
            shiftDown(array, heapSize, i);
        }
    }

    private static void shiftDown(int[] array, int heapSize, int i) {

    }

    private static void creatHeap(int[] array) {
        for(int i = (array.length - 1 - 1) / 2; i >= 0; i++) {
            shiftDown(array, array.length, i);
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
