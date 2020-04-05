package edu;

public class TestDemo {
    public static void main(String[] args) {
        try {
            int[] array = {1,2,3};
            array = null;
            System.out.println(array[100]);
            System.out.println("hi");
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            System.out.println("捕获空指针异常");
        }
        System.out.println("************");
    }
}
