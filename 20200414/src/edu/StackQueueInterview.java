package edu;

import java.util.*;

public class StackQueueInterview {
    /**
     * 用栈实现队列
     */
    class MyQueue {
        Stack<Integer> A = new Stack <>();
        Stack<Integer> B = new Stack <>();

        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!B.isEmpty()) {
                Integer top = B.pop();
                A.push(top);
            }
            A.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(empty()) {
                return 0;
            }
            while (!A.isEmpty()) {
                Integer cur = A.pop();
                B.push(cur);
            }
            return B.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(empty()) {
                return 0;
            }
            while (!A.isEmpty()) {
                Integer cur = A.pop();
                B.push(cur);
            }
            return B.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return A.isEmpty() && B.isEmpty();
        }
    }

    /**
     * 用队列实现栈
     */
    class MyStack {
        Queue<Integer> A = new LinkedList <>();
        Queue<Integer> B = new LinkedList <>();

        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            A.offer(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (empty()) {
                return 0;
            }
            //把A中的元素移动到B中,A中的元素剩一个元素即可
            while (A.size() > 1) {
                Integer cur = A.poll();
                B.offer(cur);
            }
            int top = A.poll();
            swapAB();
            return top;
        }

        private void swapAB() {
            Queue<Integer> tmp = A;
            A = B;
            B = tmp;
        }

        /** Get the top element. */
        public int top() {
            if(empty()) {
                return 0;
            }
            while (A.size() > 1) {
                int cur = A.poll();
                B.offer(cur);
            }
            int top = A.poll();
            B.offer(top);
            swapAB();
            return top;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return (A.isEmpty() && B.isEmpty());
        }
    }




    /**
     * 查看括号字符串是否匹配
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if(s.isEmpty()) {
            return true;
        }

        Map<Character, Character> map = new HashMap <>();
        map.put(')', '(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> stack = new Stack <>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //如果是左括号 直接入栈
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            //不是左括号 但是此时栈为空
            if(stack.empty()) {
                return false;
            }
            //栈不空 此时括号是右括号,比较当前括号是否匹配
            Character top = stack.pop();
            if(map.get(c).equals(top)) {
                continue;
            }
            return false;
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入一个括号字符串:");
        String str = s.nextLine();
        System.out.print("是否匹配:" + " ");
        System.out.println(isValid(str));
    }
}
