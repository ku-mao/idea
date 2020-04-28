package edu;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestPriorityQueue {
    static class MyCom implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }
    public static void main(String[] args)  {
        PriorityQueue<Integer> queue = new PriorityQueue <>(new MyCom());
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
