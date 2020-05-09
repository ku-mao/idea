package edu.sort;

import java.util.Arrays;
import java.util.Stack;

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
        for(int bound = 0; bound < array.length - 1; bound++) {
            for(int cur = bound + 1; cur < array.length; cur++) {
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
        for( int i = 0; i < array.length - 1; i++) {
            //交换堆顶元素和堆中的最后一个元素
            swap(array, 0, heapSize - 1);
            //删除堆中最后一个元素
            heapSize--;

            //针对当前堆从根节点进行向下调整
            shiftDown(array, heapSize, 0);
        }
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            //找出左右孩子中的最大值,然后与父节点进行比较
            if(child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                swap(array, parent, child);
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    private static void creatHeap(int[] array) {
        for(int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }


    /**
     * 冒泡排序
     * @param array
     */
    private static void bubbleSort(int[] array) {
        for(int bound = 0; bound < array.length - 1; bound++) {
            for (int cur = array.length - 1; cur > bound; cur--) {
                if(array[cur] < array[cur - 1]) {
                    swap(array, cur,cur - 1);
                }
            }
        }
    }


    private static void quickSort(int[] array) {
        quickSortHelper(array,0, array.length -1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(array, left, right);
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int base = array[right];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && array[i] <= base) {
                i++;
            }
            while (i < j && array[j] >= base) {
                j--;
            }
            swap(array, i, j);
        }
        swap(array, i, right);
        return i;
    }


    /**
     * 快速排序的非递归实现
     * 类比于二叉树的先序遍历的非递归实现
     * @param array
     */
    public static void quickSortByLoop(int[] array) {
        //栈中保存的元素相当于当前要进行partition操作的范围下标
        Stack<Integer> stack = new Stack <>();
        stack.push(0);
        stack.push(array.length - 1);
        while (!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();
            if(left >= right) {
                continue;
            }
            int index = partition(array, left, right);
            //把右子树入栈[index + 1, right]
            stack.push(index + 1);
            stack.push(right);
            //把左子树入栈[left, index - 1]
            stack.push(left);
            stack.push(index - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        //heapSort(array);
        //bubbleSort(array);
        //quickSort(array);
        quickSortByLoop(array);
        System.out.println(Arrays.toString(array));
    }
}
