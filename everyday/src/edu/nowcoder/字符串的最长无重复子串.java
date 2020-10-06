package edu.nowcoder;

public class 字符串的最长无重复子串 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 4,3 , 6, 8, 9};
        System.out.println(maxLength(arr));
    }
    private static int maxLength (int[] arr) {
        int max = 0;
        int count = 1;
        int start = 0;
        int end = 0;
        for (int i = 1; i < arr.length; i++) {
            int ret = find(arr, start, end, arr[i]);
            if (ret!= -1) {
                start = ret + 1;
                end = ret + 1;
                i = end;
                count = 1;
            } else {
                end++;
                count++;
                max = max > count ? max : count;
            }
        }
        return max;
    }
    private static int find(int[] arr, int start, int end, int num) {
        for (int i = start; i <= end; i++) {
            if (num == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
