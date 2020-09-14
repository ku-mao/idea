package edu.practice;

import java.util.Random;
import java.util.Scanner;


public class work {
    /**
     * 编写代码模拟三次密码输入的场景。
     * 最多能输入三次密码，密码正确，提示“登录成功”,
     * 密码错误， 可以重新输入，最多输入三次。
     * 三次均错，则提示退出程序
     */
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String password = "12345";
            System.out.println("请输入密码,有三次机会:");
            int count = 3;
            while (count > 0){
                String str = scanner.nextLine();
                if (password.equals(str)) {
                    System.out.println("密码正确,登录成功!");
                    break;
                } else {
                    count--;
                    if (count == 0){
                        System.out.println("三次输错密码 退出");
                    }else {
                        System.out.println("密码错误,你还有" + count +"次机会");
                    }
                }
            }
    }



    /**
     * 输出一个整数的每一位，如：123的每一位是1 ， 2 ， 3
     *
     */
    public static void main12(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        while (n > 0) {
            System.out.print(n % 10 + " ");
            n = n / 10;
        }
    }

    /**
     * 获取一个数二进制序列中所有的偶数位和奇数位，
     * 分别输出二进制序列
     * @param args
     */
    public static void main11(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.print("偶数位: ");
        for (int i = 31; i >= 1; i-=2){
            System.out.print(((n>>>i) & 1) + " ");
        }
        System.out.println();
        System.out.print("奇数位: ");
        for (int i = 30; i >= 0; i -= 2) {
            System.out.print(((n>>>i) & 1) + " ");
        }
    }


    /**
     * 写一个函数返回参数二进制中 1 的个数
     * @param args
     */
    public static void main10(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n-1);
        }
        System.out.println(count);
    }



    /**
     * 水仙花数
     * @param args
     */
    public static void main9(String[] args) {
        for (int i = 0; i <= 99999; i++) {
            int count = 0;
            int tmp = i;
            while (tmp != 0) {
                count++;
                tmp = tmp / 10;
            }
            tmp = i;
            int sum = 0;
            while (tmp != 0) {
                sum +=Math.pow(i%10,count);
                tmp = tmp / 10;
            }
            if(sum == i) {
                System.out.println(sum + "是要找的数字");
            }
        }
    }

    /**
     * 猜数字
     * @param args
     */
    public static void main8(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int num = random.nextInt(100);
        System.out.println("请猜数字:");
        while (true){
            int guess = scanner.nextInt();
            if(guess > num) {
                System.out.println("猜大了");
            } else if(guess < num) {
                System.out.println("猜小了");
            } else {
                System.out.println("恭喜你!猜对了");
                System.out.println("游戏结束");
                break;
            }
        }
    }


    /**
     *  1到 100 的所有整数中出现多少个数字9
     * @param args
     */
    public static void main7(String[] args) {
        int count = 0;
        for (int i = 1; i < 100; i++) {
            if(i /10 == 9 ) {
                count++;
            }
            if(i % 10 == 9) {
                count++;
            }
        }
        System.out.println("9的个数是:" + count);
    }
    
    
    
    /**
     * 计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
     */
    public static void main6(String[] args) {
        double res = 0;
        int sign = 1;
        for (int i = 1; i <= 100; i++) {
            res += 1.0/(sign*i);
            sign = -sign;
        }
        System.out.println(res);
    }




    /**
     * 最大公约数
     * @param args
     */
    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        while (num2 != 0) {
            int res = num1 % num2;
            num1 = num2;
            num2 = res;
        }
        System.out.println("最大公约数是: " + num1);
    }


    /**
     * 九九乘法表
     * @param args
     */
    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++ ) {
            for (int j = 1; j <= i; j++){
                System.out.print(j +"x" + i +"=" + j*i +" ");
            }
            System.out.println();
        }
    }

    /**
     * 输出 1000 - 2000 之间所有的闰年
     * @param args
     */
    public static void main3(String[] args) {
        for (int i = 1000; i <= 2000 ; i++) {
            if(( i % 4 == 0 && i % 100 != 0 ) ||(i % 400 == 0)) {
                System.out.println(i + "是闰年");
            }
        }
    }



    /**
     * 判断一个数字是否是素数
     * @param args
     */
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if(num == 1) {
            System.out.println("1不是素数");
            return;
        }
        int i = 2;
        while (i <= Math.sqrt(num)){
            if(num % i == 0) {
                System.out.println(num + "不是素数");
                break;
            }
            i++;
        }
        if(i > Math.sqrt(num)) {
            System.out.println(num + "是素数");
        }
    }

    /**
     * 根据年龄, 来打印出当前年龄的人是少年(低于18),
     * 青年(19-28), 中年(29-55), 老年(56以上)
     * @param args
     */
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int old = scanner.nextInt();
        if(old <= 18) {
            System.out.println("少年");
        } else if(old <= 28) {
            System.out.println("青年");
        } else if(old <= 55) {
            System.out.println("中年");
        } else {
            System.out.println("老年");
        }
    }
}
