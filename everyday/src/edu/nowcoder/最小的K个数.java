package edu.nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 最小的K个数 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input == null || k <= 0 || k > input.length){
            return list;
        } //按照数值从大到小
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
        for(int i = 0; i < input.length ; i++){
            if(i < k){
                queue.offer(input[i]);//前提前插入k个数据，queue会自动排序
            }else{
                 //否则，就要展开淘汰的过程了，每次都淘汰最大的，剩下的最终就是最小的k个
                if(input[i] < queue.peek()){ //input[i]比最大的小，跟新之
                    queue.poll();
                    queue.offer(input[i]);
                }
            }
        } //返回对应的结果
        for(int i = 0 ; i < k; i++){
            list.add(queue.poll());
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println("请输入一个数组的大小: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("请输入你想要最小的几个数: ");
        int k = scanner.nextInt();
        System.out.println(GetLeastNumbers_Solution(arr, k));
    }
}
