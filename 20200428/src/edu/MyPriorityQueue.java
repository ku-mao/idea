package edu;

import java.util.LinkedList;
import java.util.Queue;

public class MyPriorityQueue {
    private int[] array = new int[100];
    private int size = 0;

    public void offer(int x) {
        array[size] = x;
        size++;
        //2.把x 进行向上调整即可
        //把第一个参数表示用来承载堆的数组
        //把第二个参数表示数组中有效元素的个数
        //把第三个参数表示从那个位置进行向上调整
        shiftUp(array, size, size - 1);
    }

    private void shiftUp(int[] array, int size, int index) {
        int child = index;
        int parent = (child - 1) /2;
        //如果child 为0,说明child已经是根节点,根节点就没有父节点
        //调整到这里已经到顶了
        while (child > 0){
            //比较当前child和parent 之间的大小关系,看看是否符合大堆
            if(array[parent] < array[child]) {
                //交换父子元素的内容
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
            } else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    public Integer poll() {
        if(size <= 0) {
            return null;
        }
        int ret = array[0];
        //1.把最后一个元素的值填入到0号元素上.
        array[0] = array[size - 1];
        //2.删除最后一个元素
        size--;
        //3.从0号下标开始进行向下调整
        shiftDown(array, size, 0);
        return ret;
    }

    public static void shiftDown(int[] arr, int size, int index) {
        int parent = index;
        //根据父节点下标,先找到左子树的下标
        int child = 2 * parent + 1;
        while (child < size) {
            if(child + 1 < size && arr[child + 1] > arr[child]) {
                child = child + 1;
            }

            if (arr[child] > arr[parent]) {
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    public Integer peek() {
        if(size <= 0) {
            return null;
        }
        return array[0];
    }
    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }
    public static void main(String[] args)  {
        MyPriorityQueue queue = new MyPriorityQueue();
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
