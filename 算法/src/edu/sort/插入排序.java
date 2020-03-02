package edu.sort;

public class 插入排序 {
    public static void main(String[] args) {
        int a[] = {4,65,21,3,45,5};
        for(int index = 0 ; index < a.length -1 ; index++){ //已排好数组的最后一个元素的索引
            int temp = a[index+1];//待插入元素的值
            int insert_index = index + 1;//待插入位置的索引,必须加1，因为可能会不交换

            //找到待插入位置的索引
            for(int i = index ; i >= 0 ; i-- ){
                if(temp < a[i]){
                    insert_index = i;
                }else {
                    break;
                }
            }
            //后移插入元素后面的元素
            for(int j = index ; j >= insert_index ; j--){
                a[j+1] = a [j];
            }
                a[insert_index] = temp;
        }
        for(int i = 0 ; i < a.length ; i++){
            System.out.print(a[i] + " ");
        }
    }
}
