package edu.sort;

public class 快速排序 {
    public static void main(String[] args) {
        int[] a ={34,67,8,3,42,52,56,8};
        int low = 0;
        int high = a.length - 1;
        sort(a,low,high);
        for(int i : a){
            System.out.print(i+" ");
        }
    }

    //递归的快速排序
    private static void sort(int[] a,int low,int high){
        if(low >= high) return;
        int left = low;
        int right = high;
        int point = a[left];
        while(left < right){
            while(left < right && a[right] >= point){
               right--;
            }
           a[left] = a[right];
            while(left < right && a[left] <= point){
                left++;
            }
            a[right] = a[left];
        }
         a[left] = point;
        sort(a,low,left-1);
        sort(a,left+1,high);

    }
}
