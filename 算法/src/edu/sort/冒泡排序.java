package edu.sort;

public class 冒泡排序 {
    public static void main(String[] args) {
        int a[] = {23,67,4,2,34,55,66};
        for(int k = 1 ; k <a.length -1 ;k++){
            for(int i = 0 ; i < a.length - 1 ; i++){
                if(a[i] > a[i+1]){
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                }
            }
        }
        for(int i = 0 ; i < a.length ; i++){
            System.out.print(a[i]+" ");
        }
    }
}
