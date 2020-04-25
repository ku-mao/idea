package edu;

public class Practice {
    /**
     * 实现一个方法 printArray,
     * 以数组为参数, 循环访问数组中的每个元素, 打印每个元素的值.
     */
    private static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    /**
     * 实现一个方法 transform, 以数组为参数,
     * 循环将数组中的每个元素 乘以 2 , 并设置到对应的数组元素上.
     * 例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
     */
    private void transform(int[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = arr[i] * 2;
        }
    }

    /**
     * 实现一个方法 sum, 以数组为参数, 求数组所有元素之和.
     */
    private static int sum(int[] arr) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        return sum;
    }

    /**
     * 实现一个方法 avg, 以数组为参数,
     * 求数组中所有元素的平均值(注意方法的返回值类型).
     */
    private static double avg(int[] arr) {
        return (double)sum(arr) / arr.length;
    }

    /**
     * 给定一个有序整型数组, 实现二分查找
     */
    private static int binarySearch(int[] arr, int toFind) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (toFind < arr[mid]) {
                right = mid - 1;
            } else if (toFind > arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    /**
     * 给定一个整型数组, 实现冒泡排序(升序排序)
     */
    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for(int j = 0; j < arr.length - i; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }


    /**
     * 给定一个整型数组, 判定数组是否有序（递增)
     */
    private static boolean isSort(int[] arr) {
        for (int i = 0; i < arr.length -1 ; i++) {
            if(arr[i] > arr[i+1]) {
               return false;
            }
        }
        return true;
    }


    private static void array() {
        int[] arr = new int[100];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1,5,6,3,8,2};
        System.out.println(isSort(arr));
        sort(arr);
        System.out.println(isSort(arr));
    }
    public static void main1(String[] args) {
        //array();
        int[] arr = {1, 2, 3, 4};
        System.out.println(avg(arr));
    }
}
