package edu.day;

public class FindKth {
    public static void main(String[] args) {
        int[] arr = {2, 6, 4, 3, 8};
        int k = 3;
        System.out.println(findKth(arr, 5, k));
    }
    public static int findKth(int[] a, int n, int K) {
        return find(a, 0, n - 1, K);
    }
    public static int find(int[] a, int i, int j, int K) {
        int position =  quickSort(a, i, j);
        if (position - i + 1 == K) {
            return a[position];
        } else if (position - i + 1 > K) {
            return find(a, i, position - 1, K);
        }else {
            return find(a, position + 1, j, K- position + i - 1);
        }
    }
    //把大的放在前面, 小的放在后面
    public static int quickSort(int[] a, int i, int j) {
        int tmp = a[i];
        while (i < j) {
            while (i < j && a[j] <= tmp) {
                j--;
            }
            a[i]= a[j];
            while (i < j && a[i] >= tmp) {
                i++;
            }
            a[j] = a[i];
        }
        a[i] = tmp;
        return i;
    }
}
