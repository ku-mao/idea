package edu.queue;

public class MyQueue {
    private int[] array = new int[100];
    private int head = 0;//队首元素的下标
    private int tail = 0;//队尾元素的下标
    private int size = 0;//队存的元素个数
    //有效范围[head,tail)前闭后开区间

    //如果插入失败,返回false
    //插入成功,返回true
    public boolean offer(int value) {
        if(size == array.length) {
            return false;
        }
        array[tail] = value;
        tail++;
        //以防为满
        if(tail >= array.length){
            tail = 0;
        }
//        tail = tail % array.length;
        size++;
        return true;
    }

    public Integer poll () {
        if(size == 0) {
            return null;
        }
        int ret = array[head];
        head ++;
        if(head >= array.length) {
            head = 0;
        }
        size--;
        return ret;
    }

    public Integer peek() {
        if(size == 0) {
            return null;
        }
        return array[head];
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);

        while (true) {
            Integer cur = myQueue.poll();
            if(cur == null) {
                break;
            }
            System.out.println(cur);
        }
        System.out.println(myQueue.peek());
    }





}
