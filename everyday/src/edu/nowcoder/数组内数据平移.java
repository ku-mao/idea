package edu.nowcoder;

public class 数组内数据平移 {
    /**
     * 数组内数据循环平移
     * @param arr int整型一维数组 输入数组
     * @param pushOffset int整型 位移长度
     * @return int整型一维数组
     */
    public static int[] pushIntArray (int[] arr, int pushOffset) {
        int len = arr.length;
        int count = pushOffset % len;
        while (count > 0) {
            int tmp = arr[len - 1];
            for (int i = len - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = tmp;
            count--;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        pushIntArray(arr, 7);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
