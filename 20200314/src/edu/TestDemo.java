package edu;

import java.util.Arrays;

public class TestDemo {
    /**
     * 非要把交换两个数封装在方法里
     * 无法拿到地址就放在数组里
     */

    private static void swap1(int[] array) {
        int tmp = array[0];
        array[0] = array[1];
        array[1] = tmp;
    }

    public static void main(String[] args) {
        int[] array1 = {10, 20};
        System.out.println(array1[0] + " " + array1[1]);
        swap1(array1);
        System.out.println(array1[0] + " " + array1[1]);
    }



    /**
     * 交换两个数(假交换)
     */
    private static void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }

    public static void main3(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("a = " + a + "b = " + b);
        swap(a, b);//这里只是交换了形参的值,实际并没有交换这里a b 的值
        System.out.println("a = " + a + "b = " + b);
    }


    /**
     * 打印数组
     * @param array
     */
    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main2(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        array1[0] = 999;
        print(array1);
        System.out.println(Arrays.toString(array1));
    }


    public static void main1(String[] args) {
        int[] array1 = new int[3];//定义,但没有初始化,但是默认值为0

        int[] array2 = {1, 2, 3, 4, 5};//定义且初始化了一个数组,数组大小为5

        int[] array3 = new int[] {1, 2, 3, 4, 5, 6};//定义且初始化了一个数组,数组大小为6

        for (int i = 0; i < array2.length; i++) {
            System.out.print(array1[i] + " ");
        }
        System.out.println("*******for each ******");
        for (int i : array2) {
            System.out.print(i + " ");
        }

        System.out.println("***将数组以字符串的形式输出***");
        System.out.println(Arrays.toString(array2));
    }




}
