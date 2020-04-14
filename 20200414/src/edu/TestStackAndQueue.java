package edu;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestStackAndQueue {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList <>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        while (!deque.isEmpty()) {
            System.out.println(deque.remove());
        }
    }


    /**
     * 标准库的队列
     */
    public static void main2(String[] args) {
        Queue<Integer> queue = new LinkedList <>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            System.out.println(cur);
        }

    }



    /**
     * 标准库中的栈
     * @param args
     */
    public static void main1(String[] args) {
        Stack<Integer> stack = new Stack <>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        //标准库中的Stack 如果针对空栈进行pop或真的很peek 就会抛出一个异常
        while (!stack.empty()) {
            Integer cur = stack.pop();
            System.out.println(cur);
        }
    }
}
