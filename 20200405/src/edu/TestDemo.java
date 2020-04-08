package edu;

import java.util.InputMismatchException;
import java.util.Scanner;

class MyException extends Exception {

}
public class TestDemo {
     public  static void func4(int a) {
          if(a == 10) {
              try {
                  throw new MyException();
              } catch (MyException e) {
                  System.out.println("捕获MyException异常");
              }
          }

     }
    public static void main(String[] args) {
        func4(10);
    }


    public static void func3(int x, int y) throws ArithmeticException {
        if(y== 0) {
          throw new ArithmeticException("你的y==0 不能作为除数");
        }
        System.out.println(x/y);
    }
    public static void main6(String[] args) {
        try {
            func3(10,0);
        } catch (ArithmeticException e) {
            System.out.println("除数为0");
        }

    }


    //throws  声明一个异常 告诉程序员，需要处理此异常
    public static void func2() throws ArrayIndexOutOfBoundsException{
        int[] array = {1,2,3,4};
        System.out.println(array[200]);
    }

    public static void main5(String[] args) {
        try {
            func2();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界异常");
        }
    }


    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
         try {
             int n = scanner.nextInt();
             System.out.println(n);
         } catch (InputMismatchException e) {
             System.out.println("输入参数不匹配！");
         } finally {
             scanner.close();
         }
    }


    public static int func() {
        try {
            int a = 10;
            return a;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("捕获数组越界异常");
        } finally {
            System.out.println("finally被执行了");
            return 19;
        }
    }

    public static void main3(String[] args) {
        System.out.println(func());
    }


    public static void main2(String[] args) {
        try{
            int[] array = {1,2,3,4,5};
            System.out.println(array[100]);
            System.out.println("after");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("捕获数组越界异常");
        } finally {
            System.out.println("finally被执行了");
        }
        System.out.println("try catch 结束后执行");
    }

    public static void main1(String[] args) {
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
