package edu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Practice {
    static class Pair {
        int num1;
        int num2;
        int sum;

        public Pair(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
            this.sum = num1 + num2;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] num1, int[] num2, int k) {
        List<List<Integer>> result = new ArrayList <>();
        if(k <= 0) {
            return result;
        }

        //先准备一个堆,此处需要指定一个比较器对象,告诉优先级队列,什么样的情况算优先级高
        PriorityQueue<Pair> queue = new PriorityQueue <>(new Comparator <Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.sum - o2.sum;
            }
        });
        for(int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2.length; j++) {
                queue.offer(new Pair(num1[i], num2[j]));
            }
        }

        for(int i = 0; i < k && !queue.isEmpty(); i++) {
            Pair cur = queue.poll();
            List<Integer> tmp = new ArrayList <>();
            tmp.add(cur.num1);
            tmp.add(cur.num2);
            result.add(tmp);
        }
        return result;
    }
}
