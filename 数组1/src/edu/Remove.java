package edu;

import java.util.Scanner;

public class Remove {
    public static void main(String[] args) {
        System.out.println("请输入数组");
        Scanner s = new Scanner(System.in);
        String str = s.next();
        int length = Integer.parseInt(str);
        int nums[] = new int[length];
        for(int i = 0 ; i < length ; i++){
            nums[i] = s.nextInt();
        }
        System.out.println("请输入目标值：");
        Scanner s1 = new Scanner(System.in);
        int val = s1.nextInt();
        removeElement1(nums,val);
        removeElement2(nums,val);

    }

    //交换移除
    public  static int removeElement1(int[] nums, int val) {
        int n = nums.length;
        for(int i = 0 ; i < n ;){
            if(nums[i] == val){
                nums[i] = nums[n-1];
                n--;
            }
            else{
                i++;
            }
        }
        System.out.println(n);
        return n;
    }

    //覆盖移除
    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        System.out.println(i);
        return i;
    }

}
