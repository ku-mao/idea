package edu;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestPriorityQueue {
//    static class MyCom implements Comparator<Integer> {
//
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            return o1 - o2;
//        }
//    }
    public static void main(String[] args)  {
        /*
        这个代码是创建一个匿名内部类
        不知道类名是啥,但是知道这个类实现了Comparator接口
        */
        PriorityQueue<Integer> queue = new PriorityQueue <>(((o1, o2) -> o2 - o1));
            queue.offer(9);
            queue.offer(5);
            queue.offer(2);
            queue.offer(7);
            queue.offer(3);
            queue.offer(6);
            queue.offer(8);
            while (!queue.isEmpty()) {
                Integer cur = queue.poll();
                System.out.println(cur);
            }
        }
}
