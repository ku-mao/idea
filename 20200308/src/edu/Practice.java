package edu;


import java.util.Scanner;

public class Practice {
    /**
     * 有一组数据，只有一个数字是出现一次，
     * 其他是两次，请找出这个数字
     */
    private static int singleNumber(int[] a) {
        int res = 0;
        for (int i : a) {
            res = res ^ a[i];
        }
        return res;
    }


    /**
     * 迭代实现斐波那契数列
     */
    private static void fib(int n) {
        int f1 = 1;
        int f2 = 1;

        int f3 = 1;
        for(int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        System.out.println(f3);
    }

    /**
     * 1! + 2! + 3! + ... + n!
     * @param n
     * @return
     */
    private static int facSum(int n) {
        int sum = 0;
        int ret = 1;
        for(int i = 1; i <= n; i++) {
            ret = ret * i;
            sum = sum + ret;
        }
        return sum;
    }

    /**
     * 计算n的阶乘
     * @param n
     * @return
     */
    private static int fac (int n) {
        int ret = 1;
        for(int i = 1; i <= n; i++) {
            ret = ret * i;
        }
        return ret;
    }

    /**
     * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
     * 不在乎奇数交换后的大小顺序
     * @param nums
     * @return
     */
    private static void exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 0) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                right--;
            } else {
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[] num = {1,5,6,8,4,32,8};
        exchange(num);
        for (int i : num) {
            System.out.print(i + " ");
        }
    }

    public static void main1(String[] args) {
        int[] a = {1, 3, 5, 6, 3, 6, 5, 1, 7};
        System.out.println("输出只输出一次的数字:" + singleNumber(a));


        System.out.println("请输入想要求得的斐波那契数列的第n项:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fib(n);

        System.out.println("n的阶乘为: " + fac(n));
        System.out.println("1到n的阶乘和为: " + facSum(n));
    }
}
