package edu;

import java.util.Arrays;

public class TestDemo2 {
    public static int[] copyArray(int[] array){
        int[] ret = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            ret[i] = array[i];
        }
        return ret;
    }

    /**
     * System.arraycopy(array,a,ret,b,len)
     * array: 要拷贝的数组
     * a: 从a下标开始拷贝
     * ret: 目标数组
     * b: 放在目标位置的b下标
     * len: 要拷贝多长
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int[] ret = array.clone();
        System.out.println(Arrays.toString(ret));
//        int[] ret = Arrays.copyOf(array,array.length);//底层调用的是System.arraycopy方法
//        System.out.println(Arrays.toString(ret));

        //int[] ret = new int [array.length];
        //拷贝更快: 因为用了native修饰
        //System.arraycopy(array,0,ret,0,array.length);


        //第一种for循环的拷贝方式
//        int[] ret = copyArray(array);
//        System.out.println(Arrays.toString(ret));
    }


    /**
     * 自己实现toString方法
     * @param array
     * @return
     */
    public static String myToString (int[] array) {
        String ret = "[" ;
        for (int i = 0; i < array.length; i++) {
            ret += array[i] ;
            if(i != array.length - 1) {
                ret += ", ";
            }

        }
        ret += "]";
        return ret;
    }

    public static void main1(String[] args) {
      int[] array = {1, 2, 3, 3, 4};
        System.out.println(myToString(array));
    }
}
