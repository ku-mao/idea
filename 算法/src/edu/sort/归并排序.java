package edu.sort;

import edu.集合.Test.Student;

import java.util.ArrayList;
import java.util.List;

public class 归并排序 {
    /**
     * 递归  合并
     */
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Student(20,"dai",'M'));
        list.add(new Student(2,"dai",'M'));
        list.add(new Student(10,"dai",'M'));
        list.add(new Student(80,"dai",'M'));
        list.add(new Student(28,"dai",'M'));
        edu.sort.归并排序.sort(list);
        System.out.println(list);

    }
    public static void sort(List list){
        int left = 0;
        int right = list.size() - 1;
        divide(list,left,right);
    }

    private static void divide(List list, int left, int right) {
        int mid = (left+right)/2;
        if(left < right){
            divide(list,left,mid);
            divide(list,mid+1,right);
            merge(list,left,mid,mid+1,right);
        }
    }

    private static void merge(List list, int left, int mid, int i, int right) {
        Object[] temp = new Object[list.size()];
        int ls = left,le = mid;
        int rs = i ,re = right;
        int index = left;
        while(ls <= le && rs <= re){
            Comparable c1 = (Comparable) list.get(ls);
            Comparable c2 = (Comparable) list.get(rs);
            if(c1.compareTo(c2)== -1){
                temp[index++] = c1;
                ls++;
            }else {
                temp[index++] = c2;
                rs++;
            }
        }
       //左边有剩余
        if(ls<=le){
            for (int j = ls; j <= le ; j++) {
                temp[index++] = list.get(j);
            }
        }
        //右边有剩余
        if(rs<=re){
            for (int j = rs; j <= re ; j++) {
                temp[index++] = list.get(j);
            }
        }
        for (int j = left; j <= right; j++) {
            list.set(j,temp[j]);
        }
    }
}
