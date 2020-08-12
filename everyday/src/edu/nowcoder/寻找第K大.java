package edu.nowcoder;

/**
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 *
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 */
public class 寻找第K大 {
    public int find(int[] a, int n, int k) {
        return findHelper(a, 0, n - 1, k);
    }

    private int findHelper(int[] a, int low, int high, int k) {
        int mid = position(a, low, high);
        if (mid - low + 1 == k) {
            return a[mid];
        } else if (mid - low + 1 > k) {
            return findHelper(a, low, mid - 1, k);
        } else {
            return findHelper(a, mid + 1, high, k - mid - low - 1);
        }
    }

    private int position(int[] a, int low, int high) {
        int p = a[low];
        //从大到小排
        while (low < high) {
            while (low < high && a[high] < p) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] > p) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = p;
        return low;
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 4, 6, 5, 9, 2};
        int n = a.length;
        int k = 3;
        寻找第K大 f = new 寻找第K大();
        System.out.println(f.find(a, n, k));
    }
}
