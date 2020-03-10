package edu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 大于长度一半的数 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().trim().split(" ");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            if (stack.isEmpty()) stack.push(nums[i]);
            else if (nums[i] != stack.peek()) {
                stack.pop();
            }
        }
        if (!stack.isEmpty())
            System.out.println(stack.peek());
    }


}
