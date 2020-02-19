package edu;

public class 选择排序 {
    public static void main(String[] args) {
        int a[] = {20,4,6,78,53,32};

        for(int j = 0 ; j < a.length - 1 ; j++) {
            int min = j;//查找过程中最小元素的索引
            for (int i = a.length - 1; i > j; i--) {
                if (a[i] < a[min]) {
                    min = i;
                }
            }
            int temp = a[j];
            a[j] = a[min];
            a[min] = temp;
        }
        for(int i = 0 ; i < a.length  ; i++){
            System.out.print(a[i] + " ");
        }
    }
}
