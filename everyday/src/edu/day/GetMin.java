package edu.day;

import java.util.ArrayList;
import java.util.Stack;

public class GetMin {
    public static void main(String[] args) {
        int[][] op = {{1, 3}, {1, 2}, {1, 1}, {3}, {2}, {3}};
        int[] res = getMinStack(op);
        for (int i : res) {
            System.out.print(i+" ");
        }
    }
    private static int[] getMinStack (int[][] op) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackMin = new Stack<>();
        for (int i = 0; i < op.length; i++) {
            if (op[i][0] == 1) {
                int num = op[i][1];
                stack.push(num);
                if (stackMin.isEmpty()) {
                    stackMin.push(num);
                } else {
                    if (stackMin.peek() < num){
                        stackMin.push(stackMin.peek());
                    } else {
                        stackMin.push(num);
                    }
                }
            } else if (op[i][0] == 2) {
                stack.pop();
                stackMin.pop();
            } else {
                list.add(stackMin.peek());
            }
        }
        int len = list.size();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
