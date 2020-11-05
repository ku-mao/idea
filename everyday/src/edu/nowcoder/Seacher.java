package edu.nowcoder;

public class Seacher {
    public static void main(String[] args) {
        int[] a = {1, 2, 6, 7, 9, 10};
    }
    public int find(int[] a, int x) {
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (x > a[mid]) {
                i = mid + 1;
            } else if (x < a[mid]){
                j = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
