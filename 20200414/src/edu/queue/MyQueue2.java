package edu.queue;

public class MyQueue2 {
    static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head = new Node(-1);
    private Node tail = head;

    public void offer(int val) {
        Node node = new Node(val);
        tail.next = node;
        tail = node;
    }

    public Integer poll() {
        if (head.next == null) {
            return null;
        }
        Node toDel = head.next;
        head.next = toDel.next;
        if (head.next == null) {
            tail = head;
        }
        return toDel.val;
    }

    public Integer peek() {
        if (head.next == null) {
            return null;
        }
        return head.next.val;
    }


    public static void main(String[] args) {
        MyQueue2 myQueue = new MyQueue2();
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